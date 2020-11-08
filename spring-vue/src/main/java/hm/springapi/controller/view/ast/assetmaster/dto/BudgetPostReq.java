package hm.springapi.controller.view.ast.assetmaster.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Setter
@Getter
public class BudgetPostReq {
	private Long id;
	private Date appropriateMonth;
	private Long budgetCategoryId;
	private Integer amount;
	private String name;
}
