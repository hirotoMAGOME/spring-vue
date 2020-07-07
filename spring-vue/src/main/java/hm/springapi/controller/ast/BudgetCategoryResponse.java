package hm.springapi.controller.ast;

import lombok.Builder;
import lombok.Getter;
import hm.springapi.domain.BudgetCategory;

import java.util.List;

@Getter
@Builder
public class BudgetCategoryResponse {

    private List<BudgetCategory> budgetCategories;
}