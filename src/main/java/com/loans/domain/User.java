package com.loans.domain;

public abstract class User
{
    private String createTime;

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
    private int carAge;

    // 车辆有无贷款
    // 分为 有、无
    private String hasLoanOnCar;

    public String getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
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

    public int getCarAge()
    {
        return carAge;
    }

    public void setCarAge(int carAge)
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
}