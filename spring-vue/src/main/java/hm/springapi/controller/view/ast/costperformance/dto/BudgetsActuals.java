package hm.springapi.controller.view.ast.costperformance.dto;

import java.util.ArrayList;

import hm.springapi.dao.entity.Actual;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BudgetsActuals {
    private Long id;
    private String name;
    private ArrayList<Actual> actuals;
}