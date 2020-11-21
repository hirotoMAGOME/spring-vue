package hm.springapi.dao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
    private Date appropriateMonth;
    
    /** —\ZƒJƒeƒSƒŠID */
    @Column
    private Long budgetCategoryId;
    
    /** —\ZŠz */
    @Column
    private Integer amount;
    
    /** —\Z–¼ */
    @Column
    private String name;
    
    /** ì¬“ú */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    /** ì¬Ò */
    @Column
    private Long createdUserId;
    
    /** XV“ú */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    
    /** XVÒ */
    @Column
    private Long updatedUserId;
    
    /** íœ“ú */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;
    
    /** íœÒ */
    @Column
    private Long deletedUserId;
    
//    @Setter(AccessLevel.NONE) 
//  @OneToMany
//  @JoinColumn(name="budgetId")
//  private List<Actual> actual = new ArrayList<>();
    
    
    /****/
//    @ManyToOne
//    @JsonBackReference("Account")
//    @JoinColumn(name="account_type_id",referencedColumnName="id",nullable=false,unique=true,insertable = false, updatable = false)
//    private BudgetCategory budgetCategory;
    
    
}
