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
    @Column
    private Long account_type_id;
    
    /** ŒûÀ–¼ */
    @Column
    private String name;
    
    /** ì¬“ú */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;
    
    /** XV“ú */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;
    
    /** íœ“ú */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date deleted_at;
    
    /****/
//    @ManyToOne
//    @JsonBackReference("Account")
//    @JoinColumn(name="account_category_id",referencedColumnName="id",nullable=false,unique=true,insertable = false, updatable = false)
//    private AccountCategory accountType;
    
    
}
