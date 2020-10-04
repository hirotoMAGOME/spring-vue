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

import hm.springapi.controller.view.ast.assetmaster.dto.BudgetCategoryPostReq;
import hm.springapi.domain.BudgetCategory;
import hm.springapi.service.BudgetCategoryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BudgetCategoryController {

    private final BudgetCategoryService budgetCategoryService;

    @GetMapping("/api/ast/budget-category")
    @CrossOrigin
    public ResponseEntity<BudgetCategoryResponse> findAll() {
        List<BudgetCategory> budgetCategories = budgetCategoryService.findAll();
        BudgetCategoryResponse budgetCategoryResponse = BudgetCategoryResponse.builder()
                .budgetCategories(budgetCategories)
                .build();
        
        return new ResponseEntity<>(budgetCategoryResponse, HttpStatus.OK);
    }
    
    @PatchMapping("/api/ast/budget-category")
    @CrossOrigin
    @ResponseBody
    public String postBudgetCategory(@RequestBody BudgetCategoryPostReq body) {
    	BudgetCategory budgetCategory = new BudgetCategory();
    	budgetCategory.setId(body.getId());
    	budgetCategory.setName(body.getName());
    	budgetCategory.setBudgetCategoryType(body.getBudgetCategoryType());
    	
    	return budgetCategoryService.createBudgetCategory(budgetCategory);
    }
    
    @DeleteMapping("/api/ast/budget-category/{id}")
    @CrossOrigin
    @ResponseBody
    public String deleteBudgetCategory(@PathVariable Long id) {
//    	TODO ó\éZÇ™àÍêÿïRÇ√Ç©Ç»Ç¢Ç±Ç∆ÇämîFÇÃè„çÌèú
    	return budgetCategoryService.deleteBudgetCategory(id);
    }
}
