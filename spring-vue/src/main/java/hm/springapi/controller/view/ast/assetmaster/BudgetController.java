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
    	//budgets�̎擾
    	//TODO LEFT JOIN BudgetCategory�Ń��[�U�[ID�ōi��
        List<Budget> budgets = budgetService.findByAppropriateMonthIsNull();
        
        //latestAppropriateMonth�̎擾        
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
//TODO appropriateMonth�͖�����
    	budget.setBudgetCategoryId(body.getBudgetCategoryId());
    	budget.setName(body.getName());
    	budget.setAmount(body.getAmount());

    	
    	return budgetService.createBudget(budget);
    }
    
    @DeleteMapping("/api/ast/budget/{id}")
    @CrossOrigin
    @ResponseBody
    public String deleteBudget(@PathVariable Long id) {
//    	TODO �\�Z����ؕR�Â��Ȃ����Ƃ��m�F�̏�폜
    	return budgetService.deleteBudget(id);
    }
    
    //TODO userId�͌Œ�l��2���Z�b�g�B��������budet�̓o�^�̎�����userId�ǂ��Ȃ��Ă������H
    @PatchMapping("/api/ast/budget-fix")
    @CrossOrigin
    @ResponseBody
    public String budgetFix(@RequestBody BudgetFixPostReq body) {
    	//TODO ���N�G�X�g�̌^�`�F�b�N���ł��ĂȂ�
    	//appropriateMonth: "2020-11-16aaa"�@�ł��ʂ��Ă��܂��̂ŁA�o���f�[�V����������K�v����
    	System.out.println("aaaaaaaaaaaaa");
    	System.out.println(body.getAppropriateMonth());
    	//body:2020-11-01
    	//TODO �Ɩ��`�F�b�N
    	
    	Date requestFirstDate = getFirstDate(body.getAppropriateMonth());

    	Date today = new Date();
   		Date firstDate = getFirstDate(today);
    		
       	if(requestFirstDate.compareTo(firstDate) < 0) {
       		//TODO ERROR����ʂɕԂ�
       		System.out.println("�ߋ��̗\�Z�͊m��ł��܂���");
       	}
        	
       	ArrayList<Budget> checkAlreadyExist = budgetService.findByCreatedUserIdAndAppropriateMonth(body.getUserId(),requestFirstDate);

       	if(checkAlreadyExist.size() > 0) {
       		//TODO ERROR��Ԃ�
       		System.out.println("���ɗ\�Z���m��ς݂ł�");
       	}
        	
    	
    	//�X�V
    	if(body.getAppropriateMonth() == null ) {
    		
    	}
    	Long tempUserId = (long) 2;
    	//TODO userId�͌Œ�l�ł͂Ȃ����N�G�X�g���g�p����Bbody.getUserId()
        ArrayList<Budget> budgets = budgetService.findByCreatedUserIdAndAppropriateMonth(tempUserId,null);

        budgets.forEach(b -> {
        	Budget registBudget = new Budget();
        	
        	//�v��N���̓��N�G�X�g����擾�B����ȊO�̓R�s�[�����Q��
        	registBudget.setAppropriateMonth(requestFirstDate);
        	registBudget.setBudgetCategoryId(b.getBudgetCategoryId());
        	registBudget.setAmount(b.getAmount());
        	registBudget.setName(b.getName());
        	
        	//�ۑ�
        	budgetService.createBudget(registBudget);
        });
        
        return "success!!";
        
    }
    
    
	// ��������Ԃ�
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
