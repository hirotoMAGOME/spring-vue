package hm.springapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hm.springapi.dao.entity.AccountBalanceRepository;

@SpringBootApplication
public class SpringVueApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringVueApplication.class, args);
	}

}
