package hm.springapi.controller.ast;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import hm.springapi.domain.BudgetCategory;


import java.util.List;

@RestController
@RequiredArgsConstructor
public class AssetMasterController {

    @GetMapping("/api/ast/asset-master")
    @CrossOrigin
    public ResponseEntity<BudgetCategoryResponse> findAll() {
        List<AssetMasterList> assetMasterList = new AssetMasterList[2];
        assetMasterList[0]=new AssetMasterList(1,"—\ŽZƒJƒeƒSƒŠ","AST_01");
//        BudgetCategoryResponse budgetCategoryResponse = BudgetCategoryResponse.builder()
//                .budgetCategories(budgetCategories)
//                .build();
        return new ResponseEntity<>(assetMasterList, HttpStatus.OK);
    }
    
}
