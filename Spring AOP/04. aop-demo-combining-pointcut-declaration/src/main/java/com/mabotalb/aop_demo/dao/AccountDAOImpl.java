package com.mabotalb.aop_demo.dao;

import org.springframework.stereotype.Repository;

import com.mabotalb.aop_demo.Account;

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

}
