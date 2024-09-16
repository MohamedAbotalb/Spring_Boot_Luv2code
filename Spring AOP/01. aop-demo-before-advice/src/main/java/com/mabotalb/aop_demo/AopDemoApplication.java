package com.mabotalb.aop_demo;

import com.mabotalb.aop_demo.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO) {

		return runner -> {

			demoTheBeforeAdvice(accountDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO) {

		accountDAO.addAccount();

		// do it again
		System.out.println("\n let's do it again!\n");

		// Call the business method again
		accountDAO.addAccount();
	}

}
