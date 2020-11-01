package hm.springapi.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import hm.springapi.dao.entity.BudgetCategory;
import hm.springapi.dao.entity.BudgetCategoryRepository;
import hm.springapi.dao.entity.BudgetRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BudgetCategoryService {

    private final BudgetCategoryRepository budgetCategoryRepository;

    public List<BudgetCategory> findAll() {
        return budgetCategoryRepository.findAll();
    }
    
    public String createBudgetCategory(BudgetCategory budgetCategory) {

    	Date date = new Date();
//    	TODO userID‚ğƒƒOƒCƒ“î•ñ‚©‚çæ“¾
    	budgetCategory.setUserId((long)1);
    	budgetCategory.setCreatedAt(date);
    	budgetCategory.setUpdatedAt(date);
    	
    	budgetCategoryRepository.save(budgetCategory);
    	
    	return "success!!";
    }
    
    public String deleteBudgetCategory(Long id) {
    	
    	budgetCategoryRepository.deleteById(id);
    	
    	return "success!!";
    }
}