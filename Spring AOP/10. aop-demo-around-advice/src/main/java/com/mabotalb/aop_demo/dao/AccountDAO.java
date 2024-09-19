package com.mabotalb.aop_demo.dao;

import java.util.List;

import com.mabotalb.aop_demo.Account;

public interface AccountDAO {

    void addAccount(Account account, boolean vipFlag);

    boolean doWork();

    void setName(String name);

    String getName();

    void setServiceCode(String serviceCode);

    String getServiceCode();

    List<Account> findAccounts();

    List<Account> findAccounts(boolean tripWire);
}
