package hm.springapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import hm.springapi.domain.BudgetCategory;
import hm.springapi.domain.BudgetCategoryRepository;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
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
//    	TODO userIDをログイン情報から取得
    	budgetCategory.setUserId((long)1);
    	budgetCategory.setCreatedAt(date);
    	budgetCategory.setUpdatedAt(date);
    	
    	budgetCategoryRepository.save(budgetCategory);
    	
    	return "success!!";
    }
}