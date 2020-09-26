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
import javax.persistence.ManyToOne;
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
    private Long id;

    /** Œvã”NŒ */
    @Column
    @Temporal(TemporalType.DATE)
    private Date appropriateMonth;
    
    /** ŒˆZ“ú */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date settledAt;
    
    /** —\ZID */
    @Column
    private Integer budgetId;
    
    /** ŒûÀID */
    @Column
    private Integer accountId;
    
    /** ‹àŠz */
    @Column
    private Integer price = 0;
    
    /** ÀÑ–¼ */
    @Column
    @NonNull
    private String name;
    
    /** ì¬“ú */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @NonNull
    private Date createdAt;
    
    /** ì¬Ò */
    @Column
    private Integer createdUserId;
    
    /** XV“ú */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @NonNull
    private Date updatedAt;
    
    /** XVÒ */
    @Column
    private Integer updatedUserId;
    
    /** íœ“ú */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;
    
    /** íœÒ */
    @Column
    private Integer deletedUserId;
    
}
