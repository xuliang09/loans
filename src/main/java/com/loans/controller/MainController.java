package com.loans.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.loans.domain.CompanyOrIndividual;
import com.loans.domain.OfficeWorker;
import com.loans.service.UserInfoManage;

/**
 * 用户界面交互类 〈一句话功能简述〉
 *
 * <p>
 * 〈功能详细描述〉
 * 
 * @author xul 2017年7月16日
 * @see [相关类/方法]
 * @since 1.0
 */
@Controller
public class MainController
{
    @Autowired
    UserInfoManage userInfoManage;

    // 判断连通
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index()
    {
        return "index";
    }

    // 添加用户
    // companyindividualorofficeworker变量表明是企业、个人用户还是上班族
    @RequestMapping(value = "/adduser", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public @ResponseBody String addUser(
            @RequestParam(value = "companyOrIndividualOrOfficeWorker", required = false) String companyOrIndividualOrOfficeWorker,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "phoneNumber", required = false) String phoneNumber,
            @RequestParam(value = "demandMoney", required = false) String demandMoney,
            @RequestParam(value = "loanPeriod", required = false) String loanPeriod,
            @RequestParam(value = "address", required = false) String address,
            @RequestParam(value = "work", required = false) String work,
            @RequestParam(value = "credit", required = false) String credit,
            @RequestParam(value = "hasHouse", required = false) String hasHouse,
            @RequestParam(value = "houseType", required = false) String houseType,
            @RequestParam(value = "houseProperty", required = false) String houseProperty,
            @RequestParam(value = "houseState", required = false) String houseState,
            @RequestParam(value = "hasCar", required = false) String hasCar,
            @RequestParam(value = "carLicenseBelong", required = false) String carLicenseBelong,
            @RequestParam(value = "carPrice", required = false) String carPrice,
            @RequestParam(value = "carAge", required = false) String carAge,
            @RequestParam(value = "hasLoanOnCar", required = false) String hasLoanOnCar,
            @RequestParam(value = "monthlySalary", required = false) String monthlySalary,
            @RequestParam(value = "provideIncomeProof", required = false) String provideIncomeProof,
            @RequestParam(value = "workTimeInCurrentCompany", required = false) String workTimeInCurrentCompany,
            @RequestParam(value = "workplace", required = false) String workplace,
            @RequestParam(value = "publicFundOfSocialSecurity", required = false) String publicFundOfSocialSecurity,
            @RequestParam(value = "continuedPayTimeOfSocialSecurityPublicFund", required = false) String continuedPayTimeOfSocialSecurityPublicFund,
            @RequestParam(value = "legalRepresentative", required = false) String legalRepresentative,
            @RequestParam(value = "companyOpearteState", required = false) String companyOpearteState,
            @RequestParam(value = "businessLicenseAge", required = false) String businessLicenseAge,
            @RequestParam(value = "publicAccountMonthly", required = false) String publicAccountMonthly,
            @RequestParam(value = "privateAccountMonthly", required = false) String privateAccountMonthly,
            HttpServletRequest request, HttpServletResponse response)
    {
        Map<String, String> result = new HashMap<String, String>();
        if (companyOrIndividualOrOfficeWorker.equals("companyindividual"))
        {
            CompanyOrIndividual user = new CompanyOrIndividual();
            // TODO: 组装user
            userInfoManage.addUser(user);
            result.put("state", "0");
        }
        else if (companyOrIndividualOrOfficeWorker.equals("officeworker"))
        {
            OfficeWorker user = new OfficeWorker();
            // TODO: 组装user
            userInfoManage.addUser(user);
            result.put("state", "0");
        }
        else
        {
            result.put("state", "1");
        }

        return new Gson().toJson(result);
    }
}
