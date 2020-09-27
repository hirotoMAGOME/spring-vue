package hm.springapi.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity(name="m_account_category")
@Setter
@Getter
public class AccountCategory {
    /** 自動採番ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	/** ユーザー. */
	private Long userId;
    
    /** 口座カテゴリ名 */
    private String name;
    
    /** 作成日時 */
    @Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	/** 更新日時. */
    @Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	/** 削除日時. */
    @Temporal(TemporalType.TIMESTAMP)
	private Date deletedAt;
}
