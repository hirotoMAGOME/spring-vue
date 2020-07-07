package hm.springapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import hm.springapi.domain.BudgetCategory;
import hm.springapi.domain.BudgetCategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BudgetCategoryService {

    private final BudgetCategoryRepository budgetCategoryRepository;

    public List<BudgetCategory> findAll() {
        return budgetCategoryRepository.findAll();
    }
}