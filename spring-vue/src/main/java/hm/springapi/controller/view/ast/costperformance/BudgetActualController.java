package hm.springapi.controller.view.ast.costperformance;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hm.springapi.controller.view.ast.costperformance.dto.BudgetActualGetRes;
import hm.springapi.controller.view.ast.costperformance.dto.BudgetCategoriesBudgets;
import hm.springapi.controller.view.ast.costperformance.dto.BudgetsActuals;
import hm.springapi.dao.entity.Account;
import hm.springapi.dao.entity.Actual;
import hm.springapi.dao.entity.Budget;
import hm.springapi.dao.entity.BudgetCategory;
import hm.springapi.service.AccountService;
import hm.springapi.service.ActualService;
import hm.springapi.service.BudgetCategoryService;
import hm.springapi.service.BudgetService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BudgetActualController {

    private final BudgetCategoryService budgetCategoryService;
    private final BudgetService budgetService;
    private final ActualService actualService;
    private final AccountService accountService;

    @GetMapping("/api/ast/asset-budget-actual")
    @CrossOrigin
    public ResponseEntity<BudgetActualGetRes> findAll(@RequestParam("appropriateMonth") Date appropriateMonth) {
    	//appropriateMonth: "2020/11/16aaa"　でも通ってしまうので、バリデーションを入れる必要あり(BudgetControllerと同じ)
        //appropriateMonthの必須チェックは
    	

    	
    	System.out.println(appropriateMonth);System.out.println(appropriateMonth);System.out.println(appropriateMonth);
        //レスポンスの第1階層セット用インスタンス
        ArrayList <BudgetCategoriesBudgets> budgetCategoriesBudgets = new ArrayList<>();
        ArrayList <BudgetsActuals> budgetsActuals = new ArrayList<>();
        ArrayList <Account> accounts = new ArrayList<>();
    	
        //budgetCategoryの全件取得
        List<BudgetCategory> budgetCategoryAll = budgetCategoryService.findAll();
        
        //全件ループ(bc=budget_category)
        budgetCategoryAll.forEach(bc -> {
        	//budgetCategoryIdを指定してBudgetを取得
        	ArrayList<Budget> budgetTemp = budgetService.findByBudgetCategoryIdAndAppropriateMonth(bc.getId(),appropriateMonth);
        	
        	//全件ループ(b=budget)
        	budgetTemp.forEach(b -> {
            	//budgetCategoriesBudgetsの作成
            	BudgetCategoriesBudgets addBudgetCategory = new BudgetCategoriesBudgets();
            	
            	//actualの合計金額用の変数
        		ArrayList<Integer> sumPrice = new ArrayList<Integer>();

        		//Actualの取得
        		ArrayList<Actual> actualTemp = actualService.findByBudgetId(b.getId());
                
        		//TODO かなり無駄なループ、GROUP BYで解決する
        		//全件ループ(a=actual)
        		actualTemp.forEach(a -> {
            		sumPrice.add(a.getPrice());
            	});
        		
            	addBudgetCategory.setBudgetCategoryId(bc.getId());
                addBudgetCategory.setBudgetCategoryType(bc
                		.getBudgetCategoryType());
                addBudgetCategory.setBudgetId(b.getId());
                addBudgetCategory.setBudgetName(b.getName());
                addBudgetCategory.setAmount(b.getAmount());
                addBudgetCategory.setPrice(sumPrice.stream().mapToInt(i -> i).sum());

                //budgetCategoriesBudgetsの保存
                budgetCategoriesBudgets.add(addBudgetCategory);
        	});
        	
        });
        
        
        //budgetCategoryの全件取得
        List<Budget> budgetAll = budgetService.findAll();
        budgetAll.forEach(b2 -> {
        	//budgetActualsの作成
        	BudgetsActuals addBudgetsActuals = new BudgetsActuals();
        	
    		//Actualの取得
    		ArrayList<Actual> actualTemp = actualService.findByBudgetId(b2.getId());

    		addBudgetsActuals.setId(b2.getId());
    		addBudgetsActuals.setName(b2.getName());
    		addBudgetsActuals.setActuals(actualTemp);
    		
            //budgetCategoriesの保存
    		budgetsActuals.add(addBudgetsActuals);
        });
        
        //accountの全件取得
         accounts = accountService.findByIdIsNotNullOrderBySort();
//        accounts = accountService.findAll();
    
        //レスポンスにセット
        BudgetActualGetRes budgetActualGetResponse = BudgetActualGetRes.builder()
                .budgetCategoriesBudgets(budgetCategoriesBudgets)
                .budgetsActuals(budgetsActuals)
                .accounts(accounts)
                .build();        
        
        return new ResponseEntity<>(budgetActualGetResponse, HttpStatus.OK);
    }
    
}
