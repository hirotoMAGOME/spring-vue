package hm.springapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import hm.springapi.domain.Budget;
import hm.springapi.domain.BudgetCategory;
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
    
    public String createBudget(Budget budget) {

    	Date date = new Date();
//    	TODO userID‚ğƒƒOƒCƒ“î•ñ‚©‚çæ“¾
    	budget.setCreatedAt(date);
    	budget.setUpdatedAt(date);
    	budget.setCreatedUserId((long)1);
    	budget.setUpdatedUserId((long)1);
    	budgetRepository.save(budget);
    	
    	return "success!!";
    }
    
    public String deleteBudget(Long id) {
    	
    	budgetRepository.deleteById(id);
    	
    	return "success!!";
    }
}