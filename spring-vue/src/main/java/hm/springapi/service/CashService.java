//–¢Žg—p
package hm.springapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import hm.springapi.domain.Budget;
import hm.springapi.domain.BudgetRepository;
import hm.springapi.domain.Actual;
import hm.springapi.domain.ActualRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CashService {

    private final BudgetRepository budgetRepository;

    public List<Budget> findAll() {
        return budgetRepository.findAll();
    }
    
    private final ActualRepository actualRepository;
    
    public String createActual() {
    	Actual actual = new Actual();
    	actual.setBudgetId(1);
    	actual.setAccountId(1);
    	actual.setPrice(999);
    	actual.setName("test");
//    	actual.setCreatedAt(java.sql.Date.valueOf("2020-01-01 00:00:00"));
//    	actual.setCreatedUserId(1);
//    	actual.setUpdatedAt(java.sql.Date.valueOf("2020-01-01 00:00:00"));
    	
    	actualRepository.save(actual);
    	
    	return "success!!";
    }
}