package hm.springapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import hm.springapi.domain.Budget;
import hm.springapi.domain.BudgetRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CashService {

    private final BudgetRepository budgetRepository;

    public List<Budget> findAll() {
        return budgetRepository.findAll();
    }
}