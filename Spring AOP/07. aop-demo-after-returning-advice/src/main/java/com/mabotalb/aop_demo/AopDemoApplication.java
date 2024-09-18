package com.mabotalb.aop_demo;

import java.util.List;

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

			// demoTheBeforeAdvice(accountDAO, membershipDAO)

			demoForAfterReturningAdvice(accountDAO);
		};
	}

	private void demoForAfterReturningAdvice(AccountDAO accountDAO) {

		// Call a method to find all accounts
		List<Account> accounts = accountDAO.findAccounts();

		// Display the accounts
		System.out.println("\n\nMain Program: demoForAfterReturningAdvice");
		System.out.println("-----");

		System.out.println("Accounts: " + accounts);

		System.out.println("\n");
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
