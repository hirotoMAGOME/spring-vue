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
    private Date appropriate_month;
    
    /** �\�Z�J�e�S��ID */
    @Column
    private Long budget_category_id;
    
    /** �\�Z�z */
    @Column
    private Long amount;
    
    /** �\�Z�� */
    @Column
    private String name;
    
    /** �쐬���� */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;
    
    /** �쐬�� */
    @Column
    private Long created_user_id;
    
    /** �X�V���� */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;
    
    /** �X�V�� */
    @Column
    private Long updated_user_id;
    
    /** �폜���� */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date deleted_at;
    
    /** �폜�� */
    @Column
    private Long deleted_user_id;
    
    /****/
//    @ManyToOne
//    @JsonBackReference("Account")
//    @JoinColumn(name="account_type_id",referencedColumnName="id",nullable=false,unique=true,insertable = false, updatable = false)
//    private AccountType accountType;
    
    
}
