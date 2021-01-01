package hm.springapi.controller.view.ast.costperformance.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ActualRegistPostReq {
	private Date settledAt;
	private Long budgetId;
	private Long accountId;
	private Integer price;
	private String name;
}
