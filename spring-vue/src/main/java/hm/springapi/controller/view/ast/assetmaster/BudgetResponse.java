package hm.springapi.controller.view.ast.assetmaster;

import lombok.Builder;
import lombok.Getter;
import hm.springapi.domain.Budget;

import java.util.List;

@Getter
@Builder
public class BudgetResponse {

    private List<Budget> budgets;
}