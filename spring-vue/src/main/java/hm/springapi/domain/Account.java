package hm.springapi.domain;

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
    /** �����̔�ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** �������ID */
    private Long accountCategoryId;
    
    /** ������ */
    private String name;
    
    /** �쐬���� */
    @Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	/** �X�V����. */
    @Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	/** �폜����. */
    @Temporal(TemporalType.TIMESTAMP)
	private Date deletedAt;
    
    /****/
//    @ManyToOne
//    @JsonBackReference("Account")
//    @JoinColumn(name="account_category_id",referencedColumnName="id",nullable=false,unique=true,insertable = false, updatable = false)
//    private AccountCategory accountType;
    
    
}
