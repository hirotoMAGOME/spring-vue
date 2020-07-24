//–¢Žg—p
package hm.springapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import hm.springapi.domain.Account;
import hm.springapi.domain.AccountRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}