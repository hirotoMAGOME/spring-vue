package hm.springapi.controller.view.ast.costperformance;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hm.springapi.controller.view.ast.costperformance.dto.BudgetActualGetRes;
import hm.springapi.controller.view.ast.costperformance.dto.BudgetCategoriesBudgets;
import hm.springapi.dao.entity.Actual;
import hm.springapi.dao.entity.Budget;
import hm.springapi.dao.entity.BudgetCategory;
import hm.springapi.service.ActualService;
import hm.springapi.service.BudgetCategoryService;
import hm.springapi.service.BudgetService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BudgetActualController {

    private final BudgetCategoryService budgetCategoryService;
    private final BudgetService budgetService;
    private final ActualService actualService;

    @GetMapping("/api/ast/asset-budget-actual")
    @CrossOrigin
    public ResponseEntity<BudgetActualGetRes> findAll() {
        //レスポンスの第1階層セット用インスタンス
        ArrayList <BudgetCategoriesBudgets> budgetCategories = new ArrayList<>();
    	
        //budgetCategoryの全件取得
        List<BudgetCategory> budgetCategoryAll = budgetCategoryService.findAll();
        
        //全件ループ(bc=budget_category)
        budgetCategoryAll.forEach(bc -> {
        	//budgetCategoryIdを指定してBudgetを取得
        	ArrayList<Budget> budgetTemp = budgetService.findByBudgetCategoryId(bc.getId());
        	//budgetCategoriesの作成
        	BudgetCategoriesBudgets addBudgetCategory = new BudgetCategoriesBudgets();

        	//全件ループ(b=budget)
        	budgetTemp.forEach(b -> {
            	//actualの合計金額用の変数
        		ArrayList<Integer> sumPrice = new ArrayList<Integer>();

        		//Actualの取得
        		ArrayList<Actual> actualTemp = actualService.findByBudgetId(b.getId());
                
        		//TODO かなり無駄なループ、GROUP BYで解決する
        		//全件ループ(a=actual)
        		actualTemp.forEach(a -> {
            		sumPrice.add(a.getPrice());
            		System.out.println(a.getPrice());
            	});
        		
            	addBudgetCategory.setBudgetCategoryId(bc.getId());
                addBudgetCategory.setBudgetCategoryType(bc
                		.getBudgetCategoryType());
                //budgetIdに同じ値が重複されてセットされてしまう。初期化できていないか、最終ループで更新されている。
                addBudgetCategory.setBudgetId(b.getId());
                addBudgetCategory.setBudgetName(b.getName());
                addBudgetCategory.setAmount(b.getAmount());
                //TODO 値が0のまま
                addBudgetCategory.setPrice(sumPrice.stream().mapToInt(i -> i).sum());
//
//                double test = sumPrice.stream().mapToDouble(i -> i).sum();
//                System.out.println("test");
//                System.out.println(b.getId());


                //budgetCategoriesの保存
                budgetCategories.add(addBudgetCategory);
        	});
        	
        });
        BudgetActualGetRes budgetActualGetResponse = BudgetActualGetRes.builder()
                .budgetCategories(budgetCategories)
                .build();        
        
        
        return new ResponseEntity<>(budgetActualGetResponse, HttpStatus.OK);
    }
    
}
