package com.loans.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "OfficeWorker")
public class OfficeWorker extends User
{
    // 月打卡工资
    private double monthlySalary;

    // 能否提供收入证明
    private String provideIncomeProof;

    // 现单位工作时间
    private String workTimeInCurrentCompany;

    // 工作所在地
    private String workplace;

    // 有无社保公积金
    private String publicFundOfSocialSecurity;

    // 社保公积金连续缴纳时间
    private String continuedPayTimeOfSocialSecurityPublicFund;

    public double getMonthlySalary()
    {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary)
    {
        this.monthlySalary = monthlySalary;
    }

    public String getProvideIncomeProof()
    {
        return provideIncomeProof;
    }

    public void setProvideIncomeProof(String provideIncomeProof)
    {
        this.provideIncomeProof = provideIncomeProof;
    }

    public String getWorkTimeInCurrentCompany()
    {
        return workTimeInCurrentCompany;
    }

    public void setWorkTimeInCurrentCompany(String workTimeInCurrentCompany)
    {
        this.workTimeInCurrentCompany = workTimeInCurrentCompany;
    }

    public String getWorkplace()
    {
        return workplace;
    }

    public void setWorkplace(String workplace)
    {
        this.workplace = workplace;
    }

    public String getPublicFundOfSocialSecurity()
    {
        return publicFundOfSocialSecurity;
    }

    public void setPublicFundOfSocialSecurity(String publicFundOfSocialSecurity)
    {
        this.publicFundOfSocialSecurity = publicFundOfSocialSecurity;
    }

    public String getContinuedPayTimeOfSocialSecurityPublicFund()
    {
        return continuedPayTimeOfSocialSecurityPublicFund;
    }

    public void setContinuedPayTimeOfSocialSecurityPublicFund(
            String continuedPayTimeOfSocialSecurityPublicFund)
    {
        this.continuedPayTimeOfSocialSecurityPublicFund = continuedPayTimeOfSocialSecurityPublicFund;
    }
}
