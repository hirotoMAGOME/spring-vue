package hm.springapi.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="a_budget")
@Setter
@Getter
public class Budget {
    /** ©“®Ì”ÔID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** ƒ†[ƒU[ID */
//    @Column
//    private Long user_id;
    
    /** Œvã”NŒ */
    @Column
    @Temporal(TemporalType.DATE)
    private Date appropriate_month;
    
    /** —\ZƒJƒeƒSƒŠID */
    @Column
    private Long budget_category_id;
    
    /** —\ZŠz */
    @Column
    private Long amount;
    
    /** —\Z–¼ */
    @Column
    private String name;
    
    /** ì¬“ú */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;
    
    /** ì¬Ò */
    @Column
    private Long created_user_id;
    
    /** XV“ú */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;
    
    /** XVÒ */
    @Column
    private Long updated_user_id;
    
    /** íœ“ú */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date deleted_at;
    
    /** íœÒ */
    @Column
    private Long deleted_user_id;
    
    /****/
//    @ManyToOne
//    @JsonBackReference("Account")
//    @JoinColumn(name="account_type_id",referencedColumnName="id",nullable=false,unique=true,insertable = false, updatable = false)
//    private AccountType accountType;
    
    
}
