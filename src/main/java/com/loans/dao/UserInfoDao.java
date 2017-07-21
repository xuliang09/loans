package com.loans.dao;

import java.util.List;

import com.loans.domain.CompanyOrIndividual;
import com.loans.domain.OfficeWorker;

public interface UserInfoDao
{
    int addCompanyOrIndividual(CompanyOrIndividual user);

    int addOfficeWorker(OfficeWorker user);

    List<CompanyOrIndividual> findByNameInCompanyOrIndividual(String name);

    List<OfficeWorker> findByNameInOfficeWorker(String name);

    List<CompanyOrIndividual> findByPhoneNumberInCompanyOrIndividual(
            String phoneNumber);

    List<OfficeWorker> findByPhoneNumberInOfficeWorker(String phoneNumber);
}
