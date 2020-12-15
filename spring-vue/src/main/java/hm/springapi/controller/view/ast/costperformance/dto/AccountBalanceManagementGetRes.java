package hm.springapi.controller.view.ast.costperformance.dto;

import java.util.List;

import hm.springapi.dao.entity.Account;
import hm.springapi.dao.entity.AccountBalance;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class AccountBalanceManagementGetRes {
	private List<AccountBalance> latestAccountBalance;
	private List<AccountBalanceHistory> accountBalanceHistory;
	private List<Account> accounts;
}