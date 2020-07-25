package hm.springapi.controller.ast;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import hm.springapi.domain.AssetApiList;
import hm.springapi.service.AssetApiListService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AssetApiListController {

    private final AssetApiListService assetApiListService;

    @GetMapping("/api/ast/asset-api-list")
    @CrossOrigin
    public ResponseEntity<AssetApiListResponse> findAll() {
        List<AssetApiList> assetApiLists = assetApiListService.findAll();
        AssetApiListResponse assetApiListResponse = AssetApiListResponse.builder()
                .assetApiLists(assetApiLists)
                .build();
        return new ResponseEntity<>(assetApiListResponse, HttpStatus.OK);
    }
}
