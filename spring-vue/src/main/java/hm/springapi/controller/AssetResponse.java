package hm.springapi.controller;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

import hm.springapi.dao.entity.Account;

@Getter
@Builder
public class AssetResponse {

    private List<Account> accounts;
}