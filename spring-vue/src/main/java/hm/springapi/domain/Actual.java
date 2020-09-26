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
    /** �����̔�ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** �v��N�� */
    @Column
    @Temporal(TemporalType.DATE)
    private Date appropriateMonth;
    
    /** ���Z�� */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date settledAt;
    
    /** �\�ZID */
    @Column
    private Integer budgetId;
    
    /** ����ID */
    @Column
    private Integer accountId;
    
    /** ���z */
    @Column
    private Integer price = 0;
    
    /** ���і� */
    @Column
    @NonNull
    private String name;
    
    /** �쐬���� */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @NonNull
    private Date createdAt;
    
    /** �쐬�� */
    @Column
    private Integer createdUserId;
    
    /** �X�V���� */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @NonNull
    private Date updatedAt;
    
    /** �X�V�� */
    @Column
    private Integer updatedUserId;
    
    /** �폜���� */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;
    
    /** �폜�� */
    @Column
    private Integer deletedUserId;
    
}
