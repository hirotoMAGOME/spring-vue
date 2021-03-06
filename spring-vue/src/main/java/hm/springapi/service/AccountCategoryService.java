package hm.springapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import hm.springapi.dao.entity.AccountCategory;
import hm.springapi.dao.entity.AccountCategoryRepository;

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
//    	TODO userIDをログイン情報から取得
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