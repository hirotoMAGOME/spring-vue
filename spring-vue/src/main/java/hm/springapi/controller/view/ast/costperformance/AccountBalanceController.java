package hm.springapi.controller.view.ast.costperformance;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hm.springapi.controller.view.ast.costperformance.AccountBalanceResponse;
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

//    @GetMapping("/api/ast/account-balance")
//    @CrossOrigin
//    public ResponseEntity<AccountBalanceResponse> findAll() {
//        List<AccountBalance> accountBalances = accountBalanceService.findAll();
//        AccountBalanceResponse accountBalanceResponse = AccountBalanceResponse.builder()
//                .accountBalances(accountBalances)
//                .build();
//        
//        return new ResponseEntity<>(accountBalanceResponse, HttpStatus.OK);
//    }
    
    @GetMapping("/api/ast/account-balance")
    @CrossOrigin
    public ResponseEntity<AccountBalanceResponse> findAll() {
        List<AccountBalance> accountBalancesAll = accountBalanceService.findAll();
        
        ArrayList <Long> checkList = new ArrayList<>();
        ArrayList <AccountBalance> accountBalances = new ArrayList<>();

        //最も最近の日付をとる処理が抜けてる。加えて、accountIdとcurrencyIdの複合キーで最新日付をとる必要がある。
        accountBalancesAll.forEach(s -> {

            Long id = s.getId();
            Long accountId = s.getAccountId();

            if(!checkList.contains(accountId)) {

                //OPtionalの使い方わからず
             	AccountBalance addAccountBalance = accountBalanceService.findById(id).orElse(null);

            	accountBalances.add(addAccountBalance);
            	checkList.add(accountId);
            }
        });

        
        AccountBalanceResponse accountBalanceResponse = AccountBalanceResponse.builder()
                .accountBalances(accountBalances)
                .build();

        return new ResponseEntity<>(accountBalanceResponse, HttpStatus.OK);
    }

    @GetMapping("/api/ast/account-balance-history")
    @CrossOrigin
    public ResponseEntity<AccountBalanceResponse> findByAccountId(@RequestParam("accountId") Long accountId) {
        
        List<AccountBalance> accountBalanceHistories = accountBalanceService.findByAccountId(accountId);
        AccountBalanceResponse accountBalanceResponse = AccountBalanceResponse.builder()
                .accountBalances(accountBalanceHistories)
                .build();

        return new ResponseEntity<>(accountBalanceResponse, HttpStatus.OK);
    }

    @GetMapping("/api/ast/account-balance-management")
    @CrossOrigin
    public ResponseEntity<AccountBalanceManagementGetRes> accountBalanceManagement() {
        //レスポンスの第1階層セット用インスタンス
        ArrayList <AccountBalance> latestAccountBalance = new ArrayList<>();
        ArrayList <AccountBalanceHistory> accountBalanceHistory = new ArrayList<>();
    	
    	//全取得
        List<AccountBalance> accountBalancesAll = accountBalanceService.findAll();
        
        //ループ対象チェック用
        ArrayList<String> accountIdCurrencyIdFinishedList = new ArrayList<String>();
        
        //全件ループ
        accountBalancesAll.forEach(s -> {
        	//作業済みかどうかの照合用の文字列
            String checkTemp = "{" + s.getAccountId() + "," + s.getCurrencyId() + "}";

            //accountIdとcurrencyIdの組み合わせごとに配列を作成する
            if(!accountIdCurrencyIdFinishedList.contains(checkTemp)) {
            	//accountIdとcurrencyIdを指定してAccountBalanceを取得
            	ArrayList<AccountBalance> accountBalanceHistoryFiltered = accountBalanceService.findByAccountIdAndCurrencyId(s.getAccountId(),s.getCurrencyId());
            	
            	//accountBalanceHistoryの作成
                AccountBalanceHistory accountBalanceHistoryTemp = new AccountBalanceHistory();
                
                accountBalanceHistoryTemp.setAccountId(s.getAccountId());
                accountBalanceHistoryTemp.setCurrencyId(s.getCurrencyId());
                accountBalanceHistoryTemp.setAccountBalanceHistoryFiltered(accountBalanceHistoryFiltered);
            	
                //accountBalanceHistoryの保存
                accountBalanceHistory.add(accountBalanceHistoryTemp);
                
                //latestAccountBalanceの作成
                AccountBalance addAccountBalance = accountBalanceHistoryFiltered.stream().max(Comparator.comparing(AccountBalance::getRecordedAt)).orElse(null);
                
                //latestAccountBalanceの保存
                latestAccountBalance.add(addAccountBalance);
                
                //完了したaccountIdとcurrencyIdの組み合わせを作業済みとして保存
                accountIdCurrencyIdFinishedList.add(checkTemp);
            }

        });

        //レスポンスの作成
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
