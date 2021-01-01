package hm.springapi.controller.view.ast.assetmaster.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BudgetFixPostReq {
	private Long userId;
	private Date appropriateMonth;
}
