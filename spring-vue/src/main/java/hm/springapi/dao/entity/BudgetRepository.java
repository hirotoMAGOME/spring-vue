package hm.springapi.dao.entity;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {
	ArrayList<Budget> findByBudgetCategoryId(Long budgetCategoryId);
}