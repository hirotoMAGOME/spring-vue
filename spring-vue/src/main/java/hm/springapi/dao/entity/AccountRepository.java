package hm.springapi.dao.entity;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	ArrayList<Account> findAll();
//	ArrayList<Account> findAllOrderBySort();
}