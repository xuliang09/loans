package com.loans.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.loans.dao.UserInfoDao;
import com.loans.domain.CompanyOrIndividual;
import com.loans.domain.OfficeWorker;
import com.loans.domain.User;
import com.loans.service.UserInfoManage;

public class UserInfoManageImpl implements UserInfoManage
{
    @Autowired
    UserInfoDao userInfoDao;

    @Override
    public int addUser(User user)
    {
        if (user == null)
        {
            return 1;
        }

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 设置日期格式
        user.setCreateDate(df.format(new Date())); // 设置用户创建日期
        
        try
        {
            if (user instanceof CompanyOrIndividual)
            {
                int state = userInfoDao
                        .addCompanyOrIndividual((CompanyOrIndividual) user);
                return state;
            }
            else if (user instanceof OfficeWorker)
            {
                int state = userInfoDao.addOfficeWorker((OfficeWorker) user);
                return state;
            }
            else
            {
                return 1;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return 1;
        }
    }

    @Override
    public List<User> findByName(String name)
    {
        List<User> userList = new ArrayList<User>();
        try
        {
            List<CompanyOrIndividual> companyOrIndividualUserList = userInfoDao
                    .findByNameInCompanyOrIndividual(name);
            List<OfficeWorker> officeWorkerUserList = userInfoDao
                    .findByNameInOfficeWorker(name);

            if (companyOrIndividualUserList != null)
            {
                for (CompanyOrIndividual companyOrIndividual : companyOrIndividualUserList)
                {

                    userList.add(companyOrIndividual);
                }
            }
            if (officeWorkerUserList != null)
            {
                for (OfficeWorker officeWorker : officeWorkerUserList)
                {
                    userList.add(officeWorker);
                }
            }

            return userList;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public List<User> findByPhoneNumber(String phoneNumber)
    {
        List<User> userList = new ArrayList<User>();
        try
        {
            List<CompanyOrIndividual> companyOrIndividualUserList = userInfoDao
                    .findByPhoneNumberInCompanyOrIndividual(phoneNumber);
            List<OfficeWorker> officeWorkerUserList = userInfoDao
                    .findByPhoneNumberInOfficeWorker(phoneNumber);
            if (companyOrIndividualUserList != null)
            {
                for (CompanyOrIndividual companyOrIndividual : companyOrIndividualUserList)
                {
                    userList.add(companyOrIndividual);
                }
            }
            if (officeWorkerUserList != null)
            {
                for (OfficeWorker officeWorker : officeWorkerUserList)
                {
                    userList.add(officeWorker);
                }
            }

            return userList;
        }
        catch (Exception e)
        {
            return null;
        }
    }

}
