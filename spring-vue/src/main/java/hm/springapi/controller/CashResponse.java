package hm.springapi.controller;

import lombok.Builder;
import lombok.Getter;

import java.util.*;

import hm.springapi.dao.entity.Budget;

@Getter
@Builder
public class CashResponse {

    private List<Budget> budgets;
    private List<String> list2 = Arrays.asList("Drian", "Elderberry");
    
    List<String> data = new ArrayList<>();
    //data.addAll(budget);
    
    
}