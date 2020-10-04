package hm.springapi.controller.view.ast.costperformance;

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
public class CostPerformanceController {

    private final BudgetService budgetService;

    @GetMapping("/api/ast/cost-performance")
    @CrossOrigin
    public ResponseEntity<BudgetResponse> findAll() {
        List<Budget> budgets = budgetService.findAll();
        BudgetResponse budgetResponse = BudgetResponse.builder()
                .budgets(budgets)
                .build();
        
        return new ResponseEntity<>(budgetResponse, HttpStatus.OK);
    }
    
}
