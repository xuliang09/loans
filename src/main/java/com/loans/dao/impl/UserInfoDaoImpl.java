package com.loans.dao.impl;

import com.loans.dao.UserInfoDao;
import com.loans.domain.CompanyOrIndividual;
import com.loans.domain.OfficeWorker;

public class UserInfoDaoImpl implements UserInfoDao
{
    @Override
    public int addCompanyOrIndividual(CompanyOrIndividual user)
    {
        try
        {
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
            return 0;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return 1;
        }
    }

}
