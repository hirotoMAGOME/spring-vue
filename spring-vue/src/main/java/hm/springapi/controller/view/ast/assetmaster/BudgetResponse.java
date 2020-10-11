package hm.springapi.controller.view.ast.assetmaster;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

import hm.springapi.dao.entity.Budget;

@Getter
@Builder
public class BudgetResponse {

    private List<Budget> budgets;
}