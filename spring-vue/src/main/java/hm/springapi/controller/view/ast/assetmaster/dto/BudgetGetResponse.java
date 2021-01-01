package hm.springapi.controller.view.ast.assetmaster.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.List;

import hm.springapi.dao.entity.Budget;

@Getter
@Builder
public class BudgetGetResponse {

    private List<Budget> budgets;
    private Date latestAppropriateMonth;
}