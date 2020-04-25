package hm.springapi.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.OneToMany;

import java.util.List;

@Entity(name="m_account_type")
@Setter
@Getter
public class AccountType {
    /** �����̔�ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /** ������ޖ� */
    @Column
    private String name;
    
    /** �쐬���� */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;
    
    /** �X�V���� */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;
    
    /** �폜���� */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date deleted_at;
    
    /** �O���L�[ **/
    @OneToMany(mappedBy="accountType")
    @JsonManagedReference("AccountType")
    private List<Account> accounts;
     
}
