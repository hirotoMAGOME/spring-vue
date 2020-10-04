package hm.springapi.controller.view.ast.assetmaster;

import lombok.Builder;
import lombok.Getter;
import hm.springapi.domain.AccountCategory;

import java.util.List;

@Getter
@Builder
public class AccountCategoryResponse {

    private List<AccountCategory> accountCategories;
}