package hm.springapi.controller.ast.assetmaster;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import hm.springapi.domain.BudgetCategory;
import hm.springapi.service.BudgetCategoryService;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

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
    

    
    @PostMapping("/api/ast/budget-category")
    @CrossOrigin
    //TODO オブジェクトにしたい
//    public String receiveBudgetCategory(BudgetCategory budgetCategory) {
    public String receiveBudgetCategory(@RequestBody String body) {

    	BudgetCategory budgetCategory = new BudgetCategory();
    	budgetCategory.setName("aiu");
    	
    	return budgetCategoryService.createBudgetCategory(budgetCategory);
    }
}
