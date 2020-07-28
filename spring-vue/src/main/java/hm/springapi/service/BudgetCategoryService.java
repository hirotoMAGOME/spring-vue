package hm.springapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import hm.springapi.domain.BudgetCategory;
import hm.springapi.domain.BudgetCategoryRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BudgetCategoryService {

    private final BudgetCategoryRepository budgetCategoryRepository;

    public List<BudgetCategory> findAll() {
        return budgetCategoryRepository.findAll();
    }
    
    public String createBudgetCategory() {
    	//TODO DBÇÃNOW()ÇégÇ¡ÇΩï˚Ç™Ç¢Ç¢ÅH
    	LocalDateTime now = LocalDateTime.now();
    	
    	BudgetCategory budgetCategory = new BudgetCategory();
    	
    	java.lang.System.out.println("bbbbbbbbb1");
    	java.lang.System.out.println(budgetCategory.getName());
    	java.lang.System.out.println("aaaaaaaaaa1");
    	
    	
    	budgetCategory.setUserId((long)1);
    	budgetCategory.setName("test2");
    	budgetCategory.setFixedFlg(true);
    	budgetCategory.setCreatedAt(java.sql.Date.valueOf("2020-01-02"));
    	budgetCategory.setUpdatedAt(java.sql.Date.valueOf("2020-01-02"));
    	
    	java.lang.System.out.println("bbbbbbbbb1");
    	java.lang.System.out.println(budgetCategory.getName());
    	java.lang.System.out.println("aaaaaaaaaa1");
    	
    	budgetCategoryRepository.save(budgetCategory);
    	
    	return "success!!";
    }
}