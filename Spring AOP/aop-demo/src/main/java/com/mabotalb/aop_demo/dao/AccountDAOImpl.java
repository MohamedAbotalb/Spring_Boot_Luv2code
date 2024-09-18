package com.mabotalb.aop_demo.dao;

import org.springframework.stereotype.Repository;

import com.mabotalb.aop_demo.Account;
@Repository
public class AccountDAOImpl implements AccountDAO{
    @Override
    public void addAccount() {
        System.out.println(getClass() + ": Doing my DB Work: Adding an Account");
    }
}
