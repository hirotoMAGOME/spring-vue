//–¢Žg—p
package hm.springapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import hm.springapi.dao.entity.Account;
import hm.springapi.dao.entity.AccountRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public ArrayList<Account> findAll() {
        return accountRepository.findAll();
    }
    
    public String createAccount(Account account) {

    	Date date = new Date();
    	account.setCreatedAt(date);
    	account.setUpdatedAt(date);
    	
    	accountRepository.save(account);
    	
    	return "success!!";
    }
    
    public String deleteAccount(Long id) {
    	
    	accountRepository.deleteById(id);
    	
    	return "success!!";
    }

	public ArrayList<Account> findByIdIsNotNullOrderBySort() {
		return accountRepository.findByIdIsNotNullOrderBySort();
	}
}