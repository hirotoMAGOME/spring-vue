package hm.springapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import hm.springapi.dao.entity.Actual;
import hm.springapi.dao.entity.ActualRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActualService {

    private final ActualRepository actualRepository;

    public List<Actual> findAll() {
        return actualRepository.findAll();
    }

	public ArrayList<Actual> findByBudgetId(Long budgetId) {
		return actualRepository.findByBudgetId(budgetId);
	}
    
    public String createActual(Actual actual) {

    	actual.setId(null);
    	Date date = new Date();
    	actual.setCreatedAt(date);
    	actual.setUpdatedAt(date);

    	actualRepository.save(actual);
    	
    	return "success!!";
    }
}