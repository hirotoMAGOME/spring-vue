package hm.springapi.controller.view.ast.assetmaster;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

import hm.springapi.dao.entity.AssetApiList;

@Getter
@Builder
public class AssetApiListResponse {

    private List<AssetApiList> assetApiLists;
}