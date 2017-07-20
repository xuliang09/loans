package com.loans.dao;

import com.loans.domain.CompanyOrIndividual;
import com.loans.domain.OfficeWorker;

public interface UserInfoDao
{
    int addCompanyOrIndividual(CompanyOrIndividual user);
    
    int addOfficeWorker(OfficeWorker user);
}
