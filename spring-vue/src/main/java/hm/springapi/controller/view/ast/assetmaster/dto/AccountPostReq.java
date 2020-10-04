package hm.springapi.controller.view.ast.assetmaster.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountPostReq {
	private Long id;
	private Long accountCategoryId;
	private String name;
}
