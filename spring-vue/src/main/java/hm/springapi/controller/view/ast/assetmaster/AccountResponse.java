package hm.springapi.controller.view.ast.assetmaster;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

import hm.springapi.dao.entity.Account;

@Getter
@Builder
public class AccountResponse {

    private List<Account> accounts;
}