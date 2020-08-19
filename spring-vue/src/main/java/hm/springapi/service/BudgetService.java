package hm.springapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import hm.springapi.domain.Budget;
import hm.springapi.domain.BudgetRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BudgetService {

    private final BudgetRepository budgetRepository;

    public List<Budget> findAll() {
        return budgetRepository.findAll();
    }
    
//    public String createBudgetCategory(BudgetCategory budgetCategory) {
//
//    	Date date = new Date();
//    	budgetCategory.setUserId((long)1);
//    	budgetCategory.setCreatedAt(date);
//    	budgetCategory.setUpdatedAt(date);
//    	
//    	budgetCategoryRepository.save(budgetCategory);
//    	
//    	return "success!!";
//    }
    
//    public String deleteBudgetCategory(Long id) {
//    	
//    	budgetCategoryRepository.deleteById(id);
//    	
//    	return "success!!";
//    }
}