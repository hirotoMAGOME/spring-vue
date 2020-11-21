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

@Entity
@Setter
@Getter
public class Currency {
    /** 自動採番ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	/** ユーザー. */
	private Long userId;
	
    /** 通貨名 */
    private String name;

    /** マーク */
    private String mark;

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
