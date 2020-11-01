package hm.springapi.controller.view.ast.costperformance;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hm.springapi.controller.view.ast.costperformance.dto.AccountBalanceManagementGetRes;
import hm.springapi.controller.view.ast.costperformance.dto.AccountBalanceHistory;
import hm.springapi.controller.view.ast.costperformance.dto.AccountBalancePostReq;
import hm.springapi.dao.entity.AccountBalance;
import hm.springapi.service.AccountBalanceService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountBalanceController {

    private final AccountBalanceService accountBalanceService;

    @GetMapping("/api/ast/account-balance-management")
    @CrossOrigin
    public ResponseEntity<AccountBalanceManagementGetRes> accountBalanceManagement() {
        //���X�|���X�̑�1�K�w�Z�b�g�p�C���X�^���X
        ArrayList <AccountBalance> latestAccountBalance = new ArrayList<>();
        ArrayList <AccountBalanceHistory> accountBalanceHistory = new ArrayList<>();
    	
    	//�S�擾
        List<AccountBalance> accountBalancesAll = accountBalanceService.findAll();
        
        //���[�v�Ώۃ`�F�b�N�p
        ArrayList<String> accountIdCurrencyIdFinishedList = new ArrayList<String>();
        
        //�S�����[�v
        accountBalancesAll.forEach(s -> {
        	//��ƍς݂��ǂ����̏ƍ��p�̕�����
            String checkTemp = "{" + s.getAccountId() + "," + s.getCurrencyId() + "}";

            //accountId��currencyId�̑g�ݍ��킹���Ƃɔz����쐬����
            if(!accountIdCurrencyIdFinishedList.contains(checkTemp)) {
            	//accountId��currencyId���w�肵��AccountBalance���擾
            	ArrayList<AccountBalance> accountBalanceHistoryFiltered = accountBalanceService.findByAccountIdAndCurrencyId(s.getAccountId(),s.getCurrencyId());
            	
            	//accountBalanceHistory�̍쐬
                AccountBalanceHistory accountBalanceHistoryTemp = new AccountBalanceHistory();
                
                accountBalanceHistoryTemp.setAccountId(s.getAccountId());
                accountBalanceHistoryTemp.setCurrencyId(s.getCurrencyId());
                accountBalanceHistoryTemp.setAccountBalanceHistoryFiltered(accountBalanceHistoryFiltered);
            	
                //accountBalanceHistory�̕ۑ�
                accountBalanceHistory.add(accountBalanceHistoryTemp);
                
                //latestAccountBalance�̍쐬
                AccountBalance addAccountBalance = accountBalanceHistoryFiltered.stream().max(Comparator.comparing(AccountBalance::getRecordedAt)).orElse(null);
                
                //latestAccountBalance�̕ۑ�
                latestAccountBalance.add(addAccountBalance);
                
                //��������accountId��currencyId�̑g�ݍ��킹����ƍς݂Ƃ��ĕۑ�
                accountIdCurrencyIdFinishedList.add(checkTemp);
            }

        });

        //���X�|���X�̍쐬
    	AccountBalanceManagementGetRes accountBalanceManagementResponse = AccountBalanceManagementGetRes.builder()
                .latestAccountBalance(latestAccountBalance)
                .accountBalanceHistory(accountBalanceHistory)
                .build();

        return new ResponseEntity<>(accountBalanceManagementResponse, HttpStatus.OK);
    }
    
    @PostMapping("/api/ast/account-balance")
    @CrossOrigin
    @ResponseBody
    public String postAccountBalance(@RequestBody AccountBalancePostReq body) {
    	AccountBalance accountBalance = new AccountBalance();
    	accountBalance.setAccountId(body.getAccountId());
    	accountBalance.setRecordedAt(body.getRecordedAt());
    	accountBalance.setBalance(body.getBalance());
    	accountBalance.setCurrencyId(body.getCurrencyId());
    	
    	return accountBalanceService.createAccountBalance(accountBalance);
    }
}
