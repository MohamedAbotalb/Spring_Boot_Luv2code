package com.mabotalb.aop_demo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{

    @Override
    public boolean addSillyMember() {
        System.out.println(getClass() + ": Doing my DB Work: Adding a Membership Account");

        return true;
    }

    @Override
    public void gotToSleep() {

        System.out.println(getClass() + ": I'm going to sleep now...");
    }

}
