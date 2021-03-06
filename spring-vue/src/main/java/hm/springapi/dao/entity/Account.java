package hm.springapi.dao.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name="m_account")
@Setter
@Getter
public class Account {
    /** 自動採番ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 口座種類ID */
    private Long accountCategoryId;
    
    /** 口座名 */
    private String name;
    
    /** 表示順 */
    private Integer sort;
    
    /** 作成日時 */
    @Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	/** 更新日時. */
    @Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	/** 削除日時. */
    @Temporal(TemporalType.TIMESTAMP)
	private Date deletedAt;
    
    /****/
//    @ManyToOne
//    @JsonBackReference("Account")
//    @JoinColumn(name="account_category_id",referencedColumnName="id",nullable=false,unique=true,insertable = false, updatable = false)
//    private AccountCategory accountType;
    
    
}
