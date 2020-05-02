package hm.springapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import hm.springapi.domain.Budget;
import hm.springapi.service.CashService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CashController {

    private final CashService cashService;

    @GetMapping("/cash")
    public ResponseEntity<CashResponse> findAll() {
    	//多分データをとってきてる
    	List<Budget> budgets = cashService.findAll();

    	//jsonで返せるように、データをStringにしている
        CashResponse cashResponse = CashResponse.builder()
                .budgets(budgets)
                .build();
        return new ResponseEntity<>(cashResponse, HttpStatus.OK);
//    	String json = "{'currencies':[{'id':10001,'name':'Bitcoin','symbol':'BTC','amount':0E-20},{'id':10002,'name':'Ethereum','symbol':'ETH','amount':0E-20}]}";
//    	return new ResponseEntity<>(json, HttpStatus.OK);
    }
    
    @PostMapping("/cash")
    public String messagePost() {
    	return "messages";
    }
}