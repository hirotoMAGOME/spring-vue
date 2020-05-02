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
    /** 自動採番ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** 計上年月 */
    @Column(name="appropriate_month")
    @Temporal(TemporalType.DATE)
    private Date appropriateMonth;
    
    /** 決算日 */
//    @Column(name="settled_at")
//    @Temporal(TemporalType.TIMESTAMP)
//    @NonNull
//    private Date settledAt;
    
    /** 予算ID */
    @Column(name="budget_id")
    private Integer budgetId;
    
    /** 口座ID */
    @Column(name="account_id")
    private Integer accountId;
    
    /** 金額 */
    @Column(name="price")
    private Integer price = 0;
    
    /** 実績名 */
    @Column(name="name")
    @NonNull
    private String name;
    
    /** 作成日時 */
//    @Column(name="created_at")
//    @Temporal(TemporalType.TIMESTAMP)
//    @NonNull
//    private Date createdAt;
    
    /** 作成者 */
//    @Column(name="created_user_id")
//    private Integer createdUserId;
    
    /** 更新日時 */
//    @Column(name="updated_at")
//    @Temporal(TemporalType.TIMESTAMP)
//    @NonNull
//    private Date updatedAt;
    
    /** 更新者 */
//    @Column(name="updated_user_id")
//    private Integer updatedUserId;
    
    /** 削除日時 */
//    @Column(name="deleted_at")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date deletedAt;
    
    /** 削除者 */
//    @Column(name="deleted_user_id")
//    private Integer deletedUserId;
    
}
