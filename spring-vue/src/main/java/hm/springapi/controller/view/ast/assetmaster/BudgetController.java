package hm.springapi.controller.view.ast.assetmaster;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hm.springapi.controller.ast.assetmaster.BudgetResponse;
import hm.springapi.controller.view.ast.assetmaster.dto.BudgetPostReq;
import hm.springapi.dao.entity.Actual;
import hm.springapi.dao.entity.Budget;
import hm.springapi.service.BudgetService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BudgetController {

    private final BudgetService budgetService;

    @GetMapping("/api/ast/budget")
    @CrossOrigin
     
    public ResponseEntity<BudgetResponse> findAll() {
        List<Budget> budgets = budgetService.findAll();
        BudgetResponse budgetResponse = BudgetResponse.builder()
                .budgets(budgets)
                .build();
        
        return new ResponseEntity<>(budgetResponse, HttpStatus.OK);
    }
    
    @PatchMapping("/api/ast/budget")
    @CrossOrigin
    @ResponseBody
    public String postBudget(@RequestBody BudgetPostReq body) {
    	Budget budget = new Budget();
    	budget.setId(body.getId());
//TODO appropriateMonthÇÕñ¢é¿ëï
    	budget.setBudgetCategoryId(body.getBudgetCategoryId());
    	budget.setName(body.getName());
    	budget.setAmount(body.getAmount());

    	
    	return budgetService.createBudget(budget);
    }
    
    @DeleteMapping("/api/ast/budget/{id}")
    @CrossOrigin
    @ResponseBody
    public String deleteBudget(@PathVariable Long id) {
//    	TODO ó\éZÇ™àÍêÿïRÇ√Ç©Ç»Ç¢Ç±Ç∆ÇämîFÇÃè„çÌèú
    	return budgetService.deleteBudget(id);
    }
}
