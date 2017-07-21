package com.loans.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.loans.dao.UserInfoDao;
import com.loans.domain.CompanyOrIndividual;
import com.loans.domain.OfficeWorker;

public class UserInfoDaoImpl implements UserInfoDao
{
    @Autowired
    MongoOperations mongoOperations;

    @Override
    public int addCompanyOrIndividual(CompanyOrIndividual user)
    {
        try
        {
            mongoOperations.save(user);
            return 0;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return 1;
        }
    }

    @Override
    public int addOfficeWorker(OfficeWorker user)
    {
        try
        {
            mongoOperations.save(user);
            return 0;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return 1;
        }
    }

    @Override
    public List<CompanyOrIndividual> findByNameInCompanyOrIndividual(
            String name)
    {
        try
        {
            List<CompanyOrIndividual> userList = mongoOperations.find(
                    new Query(Criteria.where("name").is(name)),
                    CompanyOrIndividual.class);
            return userList;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<OfficeWorker> findByNameInOfficeWorker(String name)
    {
        try
        {
            List<OfficeWorker> userList = mongoOperations.find(
                    new Query(Criteria.where("name").is(name)),
                    OfficeWorker.class);
            return userList;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<CompanyOrIndividual> findByPhoneNumberInCompanyOrIndividual(
            String phoneNumber)
    {
        try
        {
            List<CompanyOrIndividual> userList = mongoOperations.find(
                    new Query(Criteria.where("phoneNumber").is(phoneNumber)),
                    CompanyOrIndividual.class);
            return userList;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<OfficeWorker> findByPhoneNumberInOfficeWorker(
            String phoneNumber)
    {
        try
        {
            List<OfficeWorker> userList = mongoOperations.find(
                    new Query(Criteria.where("phoneNumber").is(phoneNumber)),
                    OfficeWorker.class);
            return userList;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

}
