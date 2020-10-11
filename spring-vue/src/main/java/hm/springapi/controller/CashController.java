package hm.springapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import hm.springapi.dao.entity.Budget;
import hm.springapi.service.CashService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CashController {

    private final CashService cashService;

    @GetMapping("/cash")
    @CrossOrigin
    public ResponseEntity<CashResponse> findAll() {
    	//多分データをとってきてる
    	List<Budget> budgets = cashService.findAll();

    	//jsonで返せるように、データをStringにしている
        CashResponse cashResponse = CashResponse.builder()
                .budgets(budgets)
                .build();
        return new ResponseEntity<>(cashResponse, HttpStatus.OK);
    }
    
    @PostMapping("/cash")
    @CrossOrigin
    public String messagePost() {
    	return cashService.createActual();
    }
}