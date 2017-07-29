package com.loans.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.annotation.Id;

public abstract class User implements Comparable<User>
{
    // id
    @Id
    private String id;

    // 账户创建时间
    private String createDate;

    // 姓名
    private String name;

    // 手机号
    private String phoneNumber;

    // 需求金额
    private int demandMoney;

    // 贷款周期
    private String loanPeriod;

    // 户籍
    private String address;

    // 工作
    // 分为 企业主，个体，上班
    private String work;

    // 信用状况
    // 分为 无 或者 最长逾期时间
    private String credit;

    // 房产
    // 分为 有、无
    private String hasHouse;

    // 房产类型
    // 分为 商铺、别墅、住宅
    private String houseType;

    // 房产性质
    // 分为 商品房、保障性住房
    private String houseProperty;

    // 房产状态
    // 分为 全款、按揭
    private String houseState;

    // 本人名下有无车产
    // 分为 有、无
    private String hasCar;

    // 牌照归属地
    private String carLicenseBelong;

    // 车辆购买价格
    private String carPrice;

    // 车龄
    private String carAge;

    // 车辆有无贷款
    // 分为 有、无
    private String hasLoanOnCar;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getCreateDate()
    {
        return createDate;
    }

    public void setCreateDate(String createDate)
    {
        this.createDate = createDate;
    }

    public int getDemandMoney()
    {
        return demandMoney;
    }

    public void setDemandMoney(int demandMoney)
    {
        this.demandMoney = demandMoney;
    }

    public String getLoanPeriod()
    {
        return loanPeriod;
    }

    public void setLoanPeriod(String loanPeriod)
    {
        this.loanPeriod = loanPeriod;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getWork()
    {
        return work;
    }

    public void setWork(String work)
    {
        this.work = work;
    }

    public String getCredit()
    {
        return credit;
    }

    public void setCredit(String credit)
    {
        this.credit = credit;
    }

    public String getHasHouse()
    {
        return hasHouse;
    }

    public void setHasHouse(String hasHouse)
    {
        this.hasHouse = hasHouse;
    }

    public String getHouseType()
    {
        return houseType;
    }

    public void setHouseType(String houseType)
    {
        this.houseType = houseType;
    }

    public String getHouseProperty()
    {
        return houseProperty;
    }

    public void setHouseProperty(String houseProperty)
    {
        this.houseProperty = houseProperty;
    }

    public String getHouseState()
    {
        return houseState;
    }

    public void setHouseState(String houseState)
    {
        this.houseState = houseState;
    }

    public String getHasCar()
    {
        return hasCar;
    }

    public void setHasCar(String hasCar)
    {
        this.hasCar = hasCar;
    }

    public String getCarLicenseBelong()
    {
        return carLicenseBelong;
    }

    public void setCarLicenseBelong(String carLicenseBelong)
    {
        this.carLicenseBelong = carLicenseBelong;
    }

    public String getCarPrice()
    {
        return carPrice;
    }

    public void setCarPrice(String carPrice)
    {
        this.carPrice = carPrice;
    }

    public String getCarAge()
    {
        return carAge;
    }

    public void setCarAge(String carAge)
    {
        this.carAge = carAge;
    }

    public String getHasLoanOnCar()
    {
        return hasLoanOnCar;
    }

    public void setHasLoanOnCar(String hasLoanOnCar)
    {
        this.hasLoanOnCar = hasLoanOnCar;
    }
    
    public int compareTo(User other)
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        try
        {
            Date data = df.parse(this.createDate);
            Date otherDate = df.parse(other.createDate);
            
            return data.compareTo(otherDate);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
            return 0;
        }
        
    }
}
