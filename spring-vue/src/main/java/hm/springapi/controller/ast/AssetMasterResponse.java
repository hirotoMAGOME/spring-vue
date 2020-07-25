package hm.springapi.controller.ast;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class AssetMasterResponse {

    private List<AssetMasterList> assetMasterList = new ArrayList<AssetMasterList>() ;
//    assetMasterList[0].name="—\ZƒJƒeƒSƒŠ";
//    assetMasterList[0].apiCode="AST_01";
//    assetMasterList[1].id=2;
//    assetMasterList[1].name="—\ZƒJƒeƒSƒŠ2";
//    assetMasterList[1].apiCode="AST_02";
    
//    assetMasterList.add(1);
//    	{new AssetMasterList(1,"—\ZƒJƒeƒSƒŠ","AST_01"),new AssetMasterList(1,"—\ZƒJƒeƒSƒŠ","AST_01")} ;

}

@Getter
@Builder
class AssetMasterList{
	int id;
	String name;
	String apiCode;
	
	AssetMasterList(int id,String name,String apiCode){
		this.id=id;
		this.name=name;
		this.apiCode=apiCode;
	}
}