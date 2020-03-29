package hm.springapi.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name="m_account")
@Setter
@Getter
public class Account {
    /** 自動採番ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 口座種類ID */
    @Column
    private Long account_type_id;
    
    /** 口座名 */
    @Column
    private String name;
    
    /** 作成日時 */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;
    
    /** 更新日時 */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;
    
    /** 削除日時 */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date deleted_at;
    
    /****/
    @ManyToOne
    @JsonBackReference("Account")
    @JoinColumn(name="account_type_id",referencedColumnName="id",nullable=false,unique=true,insertable = false, updatable = false)
    private AccountType accountType;
    
    
}
