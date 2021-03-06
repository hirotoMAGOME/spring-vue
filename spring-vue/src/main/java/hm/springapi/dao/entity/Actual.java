package hm.springapi.dao.entity;

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
    /** 自動採番ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 計上年月 */
    @Column
    @Temporal(TemporalType.DATE)
    private Date appropriateMonth;
    
    /** 決算日 */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date settledAt;
    
    /** 予算ID */
    @Column
    private Long budgetId;
    
    /** 口座ID */
    @Column
    private Long accountId;
    
    /** 金額 */
    @Column
    private Integer price = 0;
    
    /** 実績名 */
    @Column
    @NonNull
    private String name;
    
    /** 作成日時 */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @NonNull
    private Date createdAt;
    
    /** 作成者 */
    @Column
    private Integer createdUserId;
    
    /** 更新日時 */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @NonNull
    private Date updatedAt;
    
    /** 更新者 */
    @Column
    private Integer updatedUserId;
    
    /** 削除日時 */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;
    
    /** 削除者 */
    @Column
    private Integer deletedUserId;
    
}
