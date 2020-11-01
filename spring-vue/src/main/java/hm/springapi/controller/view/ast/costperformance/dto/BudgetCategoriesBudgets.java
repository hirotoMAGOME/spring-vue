package hm.springapi.controller.view.ast.costperformance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import hm.springapi.dao.entity.AccountBalance;
import hm.springapi.dao.entity.Actual;
import hm.springapi.dao.entity.Budget;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BudgetCategoriesBudgets {
    private Long budgetCategoryId;
    private String name;
    private String budgetCategoryType;
    private List<Budget> budgets;
}