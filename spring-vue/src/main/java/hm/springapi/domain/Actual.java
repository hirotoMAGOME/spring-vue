package hm.springapi.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.NonNull;

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

@Entity(name="a_actual")
@Setter
@Getter
public class Actual {
    /** ©“®Ì”ÔID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** Œvã”NŒ */
    @Column(name="appropriate_month")
    @Temporal(TemporalType.DATE)
    private Date appropriateMonth;
    
    /** ŒˆZ“ú */
//    @Column(name="settled_at")
//    @Temporal(TemporalType.TIMESTAMP)
//    @NonNull
//    private Date settledAt;
    
    /** —\ZID */
    @Column(name="budget_id")
    private Integer budgetId;
    
    /** ŒûÀID */
    @Column(name="account_id")
    private Integer accountId;
    
    /** ‹àŠz */
    @Column(name="price")
    private Integer price = 0;
    
    /** ÀÑ–¼ */
    @Column(name="name")
    @NonNull
    private String name;
    
    /** ì¬“ú */
//    @Column(name="created_at")
//    @Temporal(TemporalType.TIMESTAMP)
//    @NonNull
//    private Date createdAt;
    
    /** ì¬Ò */
//    @Column(name="created_user_id")
//    private Integer createdUserId;
    
    /** XV“ú */
//    @Column(name="updated_at")
//    @Temporal(TemporalType.TIMESTAMP)
//    @NonNull
//    private Date updatedAt;
    
    /** XVÒ */
//    @Column(name="updated_user_id")
//    private Integer updatedUserId;
    
    /** íœ“ú */
//    @Column(name="deleted_at")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date deletedAt;
    
    /** íœÒ */
//    @Column(name="deleted_user_id")
//    private Integer deletedUserId;
    
}
