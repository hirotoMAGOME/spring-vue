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
    /** �����̔�ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** �v��N�� */
    @Column(name="appropriate_month")
    @Temporal(TemporalType.DATE)
    private Date appropriateMonth;
    
    /** ���Z�� */
//    @Column(name="settled_at")
//    @Temporal(TemporalType.TIMESTAMP)
//    @NonNull
//    private Date settledAt;
    
    /** �\�ZID */
    @Column(name="budget_id")
    private Integer budgetId;
    
    /** ����ID */
    @Column(name="account_id")
    private Integer accountId;
    
    /** ���z */
    @Column(name="price")
    private Integer price = 0;
    
    /** ���і� */
    @Column(name="name")
    @NonNull
    private String name;
    
    /** �쐬���� */
//    @Column(name="created_at")
//    @Temporal(TemporalType.TIMESTAMP)
//    @NonNull
//    private Date createdAt;
    
    /** �쐬�� */
//    @Column(name="created_user_id")
//    private Integer createdUserId;
    
    /** �X�V���� */
//    @Column(name="updated_at")
//    @Temporal(TemporalType.TIMESTAMP)
//    @NonNull
//    private Date updatedAt;
    
    /** �X�V�� */
//    @Column(name="updated_user_id")
//    private Integer updatedUserId;
    
    /** �폜���� */
//    @Column(name="deleted_at")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date deletedAt;
    
    /** �폜�� */
//    @Column(name="deleted_user_id")
//    private Integer deletedUserId;
    
}
