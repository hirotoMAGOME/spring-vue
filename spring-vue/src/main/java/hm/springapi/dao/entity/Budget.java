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
    /** 自動採番ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** ユーザーID */
//    @Column
//    private Long user_id;
    
    /** 計上年月 */
    @Column
    @Temporal(TemporalType.DATE)
    private Date appropriateMonth;
    
    /** 予算カテゴリID */
    @Column
    private Long budgetCategoryId;
    
    /** 予算額 */
    @Column
    private Integer amount;
    
    /** 予算名 */
    @Column
    private String name;
    
    /** 作成日時 */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    /** 作成者 */
    @Column
    private Long createdUserId;
    
    /** 更新日時 */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    
    /** 更新者 */
    @Column
    private Long updatedUserId;
    
    /** 削除日時 */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;
    
    /** 削除者 */
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
