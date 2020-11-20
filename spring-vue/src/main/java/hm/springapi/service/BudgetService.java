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

    //TODO ArrayListÇ…ÇªÇÎÇ¶ÇÈ
    public List<Budget> findAll() {
        return budgetRepository.findAll();
    }
    
    public ArrayList<Budget> findByBudgetCategoryId(Long budgetCategoryId) {
        return budgetRepository.findByBudgetCategoryId(budgetCategoryId);
    }

    public String createBudget(Budget budget) {

    	Date date = new Date();
//    	TODO userIDÇÉçÉOÉCÉìèÓïÒÇ©ÇÁéÊìæ
    	budget.setCreatedAt(date);
    	budget.setUpdatedAt(date);
    	budget.setCreatedUserId((long)2);
    	budget.setUpdatedUserId((long)2);
    	budgetRepository.save(budget);
    	
    	return "success!!";
    }
    
    public String deleteBudget(Long id) {
    	
    	budgetRepository.deleteById(id);
    	
    	return "success!!";
    }
    
    //AST_02_ó\éZAPI_GET
    public ArrayList<Budget> findByAppropriateMonthIsNull() {
        return budgetRepository.findByAppropriateMonthIsNull();
    }
    public Budget findFirst1ByAppropriateMonthNotNullOrderByAppropriateMonthDesc() {
    	
    	return budgetRepository.findFirst1ByAppropriateMonthNotNullOrderByAppropriateMonthDesc();
    }
    
    //
    public ArrayList<Budget> findByCreatedUserId(Long createdUserId) {
    	
    	return budgetRepository.findByCreatedUserId(createdUserId);
    }
    
    public ArrayList<Budget> findByCreatedUserIdAndAppropriateMonth(Long createdUserId,Date appropriateMonth) {
    	
    	return budgetRepository.findByCreatedUserIdAndAppropriateMonth(createdUserId,appropriateMonth);
    }
    
}