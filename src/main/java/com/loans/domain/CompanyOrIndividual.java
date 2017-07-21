package com.loans.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CompanyOrIndividual")
public class CompanyOrIndividual extends User
{
    // 是否法人代表
    private String legalRepresentative;

    // 企业是否正常运营
    private String companyOpearteState;

    // 营业执照年限
    private String businessLicenseAge;

    // 月对公流水
    private String publicAccountMonthly;

    // 月对私流水
    private String privateAccountMonthly;

    public String getLegalRepresentative()
    {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative)
    {
        this.legalRepresentative = legalRepresentative;
    }

    public String getCompanyOpearteState()
    {
        return companyOpearteState;
    }

    public void setCompanyOpearteState(String companyOpearteState)
    {
        this.companyOpearteState = companyOpearteState;
    }

    public String getBusinessLicenseAge()
    {
        return businessLicenseAge;
    }

    public void setBusinessLicenseAge(String businessLicenseAge)
    {
        this.businessLicenseAge = businessLicenseAge;
    }

    public String getPublicAccountMonthly()
    {
        return publicAccountMonthly;
    }

    public void setPublicAccountMonthly(String publicAccountMonthly)
    {
        this.publicAccountMonthly = publicAccountMonthly;
    }

    public String getPrivateAccountMonthly()
    {
        return privateAccountMonthly;
    }

    public void setPrivateAccountMonthly(String privateAccountMonthly)
    {
        this.privateAccountMonthly = privateAccountMonthly;
    }
}
