package hm.springapi.controller.ast;

import lombok.Builder;
import lombok.Getter;
import hm.springapi.domain.AssetApiList;

import java.util.List;

@Getter
@Builder
public class AssetApiListResponse {

    private List<AssetApiList> assetApiLists;
}