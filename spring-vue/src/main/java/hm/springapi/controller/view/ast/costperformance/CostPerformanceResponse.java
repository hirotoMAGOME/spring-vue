package hm.springapi.controller.view.ast.costperformance;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

import hm.springapi.dao.entity.Actual;

@Getter
@Builder
public class CostPerformanceResponse {

    private List<Actual> actuals;
}