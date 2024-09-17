package com.mabotalb.aop_demo.dao;

import com.mabotalb.aop_demo.Account;

public interface AccountDAO {

    void addAccount(Account account, boolean vipFlag);

    boolean doWork();
}
