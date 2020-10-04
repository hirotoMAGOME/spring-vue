package hm.springapi.controller.view.ast.assetmaster;

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

import hm.springapi.controller.view.ast.assetmaster.dto.AccountDeleteReq;
import hm.springapi.controller.view.ast.assetmaster.dto.AccountPostReq;
import hm.springapi.domain.Account;
import hm.springapi.service.AccountService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/api/ast/account")
    @CrossOrigin
    public ResponseEntity<AccountResponse> findAll() {
        List<Account> accounts = accountService.findAll();
        AccountResponse accountResponse = AccountResponse.builder()
                .accounts(accounts)
                .build();
        
        return new ResponseEntity<>(accountResponse, HttpStatus.OK);
    }
    
    @PatchMapping("/api/ast/account")
    @CrossOrigin
    @ResponseBody
    public String postAccount(@RequestBody AccountPostReq body) {
    	Account account = new Account();
    	account.setId(body.getId());
    	account.setName(body.getName());
    	account.setAccountCategoryId(body.getAccountCategoryId());
    	
    	return accountService.createAccount(account);
    }
    
    @DeleteMapping("/api/ast/account/{id}")
    @CrossOrigin
    @ResponseBody
    public String deleteAccount(@PathVariable Long id) {
//    	TODO ó\éZÇ™àÍêÿïRÇ√Ç©Ç»Ç¢Ç±Ç∆ÇämîFÇÃè„çÌèú
    	return accountService.deleteAccount(id);
    }
}
