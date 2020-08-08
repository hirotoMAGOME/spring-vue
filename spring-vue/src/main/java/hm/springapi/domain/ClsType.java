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
    /** �h���C���R�[�h */
    @Column
    private String domainCd;

    /** �L�[ */
    @Column
    private String clsTypeKey;
    
    /** ���� */
    @Column
    private String name;
    
    /** �\���� */
    @Id
    private Long sort;
    
    /** �쐬���� */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    /** �X�V���� */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    
    /** �폜���� */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;
    
}
