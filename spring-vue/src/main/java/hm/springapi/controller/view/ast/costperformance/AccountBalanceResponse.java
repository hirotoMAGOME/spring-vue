package hm.springapi.controller.view.ast.costperformance;

import lombok.Builder;
import lombok.Getter;
import hm.springapi.domain.AccountBalance;

import java.util.List;

@Getter
@Builder
public class AccountBalanceResponse {

    private List<AccountBalance> accountBalances;
}