package hm.springapi.controller.view.ast.costperformance;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

import hm.springapi.dao.entity.AccountBalance;

@Getter
@Builder
public class AccountBalanceResponse {

    private List<AccountBalance> accountBalances;
}