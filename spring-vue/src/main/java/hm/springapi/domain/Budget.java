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

import com.fasterxml.jackson.annotation.JsonBackReference;

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
    private Date appropriate_month;
    
    /** 予算カテゴリID */
    @Column
    private Long budget_category_id;
    
    /** 予算額 */
    @Column
    private Long amount;
    
    /** 予算名 */
    @Column
    private String name;
    
    /** 作成日時 */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;
    
    /** 作成者 */
    @Column
    private Long created_user_id;
    
    /** 更新日時 */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;
    
    /** 更新者 */
    @Column
    private Long updated_user_id;
    
    /** 削除日時 */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date deleted_at;
    
    /** 削除者 */
    @Column
    private Long deleted_user_id;
    
    /****/
//    @ManyToOne
//    @JsonBackReference("Account")
//    @JoinColumn(name="account_type_id",referencedColumnName="id",nullable=false,unique=true,insertable = false, updatable = false)
//    private AccountType accountType;
    
    
}
