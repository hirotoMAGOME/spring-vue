package hm.springapi.controller.ast.actual;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

import hm.springapi.dao.entity.Actual;

@Getter
@Builder
public class ActualResponse {

    private List<Actual> actuals;
}