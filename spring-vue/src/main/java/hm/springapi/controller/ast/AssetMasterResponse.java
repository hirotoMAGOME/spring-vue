package hm.springapi.controller.ast;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class AssetMasterResponse {

    private List<AssetMasterList> assetMasterList = new ArrayList<AssetMasterList>() ;
//    assetMasterList[0].name="�\�Z�J�e�S��";
//    assetMasterList[0].apiCode="AST_01";
//    assetMasterList[1].id=2;
//    assetMasterList[1].name="�\�Z�J�e�S��2";
//    assetMasterList[1].apiCode="AST_02";
    
//    assetMasterList.add(1);
//    	{new AssetMasterList(1,"�\�Z�J�e�S��","AST_01"),new AssetMasterList(1,"�\�Z�J�e�S��","AST_01")} ;

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