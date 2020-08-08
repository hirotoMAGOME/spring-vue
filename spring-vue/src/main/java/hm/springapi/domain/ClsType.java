package hm.springapi.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="m_cls_type")
@Setter
@Getter
public class ClsType {
    /** ドメインコード */
    @Column
    private String domainCd;

    /** キー */
    @Column
    private String clsTypeKey;
    
    /** 名称 */
    @Column
    private String name;
    
    /** 表示順 */
    @Id
    private Long sort;
    
    /** 作成日時 */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    /** 更新日時 */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    
    /** 削除日時 */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;
    
}
