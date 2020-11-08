package hm.springapi.controller.view.ast.costperformance.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class BudgetActualGetRes {
	//TODO budgetCategories‚ğbudgetCategoriesBudgets‚É–¼Ì•ÏX‚µ‚½‚¢
    private List<BudgetCategoriesBudgets> budgetCategories;
    private List<BudgetsActuals> budgetsActuals;
}