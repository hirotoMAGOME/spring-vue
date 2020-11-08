package hm.springapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import hm.springapi.dao.entity.Actual;
import hm.springapi.dao.entity.ActualRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActualService {

    private final ActualRepository actualRepository;

    public List<Actual> findAll() {
        return actualRepository.findAll();
    }

	public ArrayList<Actual> findByBudgetId(Long budgetId) {
		return actualRepository.findByBudgetId(budgetId);
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