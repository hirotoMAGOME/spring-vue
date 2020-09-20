package hm.springapi.controller.ast.assetmaster;

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
import hm.springapi.domain.Budget;
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
    
//    @PatchMapping("/api/ast/budget-category")
//    @CrossOrigin
//    @ResponseBody
//    public String postBudgetCategory(@RequestBody BudgetCategoryPostReq body) {
//    	BudgetCategory budgetCategory = new BudgetCategory();
//    	budgetCategory.setId(body.getId());
//    	budgetCategory.setName(body.getName());
//    	budgetCategory.setBudgetCategoryType(body.getBudgetCategoryType());
//    	
//    	return budgetCategoryService.createBudgetCategory(budgetCategory);
//    }
    
//    @DeleteMapping("/api/ast/budget-category/{id}")
//    @CrossOrigin
//    @ResponseBody
//    public String deleteBudgetCategory(@PathVariable Long id) {
//    	return budgetCategoryService.deleteBudgetCategory(id);
//    }
}
