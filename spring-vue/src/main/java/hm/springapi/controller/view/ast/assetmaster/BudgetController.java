package hm.springapi.controller.view.ast.assetmaster;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hm.springapi.controller.view.ast.assetmaster.dto.BudgetFixPostReq;
import hm.springapi.controller.view.ast.assetmaster.dto.BudgetGetResponse;
import hm.springapi.controller.view.ast.assetmaster.dto.BudgetPostReq;
import hm.springapi.dao.entity.Budget;
import hm.springapi.service.BudgetService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BudgetController {

    private final BudgetService budgetService;

    @GetMapping("/api/ast/budget")
    @CrossOrigin
    public ResponseEntity<BudgetGetResponse> findAll() {
    	//budgetsの取得
    	//TODO LEFT JOIN BudgetCategoryでユーザーIDで絞る
        List<Budget> budgets = budgetService.findByAppropriateMonthIsNull();
        
        //latestAppropriateMonthの取得        
        Budget latestFixedBudget = new Budget();
        latestFixedBudget = budgetService.findFirst1ByAppropriateMonthNotNullOrderByAppropriateMonthDesc();
        
        Date latestAppropriateMonth = new Date();
        latestAppropriateMonth = latestFixedBudget.getAppropriateMonth();
        
        BudgetGetResponse budgetGetResponse = BudgetGetResponse.builder()
                .budgets(budgets)
                .latestAppropriateMonth(latestAppropriateMonth)
                .build();
        
		return new ResponseEntity<>(budgetGetResponse, HttpStatus.OK);
    }
    
    @PatchMapping("/api/ast/budget")
    @CrossOrigin
    @ResponseBody
    public String postBudget(@RequestBody BudgetPostReq body) {
    	Budget budget = new Budget();
    	budget.setId(body.getId());
//TODO appropriateMonthは未実装
    	budget.setBudgetCategoryId(body.getBudgetCategoryId());
    	budget.setName(body.getName());
    	budget.setAmount(body.getAmount());

    	
    	return budgetService.createBudget(budget);
    }
    
    @DeleteMapping("/api/ast/budget/{id}")
    @CrossOrigin
    @ResponseBody
    public String deleteBudget(@PathVariable Long id) {
//    	TODO 予算が一切紐づかないことを確認の上削除
    	return budgetService.deleteBudget(id);
    }
    
    //TODO userIdは固定値で2をセット。そもそもbudetの登録の時ってuserIdどうなってたっけ？
    @PatchMapping("/api/ast/budget-fix")
    @CrossOrigin
    @ResponseBody
    public String budgetFix(@RequestBody BudgetFixPostReq body) {
    	//TODO リクエストの型チェックができてない
    	//appropriateMonth: "2020-11-16aaa"　でも通ってしまうので、バリデーションを入れる必要あり
    	System.out.println("aaaaaaaaaaaaa");
    	System.out.println(body.getAppropriateMonth());
    	//body:2020-11-01
    	//TODO 業務チェック
    	
    	Date requestFirstDate = getFirstDate(body.getAppropriateMonth());

    	Date today = new Date();
   		Date firstDate = getFirstDate(today);
    		
       	if(requestFirstDate.compareTo(firstDate) < 0) {
       		//TODO ERRORを画面に返す
       		System.out.println("過去の予算は確定できません");
       	}
        	
       	ArrayList<Budget> checkAlreadyExist = budgetService.findByCreatedUserIdAndAppropriateMonth(body.getUserId(),requestFirstDate);

       	if(checkAlreadyExist.size() > 0) {
       		//TODO ERRORを返す
       		System.out.println("既に予算を確定済みです");
       	}
        	
    	
    	//更新
    	if(body.getAppropriateMonth() == null ) {
    		
    	}
    	Long tempUserId = (long) 2;
    	//TODO userIdは固定値ではなくリクエストを使用する。body.getUserId()
        ArrayList<Budget> budgets = budgetService.findByCreatedUserIdAndAppropriateMonth(tempUserId,null);

        budgets.forEach(b -> {
        	Budget registBudget = new Budget();
        	
        	//計上年月はリクエストから取得。それ以外はコピー元を参照
        	registBudget.setAppropriateMonth(requestFirstDate);
        	registBudget.setBudgetCategoryId(b.getBudgetCategoryId());
        	registBudget.setAmount(b.getAmount());
        	registBudget.setName(b.getName());
        	
        	//保存
        	budgetService.createBudget(registBudget);
        });
        
        return "success!!";
        
    }
    
    
	// 月初日を返す
	public static Date getFirstDate(Date date) {

		if (date==null) return null;

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int first = calendar.getActualMinimum(Calendar.DATE);
		calendar.set(Calendar.DATE, first);

		calendar.set(Calendar.HOUR_OF_DAY, 00);
		calendar.set(Calendar.MINUTE, 00);
		calendar.set(Calendar.SECOND, 00);
		calendar.set(Calendar.MILLISECOND, 000);

		return calendar.getTime();
	}
}
