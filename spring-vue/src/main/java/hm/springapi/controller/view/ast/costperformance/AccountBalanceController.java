package hm.springapi.controller.view.ast.costperformance;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hm.springapi.controller.view.ast.costperformance.AccountBalanceResponse;
import hm.springapi.dao.entity.AccountBalance;
import hm.springapi.service.AccountBalanceService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

        accountBalancesAll.forEach(s -> {

            Long id = s.getId();
            Long accountId = s.getAccountId();

            if(!checkList.contains(accountId)) {

                //OPtional‚ÌŽg‚¢•û‚í‚©‚ç‚¸
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
    
    
}
