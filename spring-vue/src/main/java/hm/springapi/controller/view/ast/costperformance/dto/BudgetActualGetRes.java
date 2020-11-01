package hm.springapi.controller.view.ast.costperformance.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class BudgetActualGetRes {
    private List<BudgetCategoriesBudgets> budgetCategories;
}