package hm.springapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import hm.springapi.domain.BudgetCategory;
import hm.springapi.domain.BudgetCategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BudgetCategoryService {

    private final BudgetCategoryRepository budgetCategoryRepository;

    public List<BudgetCategory> findAll() {
        return budgetCategoryRepository.findAll();
    }
    
    public String createBudgetCategory() {
    	BudgetCategory budgetCategory = new BudgetCategory();
    	budgetCategory.setId((long)10);
    	budgetCategory.setUserId((long)1);
    	budgetCategory.setName("test");
    	budgetCategory.setFixedFlg(true);
    	budgetCategory.setCreatedAt(java.sql.Date.valueOf("2020-01-01"));
    	budgetCategory.setUpdatedAt(java.sql.Date.valueOf("2020-01-01"));
    	budgetCategory.setDeletedAt(java.sql.Date.valueOf("2020-01-01"));
    	
    	budgetCategoryRepository.save(budgetCategory);
    	
    	return "success!!";
    }
}