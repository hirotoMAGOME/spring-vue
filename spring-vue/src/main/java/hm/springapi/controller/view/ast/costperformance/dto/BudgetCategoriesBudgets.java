package hm.springapi.controller.view.ast.costperformance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BudgetCategoriesBudgets {
    private Long budgetCategoryId;
    private String budgetCategoryType;
    private Long budgetId;
    private String budgetName;
    private Integer amount;
    private Integer price;
}