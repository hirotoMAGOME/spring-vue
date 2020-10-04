package hm.springapi.controller.view.ast.costperformance;

import lombok.Builder;
import lombok.Getter;
import hm.springapi.domain.Actual;

import java.util.List;

@Getter
@Builder
public class CostPerformanceResponse {

    private List<Actual> actuals;
}