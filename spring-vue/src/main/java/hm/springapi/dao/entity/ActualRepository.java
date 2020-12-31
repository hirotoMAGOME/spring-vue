package hm.springapi.dao.entity;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActualRepository extends JpaRepository<Actual, Long> {
	ArrayList<Actual> findByBudgetId(Long budgetId);
}