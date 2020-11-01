package hm.springapi.dao.entity;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hm.springapi.dao.entity.AccountBalance;

@Repository
public interface AccountBalanceRepository extends JpaRepository<AccountBalance, Long> {
	
	ArrayList<AccountBalance> findByAccountIdAndCurrencyId(Long accountId,Long currencyId);
}