package hm.springapi.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="cd_account_kbn")
@Setter
@Getter
public class Account {
    /** ©“®Ì”ÔID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** ‰¼‘z’Ê‰İ–¼ */
    private String code;

    /** ƒVƒ“ƒ{ƒ‹ */
    private String name;

}
