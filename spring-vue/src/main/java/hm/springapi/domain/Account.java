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
    /** ©“®Ì”ÔID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** ŒûÀí—ŞID */
    private Long accountCategoryId;
    
    /** ŒûÀ–¼ */
    private String name;
    
    /** ì¬“ú */
    @Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	/** XV“ú. */
    @Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	/** íœ“ú. */
    @Temporal(TemporalType.TIMESTAMP)
	private Date deletedAt;
    
    /****/
//    @ManyToOne
//    @JsonBackReference("Account")
//    @JoinColumn(name="account_category_id",referencedColumnName="id",nullable=false,unique=true,insertable = false, updatable = false)
//    private AccountCategory accountType;
    
    
}
