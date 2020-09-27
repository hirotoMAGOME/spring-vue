package hm.springapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import hm.springapi.domain.AccountCategory;
import hm.springapi.domain.AccountCategoryRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountCategoryService {

    private final AccountCategoryRepository accountCategoryRepository;

    public List<AccountCategory> findAll() {
        return accountCategoryRepository.findAll();
    }
    
    public String createAccountCategory(AccountCategory accountCategory) {
    	
    	Date date = new Date();
//    	TODO userID‚ğƒƒOƒCƒ“î•ñ‚©‚çæ“¾
    	accountCategory.setUserId((long)1);
    	accountCategory.setCreatedAt(date);
    	accountCategory.setUpdatedAt(date);
    	
    	accountCategoryRepository.save(accountCategory);
    	
    	return "success!!";
    }
    
    public String deleteAccountCategory(Long id) {
    	
    	accountCategoryRepository.deleteById(id);
    	
    	return "success!!";
    }
}