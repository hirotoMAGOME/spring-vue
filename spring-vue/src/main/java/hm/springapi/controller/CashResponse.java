package hm.springapi.controller;

import lombok.Builder;
import lombok.Getter;
import hm.springapi.domain.Budget;

import java.util.*;

@Getter
@Builder
public class CashResponse {

    private List<Budget> budgets;
    private List<String> list2 = Arrays.asList("Drian", "Elderberry");
    
    List<String> data = new ArrayList<>();
    //data.addAll(budget);
    
    
}