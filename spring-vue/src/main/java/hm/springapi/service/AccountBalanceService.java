
package hm.springapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import hm.springapi.dao.entity.AccountBalance;
import hm.springapi.dao.entity.AccountBalanceRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountBalanceService {

    private final AccountBalanceRepository accountBalanceRepository;

    public List<AccountBalance> findAll() {
        return accountBalanceRepository.findAll();
    }
    
    //List‚¶‚á‚È‚¢‚ñ‚¾‚¯‚Ç‚Ë
//    public Optional<AccountBalance> findById(Long id){
//    	return accountBalanceRepository.findById(id);
//    }
    
    
    public Optional<AccountBalance> findById(Long id){
    	return accountBalanceRepository.findById(id);
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