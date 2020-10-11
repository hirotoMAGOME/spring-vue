package hm.springapi.dao.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//DAO?
@Repository
public interface BudgetCategoryRepository extends JpaRepository<BudgetCategory, Long> {
}