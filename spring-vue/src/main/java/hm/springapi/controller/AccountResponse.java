package hm.springapi.controller;

import lombok.Builder;
import lombok.Getter;
import hm.springapi.domain.Account;

import java.util.List;

@Getter
@Builder
public class AccountResponse {

    private List<Account> accounts;
}