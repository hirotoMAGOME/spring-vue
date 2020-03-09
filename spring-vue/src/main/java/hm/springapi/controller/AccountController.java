package hm.springapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import hm.springapi.domain.Account;
import hm.springapi.service.AccountService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/")
    public ResponseEntity<AccountResponse> findAll() {
        List<Account> accounts = accountService.findAll();
        AccountResponse accountResponse = AccountResponse.builder()
                .accounts(accounts)
                .build();
        return new ResponseEntity<>(accountResponse, HttpStatus.OK);
    }
    
}