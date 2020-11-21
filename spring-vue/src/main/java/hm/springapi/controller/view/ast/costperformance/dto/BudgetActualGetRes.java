package hm.springapi.controller.view.ast.costperformance.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import hm.springapi.dao.entity.Account;

@Setter
@Getter
@Builder
public class BudgetActualGetRes {
    private List<BudgetCategoriesBudgets> budgetCategoriesBudgets;
    private List<BudgetsActuals> budgetsActuals;
    private ArrayList<Account> accounts;
}