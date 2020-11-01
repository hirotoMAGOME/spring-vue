package hm.springapi.controller.view.ast.costperformance;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hm.springapi.controller.view.ast.costperformance.dto.BudgetActualGetRes;
import hm.springapi.controller.view.ast.costperformance.dto.BudgetCategoriesBudgets;
import hm.springapi.dao.entity.Budget;
import hm.springapi.dao.entity.BudgetCategory;
import hm.springapi.service.BudgetCategoryService;
import hm.springapi.service.BudgetService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BudgetActualController {

    private final BudgetCategoryService budgetCategoryService;
    private final BudgetService budgetService;

    @GetMapping("/api/ast/asset-budget-actual")
    @CrossOrigin
    public ResponseEntity<BudgetActualGetRes> findAll() {
        //レスポンスの第1階層セット用インスタンス
        ArrayList <BudgetCategoriesBudgets> budgetCategories = new ArrayList<>();
    	
        //budgetCategoryの全件取得
        List<BudgetCategory> budgetCategoryAll = budgetCategoryService.findAll();
        
        //全件ループ
        budgetCategoryAll.forEach(s -> {
        	//budgetCategoryIdを指定してBudgetを取得
        	ArrayList<Budget> budgetTemp = budgetService.findByBudgetCategoryId(s.getId());
        	
        	//budgetCategoriesの作成
        	BudgetCategoriesBudgets addBudgetCategory = new BudgetCategoriesBudgets();
            
        	addBudgetCategory.setBudgetCategoryId(s.getId());
            addBudgetCategory.setName(s.getName());
            addBudgetCategory.setBudgetCategoryType(s.getBudgetCategoryType());
            addBudgetCategory.setBudgets(budgetTemp);
            
            //budgetCategoriesの保存
            budgetCategories.add(addBudgetCategory);
        	
        });
        BudgetActualGetRes budgetActualGetResponse = BudgetActualGetRes.builder()
                .budgetCategories(budgetCategories)
                .build();        
        
        
        return new ResponseEntity<>(budgetActualGetResponse, HttpStatus.OK);
    }
    
}
