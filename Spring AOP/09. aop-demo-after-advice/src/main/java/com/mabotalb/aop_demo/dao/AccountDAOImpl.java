package com.mabotalb.aop_demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mabotalb.aop_demo.Account;
import com.mabotalb.aop_demo.dao.AccountDAO;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;

    private String serviceCode;

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": Doing my DB Work: Adding an Account");
    }

    @Override
    public boolean doWork() {

        System.out.println(getClass() + ": doWork()");

        return true;
    }

    public String getName() {
        System.out.println(getClass() + ": in getName()");

        return this.name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");

        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");

        return this.serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");

        this.serviceCode = serviceCode;
    }

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        // Simulate an exception
        if (tripWire) {
            throw new RuntimeException("No soup for you!");
        }
        
        List<Account> accounts = new ArrayList<>();

        // Create sample accounts data
        Account account1 = new Account("Ahmed", "Silver");
        Account account2 = new Account("Mahmoud", "Gold");
        Account account3 = new Account("Mohamd", "Platinum");

        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);

        return accounts;
    }

}
