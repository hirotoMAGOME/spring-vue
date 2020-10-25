
package hm.springapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import hm.springapi.dao.entity.AccountBalance;
import hm.springapi.dao.entity.AccountBalanceRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountBalanceService {

    private final AccountBalanceRepository accountBalanceRepository;

    public List<AccountBalance> findAll() {
        return accountBalanceRepository.findAll();
    }
    
    public List<AccountBalance> findByAccountId(Long accountId) {
        return accountBalanceRepository.findByAccountId(accountId);
    }
    
    public Optional<AccountBalance> findById(Long id){
    	return accountBalanceRepository.findById(id);
    }
    
    public String createAccountBalance(AccountBalance accountBalance) {

    	accountBalance.setId(null);
    	Date date = new Date();
    	accountBalance.setCreatedAt(date);
    	accountBalance.setUpdatedAt(date);
    	
    	accountBalanceRepository.save(accountBalance);
    	
    	return "success!!";
    }
//    
//    public String deleteAccount(Long id) {
//    	
//    	accountRepository.deleteById(id);
//    	
//    	return "success!!";
//    }
}