package hm.springapi.dao.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="m_asset_api_list")
@Setter
@Getter
/**
 * 資産APIリスト モデルクラス.
 * 
 */
public class AssetApiList {

	/** ID. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** APIコード. */
	private String api_cd;
	
	/** 資産API名. */
	private String name;

	/** PATH. */
	private String path;
	
}
