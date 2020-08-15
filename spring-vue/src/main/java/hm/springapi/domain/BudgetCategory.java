package hm.springapi.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="m_budget_category")
@Setter
@Getter
/**
 * �\�Z�J�e�S�� ���f���N���X.
 * 
 */
public class BudgetCategory {

	/** ID. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** ���[�U�[. */
	private Long userId;

	/** �\�Z�J�e�S����. */
	private String name;

	/** . */
	private String budgetCategoryType;

	/** �쐬����. */
    @Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	/** �X�V����. */
    @Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	/** �폜����. */
    @Temporal(TemporalType.TIMESTAMP)
	private Date deletedAt;
	
}
