package hm.springapi.controller.view.ast.costperformance.dto;

import java.util.List;

import hm.springapi.dao.entity.AccountBalance;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountBalanceHistory {
	private Long accountId;
	private Long currencyId;
	private List<AccountBalance> accountBalanceHistoryFiltered;
}

