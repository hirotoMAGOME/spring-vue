package hm.springapi.controller.ast.actual;

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

import hm.springapi.controller.ast.actual.ActualResponse;
import hm.springapi.dao.entity.Actual;
import hm.springapi.service.ActualService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ActualController {

    private final ActualService actualService;

    @GetMapping("/api/ast/actual")
    @CrossOrigin
    public ResponseEntity<ActualResponse> findAll() {
        List<Actual> actuals = actualService.findAll();
        ActualResponse actualResponse = ActualResponse.builder()
                .actuals(actuals)
                .build();
        
        return new ResponseEntity<>(actualResponse, HttpStatus.OK);
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
