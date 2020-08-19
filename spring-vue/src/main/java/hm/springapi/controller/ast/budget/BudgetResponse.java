package hm.springapi.controller.ast.budget;

import lombok.Builder;
import lombok.Getter;
import hm.springapi.domain.Budget;

import java.util.List;

@Getter
@Builder
public class BudgetResponse {

    private List<Budget> budgets;
}