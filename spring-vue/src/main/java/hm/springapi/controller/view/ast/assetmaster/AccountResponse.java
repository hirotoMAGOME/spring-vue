package hm.springapi.controller.view.ast.assetmaster;

import lombok.Builder;
import lombok.Getter;
import hm.springapi.domain.Account;

import java.util.List;

@Getter
@Builder
public class AccountResponse {

    private List<Account> accounts;
}