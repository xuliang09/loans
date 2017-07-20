package com.loans.service.impl;

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
        try
        {
            if (user instanceof CompanyOrIndividual)
            {
                int state = userInfoDao.addCompanyOrIndividual((CompanyOrIndividual)user);
                return state;
            }
            else if (user instanceof OfficeWorker)
            {
                int state = userInfoDao.addOfficeWorker((OfficeWorker)user);
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

}
