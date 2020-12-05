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
    	//appropriateMonth: "2020/11/16aaa"�@�ł��ʂ��Ă��܂��̂ŁA�o���f�[�V����������K�v����(BudgetController�Ɠ���)
        //appropriateMonth�̕K�{�`�F�b�N��
    	

    	
    	System.out.println(appropriateMonth);System.out.println(appropriateMonth);System.out.println(appropriateMonth);
        //���X�|���X�̑�1�K�w�Z�b�g�p�C���X�^���X
        ArrayList <BudgetCategoriesBudgets> budgetCategoriesBudgets = new ArrayList<>();
        ArrayList <BudgetsActuals> budgetsActuals = new ArrayList<>();
        ArrayList <Account> accounts = new ArrayList<>();
    	
        //budgetCategory�̑S���擾
        List<BudgetCategory> budgetCategoryAll = budgetCategoryService.findAll();
        
        //�S�����[�v(bc=budget_category)
        budgetCategoryAll.forEach(bc -> {
        	//budgetCategoryId���w�肵��Budget���擾
        	ArrayList<Budget> budgetTemp = budgetService.findByBudgetCategoryIdAndAppropriateMonth(bc.getId(),appropriateMonth);
        	
        	//�S�����[�v(b=budget)
        	budgetTemp.forEach(b -> {
            	//budgetCategoriesBudgets�̍쐬
            	BudgetCategoriesBudgets addBudgetCategory = new BudgetCategoriesBudgets();
            	
            	//actual�̍��v���z�p�̕ϐ�
        		ArrayList<Integer> sumPrice = new ArrayList<Integer>();

        		//Actual�̎擾
        		ArrayList<Actual> actualTemp = actualService.findByBudgetId(b.getId());
                
        		//TODO ���Ȃ薳�ʂȃ��[�v�AGROUP BY�ŉ�������
        		//�S�����[�v(a=actual)
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

                //budgetCategoriesBudgets�̕ۑ�
                budgetCategoriesBudgets.add(addBudgetCategory);
        	});
        	
        });
        
        
        //budgetCategory�̑S���擾
        List<Budget> budgetAll = budgetService.findAll();
        budgetAll.forEach(b2 -> {
        	//budgetActuals�̍쐬
        	BudgetsActuals addBudgetsActuals = new BudgetsActuals();
        	
    		//Actual�̎擾
    		ArrayList<Actual> actualTemp = actualService.findByBudgetId(b2.getId());

    		addBudgetsActuals.setId(b2.getId());
    		addBudgetsActuals.setName(b2.getName());
    		addBudgetsActuals.setActuals(actualTemp);
    		
            //budgetCategories�̕ۑ�
    		budgetsActuals.add(addBudgetsActuals);
        });
        
        //account�̑S���擾
         accounts = accountService.findByIdIsNotNullOrderBySort();
//        accounts = accountService.findAll();
    
        //���X�|���X�ɃZ�b�g
        BudgetActualGetRes budgetActualGetResponse = BudgetActualGetRes.builder()
                .budgetCategoriesBudgets(budgetCategoriesBudgets)
                .budgetsActuals(budgetsActuals)
                .accounts(accounts)
                .build();        
        
        return new ResponseEntity<>(budgetActualGetResponse, HttpStatus.OK);
    }
    
}
