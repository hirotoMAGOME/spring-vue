package hm.springapi.controller.ast.actual;

import lombok.Builder;
import lombok.Getter;
import hm.springapi.domain.Actual;

import java.util.List;

@Getter
@Builder
public class ActualResponse {

    private List<Actual> actuals;
}