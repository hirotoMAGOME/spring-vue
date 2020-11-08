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
        //���X�|���X�̑�1�K�w�Z�b�g�p�C���X�^���X
        ArrayList <BudgetCategoriesBudgets> budgetCategories = new ArrayList<>();
    	
        //budgetCategory�̑S���擾
        List<BudgetCategory> budgetCategoryAll = budgetCategoryService.findAll();
        
        //�S�����[�v(bc=budget_category)
        budgetCategoryAll.forEach(bc -> {
        	//budgetCategoryId���w�肵��Budget���擾
        	ArrayList<Budget> budgetTemp = budgetService.findByBudgetCategoryId(bc.getId());
        	//budgetCategories�̍쐬
        	BudgetCategoriesBudgets addBudgetCategory = new BudgetCategoriesBudgets();

        	//�S�����[�v(b=budget)
        	budgetTemp.forEach(b -> {
            	//actual�̍��v���z�p�̕ϐ�
        		ArrayList<Integer> sumPrice = new ArrayList<Integer>();

        		//Actual�̎擾
        		ArrayList<Actual> actualTemp = actualService.findByBudgetId(b.getId());
                
        		//TODO ���Ȃ薳�ʂȃ��[�v�AGROUP BY�ŉ�������
        		//�S�����[�v(a=actual)
        		actualTemp.forEach(a -> {
            		sumPrice.add(a.getPrice());
            		System.out.println(a.getPrice());
            	});
        		
            	addBudgetCategory.setBudgetCategoryId(bc.getId());
                addBudgetCategory.setBudgetCategoryType(bc
                		.getBudgetCategoryType());
                //budgetId�ɓ����l���d������ăZ�b�g����Ă��܂��B�������ł��Ă��Ȃ����A�ŏI���[�v�ōX�V����Ă���B
                addBudgetCategory.setBudgetId(b.getId());
                addBudgetCategory.setBudgetName(b.getName());
                addBudgetCategory.setAmount(b.getAmount());
                //TODO �l��0�̂܂�
                addBudgetCategory.setPrice(sumPrice.stream().mapToInt(i -> i).sum());
//
//                double test = sumPrice.stream().mapToDouble(i -> i).sum();
//                System.out.println("test");
//                System.out.println(b.getId());


                //budgetCategories�̕ۑ�
                budgetCategories.add(addBudgetCategory);
        	});
        	
        });
        BudgetActualGetRes budgetActualGetResponse = BudgetActualGetRes.builder()
                .budgetCategories(budgetCategories)
                .build();        
        
        
        return new ResponseEntity<>(budgetActualGetResponse, HttpStatus.OK);
    }
    
}
