package hm.springapi.dao.entity;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {
	ArrayList<Budget> findByBudgetCategoryId(Long budgetCategoryId);
	ArrayList<Budget> findByCreatedUserId(Long createdUserId);
	ArrayList<Budget> findByCreatedUserIdAndAppropriateMonth(Long createdUserId,Date appropriateMonth);
}