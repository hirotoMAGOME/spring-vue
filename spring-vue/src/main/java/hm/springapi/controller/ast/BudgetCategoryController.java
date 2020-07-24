package hm.springapi.controller.ast;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
