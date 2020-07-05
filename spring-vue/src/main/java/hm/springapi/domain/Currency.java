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
    /** �����̔�ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** ���z�ʉݖ� */
    private String name;

    /** �V���{�� */
    private String symbol;

    /** ���� */
    private java.math.BigDecimal amount;
}
