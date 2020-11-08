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
    /** �����̔�ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** ���[�U�[ID */
//    @Column
//    private Long user_id;
    
    /** �v��N�� */
    @Column
    @Temporal(TemporalType.DATE)
    private Date appropriateMonth;
    
    /** �\�Z�J�e�S��ID */
    @Column
    private Long budgetCategoryId;
    
    /** �\�Z�z */
    @Column
    private Integer amount;
    
    /** �\�Z�� */
    @Column
    private String name;
    
    /** �쐬���� */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    /** �쐬�� */
    @Column
    private Long createdUserId;
    
    /** �X�V���� */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    
    /** �X�V�� */
    @Column
    private Long updatedUserId;
    
    /** �폜���� */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;
    
    /** �폜�� */
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
