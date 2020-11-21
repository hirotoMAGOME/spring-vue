package hm.springapi.controller.view.ast.assetmaster;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

import hm.springapi.dao.entity.AccountCategory;

@Getter
@Builder
public class AccountCategoryResponse {

    private List<AccountCategory> accountCategories;
}