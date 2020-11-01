package hm.springapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import hm.springapi.dao.entity.Budget;
import hm.springapi.dao.entity.BudgetCategory;
import hm.springapi.dao.entity.BudgetRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BudgetService {

    private final BudgetRepository budgetRepository;

    //TODO ArrayListにそろえる
    public List<Budget> findAll() {
        return budgetRepository.findAll();
    }
    
    public ArrayList<Budget> findByBudgetCategoryId(Long budgetCategoryId) {
        return budgetRepository.findByBudgetCategoryId(budgetCategoryId);
    }
    
    public String createBudget(Budget budget) {

    	Date date = new Date();
//    	TODO userIDをログイン情報から取得
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