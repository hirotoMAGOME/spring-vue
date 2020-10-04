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

import hm.springapi.controller.view.ast.assetmaster.dto.AccountCategoryDeleteReq;
import hm.springapi.controller.view.ast.assetmaster.dto.AccountCategoryPostReq;
import hm.springapi.domain.AccountCategory;
import hm.springapi.service.AccountCategoryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountCategoryController {

    private final AccountCategoryService accountCategoryService;

    @GetMapping("/api/ast/account-category")
    @CrossOrigin
    public ResponseEntity<AccountCategoryResponse> findAll() {
        List<AccountCategory> accountCategories = accountCategoryService.findAll();
        AccountCategoryResponse accountCategoryResponse = AccountCategoryResponse.builder()
                .accountCategories(accountCategories)
                .build();
        
        return new ResponseEntity<>(accountCategoryResponse, HttpStatus.OK);
    }
    
    @PatchMapping("/api/ast/account-category")
    @CrossOrigin
    @ResponseBody
    public String postAccountCategory(@RequestBody AccountCategoryPostReq body) {
    	AccountCategory accountCategory = new AccountCategory();
    	accountCategory.setId(body.getId());
    	accountCategory.setName(body.getName());
    	
    	return accountCategoryService.createAccountCategory(accountCategory);
    }
    
    @DeleteMapping("/api/ast/account-category/{id}")
    @CrossOrigin
    @ResponseBody
    public String deleteAccountCategory(@PathVariable Long id) {
//    	TODO ó\éZÇ™àÍêÿïRÇ√Ç©Ç»Ç¢Ç±Ç∆ÇämîFÇÃè„çÌèú
    	return accountCategoryService.deleteAccountCategory(id);
    }
}
