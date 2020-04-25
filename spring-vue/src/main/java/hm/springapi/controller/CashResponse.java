package hm.springapi.controller;

import lombok.Builder;
import lombok.Getter;
import hm.springapi.domain.Budget;

import java.util.List;

@Getter
@Builder
public class CashResponse {

    private List<Budget> budgets;
}