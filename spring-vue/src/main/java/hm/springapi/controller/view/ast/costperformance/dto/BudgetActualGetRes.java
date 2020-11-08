package hm.springapi.controller.view.ast.costperformance.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class BudgetActualGetRes {
	//TODO budgetCategoriesをbudgetCategoriesBudgetsに名称変更したい
    private List<BudgetCategoriesBudgets> budgetCategories;
    private List<BudgetsActuals> budgetsActuals;
}