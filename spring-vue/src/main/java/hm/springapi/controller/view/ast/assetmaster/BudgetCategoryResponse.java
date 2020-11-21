package hm.springapi.controller.view.ast.assetmaster;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

import hm.springapi.dao.entity.BudgetCategory;

@Getter
@Builder
public class BudgetCategoryResponse {

    private List<BudgetCategory> budgetCategories;
}