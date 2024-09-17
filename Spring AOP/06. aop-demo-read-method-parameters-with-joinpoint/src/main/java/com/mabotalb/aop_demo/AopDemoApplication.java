package com.mabotalb.aop_demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mabotalb.aop_demo.dao.AccountDAO;
import com.mabotalb.aop_demo.dao.MembershipDAO;

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
		account.setName("Ali");
		account.setLevel("Platinum");
		accountDAO.addAccount(account, true);
		accountDAO.doWork();

		// Call the accountDAO setter/getter methods
		accountDAO.setName("Mohamed");
		accountDAO.setServiceCode("322");

		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();

		// Call the membership business method
		membershipDAO.addSillyMember();
		membershipDAO.gotToSleep();
	}

}
