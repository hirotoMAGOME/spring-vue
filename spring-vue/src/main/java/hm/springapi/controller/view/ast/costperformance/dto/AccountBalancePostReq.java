package hm.springapi.controller.view.ast.costperformance.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountBalancePostReq {
	private Long id;
	private Long accountId;
	private Date recordedAt;
	private Long balance;
	private Long currencyId;
}
