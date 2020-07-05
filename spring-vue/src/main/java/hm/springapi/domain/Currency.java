package hm.springapi.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class Currency {
    /** ©“®Ì”ÔID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** ‰¼‘z’Ê‰İ–¼ */
    private String name;

    /** ƒVƒ“ƒ{ƒ‹ */
    private String symbol;

    /** ”—Ê */
    private java.math.BigDecimal amount;
}
