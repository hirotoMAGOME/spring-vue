package hm.springapi.dao.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hm.springapi.dao.entity.AccountBalance;

@Repository
public interface AccountBalanceRepository extends JpaRepository<AccountBalance, Long> {

	List<AccountBalance> findByAccountId(Long accountId);
	
	List<AccountBalance> findByAccountIdOrderByRecordedAtDesc(Long accountId);
	
	ArrayList<AccountBalance> findByAccountIdAndCurrencyId(Long accountId,Long currencyId);
}