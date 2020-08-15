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
    /** 自動採番ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** ユーザー名 */
    private String name;

    /** PW */
    private String password;

    /** 管理者区分 */
    private String admin_kbn;
    
	/** 作成日時. */
	private Date createdAt;

	/** 更新日時. */
	private Date updatedAt;

	/** 削除日時. */
	private Date deletedAt;
}
