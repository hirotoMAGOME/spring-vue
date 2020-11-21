//–¢Žg—p
package hm.springapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import hm.springapi.dao.entity.Currency;
import hm.springapi.dao.entity.CurrencyRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    public List<Currency> findAll() {
        return currencyRepository.findAll();
    }
}