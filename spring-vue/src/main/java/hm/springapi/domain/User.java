package hm.springapi.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class User {
    /** �����̔�ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** ���[�U�[�� */
    private String name;

    /** PW */
    private String password;

    /** �Ǘ��ҋ敪 */
    private String admin_kbn;
    
	/** �쐬����. */
	private Date createdAt;

	/** �X�V����. */
	private Date updatedAt;

	/** �폜����. */
	private Date deletedAt;
}
