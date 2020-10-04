
package hm.springapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import hm.springapi.domain.AccountBalance;
import hm.springapi.domain.AccountBalanceRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountBalanceService {

    private final AccountBalanceRepository accountBalanceRepository;

    public List<AccountBalance> findAll() {
        return accountBalanceRepository.findAll();
    }
    
//    public String createAccount(Account account) {
//
//    	Date date = new Date();
//    	account.setCreatedAt(date);
//    	account.setUpdatedAt(date);
//    	
//    	accountRepository.save(account);
//    	
//    	return "success!!";
//    }
//    
//    public String deleteAccount(Long id) {
//    	
//    	accountRepository.deleteById(id);
//    	
//    	return "success!!";
//    }
}