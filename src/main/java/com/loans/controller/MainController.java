package com.loans.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.loans.domain.CompanyOrIndividual;
import com.loans.domain.OfficeWorker;
import com.loans.domain.User;
import com.loans.sms.CloudMessage;
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

    @Autowired
    CloudMessage cloudMessage;

    // 网站主页
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index()
    {
        return "index";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search()
    {
        return "search";
    }

    @RequestMapping(value = "/search_return", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public @ResponseBody String search_return(@RequestParam String name,
            @RequestParam String phoneNumber)
    {
        Map<String, String> user = new HashMap<String, String>();

        if (name != null && !name.isEmpty())
        {
            List<User> userList = userInfoManage.findByName(name);

            String userStr = getLatestUser(userList);
            if (null == userStr || userStr.isEmpty())
            {
                user.put("state", "403");
            }
            else
            {
                user.put("state", "200");
                user.put("user", userStr);
            }

        }
        else if (phoneNumber != null && !phoneNumber.isEmpty())
        {
            List<User> userList = userInfoManage.findByPhoneNumber(phoneNumber);
            String userStr = getLatestUser(userList);
            if (null == userStr || userStr.isEmpty())
            {
                user.put("state", "403");
            }
            else
            {
                user.put("state", "200");
                user.put("user", userStr);
            }
        }
        else
        {
            user.put("state", "403");
        }

        return new Gson().toJson(user);
    }

    /**
     * 取最新的那个并组成一个String
     * 
     * @param userList
     * @return
     */
    private String getLatestUser(List<User> userList)
    {
        if (null == userList || userList.isEmpty())
        {
            return null;
        }

        Collections.sort(userList);
        User user = userList.get(0);

        StringBuilder res = new StringBuilder();
        res.append("姓名:  " + user.getName() + "\n");
        res.append("手机号:  " + user.getPhoneNumber() + "\n");
        res.append("需求金额:  " + user.getDemandMoney() + "\n");
        res.append("贷款周期:  " + user.getLoanPeriod() + "\n");
        res.append("户籍:  " + user.getAddress() + "\n");
        res.append("工作:  " + user.getWork() + "\n");
        res.append("近半年有无逾期（最长逾期时间）:  " + user.getCredit() + "\n");
        res.append("房产:  " + user.getHasHouse() + "\n");
        res.append("房产类型:  " + user.getHouseType() + "\n");
        res.append("房产性质:  " + user.getHouseProperty() + "\n");
        res.append("房产状态:  " + user.getHouseState() + "\n");
        res.append("有无车产:  " + user.getHasCar() + "\n");
        res.append("车牌照归属地:  " + user.getCarLicenseBelong() + "\n");
        res.append("车辆购买价格:  " + user.getCarPrice() + "\n");
        res.append("车龄：  " + user.getCarAge() + "\n");
        res.append("车辆是否贷款:  " + user.getHasLoanOnCar() + "\n");

        if (user instanceof CompanyOrIndividual)
        {
            CompanyOrIndividual user1 = (CompanyOrIndividual) user;
            res.append("是否法人代表:  " + user1.getLegalRepresentative() + "\n");
            res.append("企业是否正常运营:  " + user1.getCompanyOpearteState() + "\n");
            res.append("营业执照年限:  " + user1.getBusinessLicenseAge() + "\n");
            res.append("月对公流水:  " + user1.getPublicAccountMonthly() + "\n");
            res.append("月对私流水:  " + user1.getPrivateAccountMonthly() + "\n");
        }
        else if (user instanceof OfficeWorker)
        {
            OfficeWorker user1 = (OfficeWorker) user;
            res.append("月打卡工资:  " + user1.getMonthlySalary() + "\n");
            res.append("能否提供收入证明:  " + user1.getProvideIncomeProof() + "\n");
            res.append(
                    "现单位工作时间:  " + user1.getWorkTimeInCurrentCompany() + "\n");
            res.append("工作所在地:  " + user1.getWorkplace() + "\n");
            res.append("有无社保公积金:  " + user1.getPublicFundOfSocialSecurity()
                    + "\n");
            res.append("社保公积金连续缴纳时间:  "
                    + user1.getContinuedPayTimeOfSocialSecurityPublicFund()
                    + "\n");
        }
        else
        {
            return null;
        }
        return res.toString();
    }

    // 添加用户
    @RequestMapping(value = "/adduser", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public @ResponseBody String addUser(@RequestBody Map<String, String> map,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {
        String name = map.get("name");
        String phoneNumber = map.get("phoneNumber");
        String demandMoney = map.get("demandMoney");
        String loanPeriod = map.get("loanPeriod");
        String address = map.get("address");
        String work = map.get("work");
        String credit = map.get("credit");
        String hasHouse = map.get("hasHouse");
        String houseType = map.get("houseType");
        String houseProperty = map.get("houseProperty");
        String houseState = map.get("houseState");
        String hasCar = map.get("hasCar");
        String carLicenseBelong = map.get("carLicenseBelong");
        String carPrice = map.get("carPrice");
        String carAge = map.get("carAge");
        String hasLoanOnCar = map.get("hasLoanOnCar");
        String monthlySalary = map.get("monthlySalary");
        String provideIncomeProof = map.get("provideIncomeProof");
        String workTimeInCurrentCompany = map.get("workTimeInCurrentCompany");
        String workplace = map.get("workplace");
        String publicFundOfSocialSecurity = map
                .get("publicFundOfSocialSecurity");
        String continuedPayTimeOfSocialSecurityPublicFund = map
                .get("continuedPayTimeOfSocialSecurityPublicFund");
        String legalRepresentative = map.get("legalRepresentative");
        String companyOpearteState = map.get("companyOpearteState");
        String businessLicenseAge = map.get("businessLicenseAge");
        String publicAccountMonthly = map.get("publicAccountMonthly");
        String privateAccountMonthly = map.get("privateAccountMonthly");

        Map<String, String> result = new HashMap<String, String>();
        if (work.equals("企业主") || work.equals("个体户"))
        {
            CompanyOrIndividual user = new CompanyOrIndividual();
            user.setName(name);
            user.setPhoneNumber(phoneNumber);
            user.setDemandMoney(Integer.valueOf(demandMoney));
            user.setLoanPeriod(loanPeriod);
            user.setAddress(address);
            user.setWork(work);
            user.setCredit(credit);
            user.setHasHouse(hasHouse);
            user.setHouseType(houseType);
            user.setHouseProperty(houseProperty);
            user.setHouseState(houseState);
            user.setHasCar(hasCar);
            user.setCarLicenseBelong(carLicenseBelong);
            user.setCarPrice(carPrice);
            user.setCarAge(carAge);
            user.setHasLoanOnCar(hasLoanOnCar);

            user.setLegalRepresentative(legalRepresentative);
            user.setCompanyOpearteState(companyOpearteState);
            user.setBusinessLicenseAge(businessLicenseAge);
            user.setPublicAccountMonthly(publicAccountMonthly);
            user.setPrivateAccountMonthly(privateAccountMonthly);

            userInfoManage.addUser(user);
            cloudMessage.sendSms(name, phoneNumber);
            result.put("state", "200");
        }
        else if (work.equals("上班族"))
        {
            OfficeWorker user = new OfficeWorker();
            user.setName(name);
            user.setPhoneNumber(phoneNumber);
            user.setDemandMoney(Integer.valueOf(demandMoney));
            user.setLoanPeriod(loanPeriod);
            user.setAddress(address);
            user.setWork(work);
            user.setCredit(credit);
            user.setHasHouse(hasHouse);
            user.setHouseType(houseType);
            user.setHouseProperty(houseProperty);
            user.setHouseState(houseState);
            user.setHasCar(hasCar);
            user.setCarLicenseBelong(carLicenseBelong);
            user.setCarPrice(carPrice);
            user.setCarAge(carAge);
            user.setHasLoanOnCar(hasLoanOnCar);

            user.setMonthlySalary(Double.valueOf(monthlySalary));
            user.setProvideIncomeProof(provideIncomeProof);
            user.setWorkTimeInCurrentCompany(workTimeInCurrentCompany);
            user.setWorkplace(workplace);
            user.setPublicFundOfSocialSecurity(publicFundOfSocialSecurity);
            user.setContinuedPayTimeOfSocialSecurityPublicFund(
                    continuedPayTimeOfSocialSecurityPublicFund);

            userInfoManage.addUser(user);
            cloudMessage.sendSms(name, phoneNumber);
            result.put("state", "200");
        }
        else
        {
            result.put("state", "403");
        }

        return new Gson().toJson(result);
    }
}
