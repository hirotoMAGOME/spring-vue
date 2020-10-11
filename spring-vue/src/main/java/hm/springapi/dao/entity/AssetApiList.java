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
 * ���YAPI���X�g ���f���N���X.
 * 
 */
public class AssetApiList {

	/** ID. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** API�R�[�h. */
	private String api_cd;
	
	/** ���YAPI��. */
	private String name;

	/** PATH. */
	private String path;
	
}
