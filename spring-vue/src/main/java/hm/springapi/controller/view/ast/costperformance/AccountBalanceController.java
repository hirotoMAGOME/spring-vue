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

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountBalanceController {

    private final AccountBalanceService accountBalanceService;

    @GetMapping("/api/ast/account-balance")
    @CrossOrigin
    public ResponseEntity<AccountBalanceResponse> findAll() {
        List<AccountBalance> accountBalances = accountBalanceService.findAll();
        AccountBalanceResponse accountBalanceResponse = AccountBalanceResponse.builder()
                .accountBalances(accountBalances)
                .build();
        
        return new ResponseEntity<>(accountBalanceResponse, HttpStatus.OK);
    }
    
}
