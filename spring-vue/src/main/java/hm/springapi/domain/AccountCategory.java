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

@Entity(name="m_account_category")
@Setter
@Getter
public class AccountCategory {
    /** 自動採番ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /** 口座カテゴリ名 */
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
     
}
