package com.mabotalb.aop_demo;

import com.mabotalb.aop_demo.dao.AccountDAO;
import com.mabotalb.aop_demo.dao.MembershipDAO;
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
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {

		return runner -> {

			demoTheBeforeAdvice(accountDAO, membershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {

		// Call the account business method
		Account account = new Account();
		accountDAO.addAccount(account, true);
		accountDAO.doWork();

		// Call the membership business method
		membershipDAO.addSillyMember();
		membershipDAO.gotToSleep();
	}

}
