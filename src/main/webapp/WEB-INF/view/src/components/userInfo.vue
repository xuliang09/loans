<template>
  <div class="info">
      <div class="main-info">
        <div class="demand-money-wrapper">
          <span class="text">需求金额：</span>
          <input class="demand-money" v-model="user.demandMoney"/>
          <span class="demand-money-unit">元</span>
        </div>
        <div class="loan-period-wrapper">
          <span class="text">贷款周期：</span>
          <input class="loan-period" v-model="user.loanPeriod"/>
          <select class="loan-period-unit">
            <option selected value="day">天</option>
            <option value="month">月</option>
            <option value="year">年</option>
          </select>
        </div>
        <div class="address-wrapper">
          <span class="text">户籍：</span>
          <input class="address" placeholder="省 - 市/县" v-model="user.address"/>
        </div>
        <div class="work-wrapper">
          <span class="text">工作：</span>
          <select class="work" v-model="user.work">
            <option value="company">企业主</option>
            <option value="individual">个体户</option>
            <option value="officeWork">上班</option>
          </select>
        </div>
      </div>
      <div class="identity-info">
        <div class="company-wrapper" v-if="user.work === 'company' || user.work === 'individual'">
          <div class="legal-representative-wrapper">
            <span class="text">是否法人代表：</span>
            <select class="legal-representative" v-model="user.legalRepresentative">
              <option selected value="yes">是</option>
              <option value="no">否</option>
            </select>
          </div>
          <div class="company-opearte-state-wrapper">
            <span class="text">企业是否正常运营：</span>
            <select class="company-opearte-state" v-model="user.companyOpearteState">
              <option selected value="yes">是</option>
              <option value="no">否</option>
            </select>
          </div>
          <div class="business-license-age-wrapper">
            <span class="text">营业执照年限：</span>
            <input class="business-license-age" v-model="user.businessLicenseAge"/>
            <span class="business-license-age-unit">年</span>
          </div>
          <div class="public-account-monthly-wrapper">
            <span class="text">月对公流水：</span>
            <input class="public-account-monthly" v-model="user.publicAccountMonthly"/>
            <span class="public-account-monthly-unit">元</span>
          </div>
          <div class="private-account-monthly-wrapper">
            <span class="text">月对私流水：</span>
            <input class="private-account-monthly" v-model="user.privateAccountMonthly"/>
            <span class="private-account-monthly-unit">元</span>
          </div>
        </div>
        <div class="worker-wrapper" v-if="user.work === 'officeWork'">
          <div class="monthly-salary-wrapper">
            <span class="text">月打卡工资：</span>
            <input class="monthly-salary" v-model="user.monthlySalary"/>
            <span class="monthly-salary-unit">元</span>
          </div>
          <div class="provide-income-proof-wrapper">
            <span class="text">能否提供收入证明：</span>
            <select class="provide-income-proof" v-model="user.provideIncomeProof">
              <option selected value="yes">是</option>
              <option value="no">否</option>
            </select>
          </div>
          <div class="work-time-wrapper">
            <span class="text">现单位工作时间：</span>
            <input class="work-time" v-model="user.workTimeInCurrentCompany"/>
            <select class="work-time-unit">
              <option value="month">月</option>
              <option selected value="year">年</option>
            </select>
          </div>
          <div class="workplace-wrapper">
            <span class="text">工作所在地：</span>
            <input class="workplace" v-model="user.workplace"/>
          </div>
          <div class="social-security-wrapper">
            <span class="text">有无社保公积金：</span>
            <select class="social-security" v-model="user.publicFundOfSocialSecurity">
              <option selected value="yes">有</option>
              <option value="no">无</option>
            </select>
          </div>
          <div class="pay-time-wrapper">
            <span class="text">社保公积金连续缴纳时间：</span>
            <input class="pay-time" v-model="user.continuedPayTimeOfSocialSecurityPublicFund"/>
            <select class="pay-time-unit">
              <option value="month">月</option>
              <option selected value="year">年</option>
            </select>
          </div>
        </div>
      </div>
      <div class="user-info">
        <div class="credit-wrapper">
          <span class="text">近半年有无逾期（最长逾期时间）：</span>
          <input class="credit-time" v-model="user.credit"/>
        </div>
        <div class="house-wrapper">
          <span class="text">本人名下是否有房产：</span>
          <select class="house" v-model="user.hasHouse">
            <option selected value="yes">有</option>
            <option value="no">无</option>
          </select>
          <div class="house-type-wrapper" v-if="user.house === 'yes'">
            <span class="text">房产类型：</span>
            <select class="house-type" v-model="user.houseType">
              <option value="shop">商铺</option>
              <option value="villa">别墅</option>
              <option value="house">住宅</option>
            </select>
          </div>
          <div class="house-property-wrapper" v-if="user.houseType === 'house' && user.house === 'yes'">
            <span class="text">房产性质：</span>
            <select class="house-property" v-model="user.houseProperty">
              <option selected value="commercial">商品房</option>
              <option value="indemnificatory">保障性住房</option>
            </select>
          </div>
          <div class="house-state-wrapper" v-if="user.house === 'yes'">
            <span class="text">房产状态：</span>
            <select class="house-state" v-model="user.houseState">
              <option selected value="full">全款</option>
              <option value="mortgage">按揭</option>
            </select>
          </div>
        </div>
        
        <div class="car-wrapper">
          <span class="text">本人名下有无车产：</span>
          <select class="car" v-model="user.hasCar">
            <option selected value="yes">有</option>
            <option value="no">无</option>
          </select>
        </div>
        <div class="car-license-wrapper" v-if="user.car === 'yes'">
          <span class="text">牌照归属地：</span>
          <input class="car-license" placeholder="省 - 市" v-model="user.carLicenseBelong"/>
        </div>
        <div class="car-price-wrapper" v-if="user.car === 'yes'">
          <span class="text">车辆购买价格：</span>
          <input class="car-price" v-model="user.carPrice"/>
          <span class="car-price-unit">元</span>
        </div>
        <div class="car-age-wrapper" v-if="user.car === 'yes'">
          <span class="text">车龄：</span>
          <input class="car-age" v-model="user.carAge"/>
          <select class="car-age-unit">
            <option selected value="month">月</option>
            <option value="year">年</option>
          </select>
        </div>
        <div class="car-loan-wrapper" v-if="user.car === 'yes'">
          <span class="text">车辆有无贷款：</span>
          <select class="car-loan" v-model="user.hasLoanOnCar">
            <option value="yes">有</option>
            <option selected value="no">无</option>
          </select>
        </div>
      </div>
      <div class="submit" @click="submitInfo">确认提交</div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  props: {
    user: {
      type: Object
    }
  },
  methods: {
    submitInfo () {
      console.log(JSON.stringify(this.user))
      axios({
        method: 'post',
        url: './adduser',
        data: {
          JSON: JSON.stringify(this.user)
        }
      })
    }
  }
}
</script>

<style lang="less">
  .info {
    // width: 100%;
    margin: 10px 10px;
    .main-info {
      width: 100%;
      margin: 20px 0;
    }
    .identity-info {
      width: 100%;
      margin: 20px 0; 
    }
    .user-info {
      width: 100%;
      margin: 20px 0; 
    }
  }
</style>
