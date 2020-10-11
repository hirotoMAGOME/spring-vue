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

@Entity(name="a_account_balance")
@Setter
@Getter
public class AccountBalance {
    /** �����̔�ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** ����ID */
    private Long accountId;
    
    /** �L������ */
    @Temporal(TemporalType.TIMESTAMP)
	private Date recordedAt;
    
    /** �c�� */
    @Column
    private Long balance;
    
    /** �ʉ�ID */
    private Long currencyId;
    
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
