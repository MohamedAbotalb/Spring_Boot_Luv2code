package com.mabotalb.aop_demo.dao;

import com.mabotalb.aop_demo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": Doing my DB Work: Adding an Account");
    }

    @Override
    public boolean doWork() {

        System.out.println(getClass() + ": doWork()");

        return true;
    }
}
