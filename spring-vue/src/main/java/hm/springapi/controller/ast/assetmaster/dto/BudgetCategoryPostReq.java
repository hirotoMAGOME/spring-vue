package hm.springapi.controller.ast.assetmaster.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BudgetCategoryPostReq {
	private Long id;
	private String name;
	private String budgetCategoryType;
}
