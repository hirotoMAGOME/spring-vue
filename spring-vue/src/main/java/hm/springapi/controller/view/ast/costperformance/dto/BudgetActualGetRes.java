package hm.springapi.controller.view.ast.costperformance.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class BudgetActualGetRes {
	//TODO budgetCategories��budgetCategoriesBudgets�ɖ��̕ύX������
    private List<BudgetCategoriesBudgets> budgetCategories;
    private List<BudgetsActuals> budgetsActuals;
}