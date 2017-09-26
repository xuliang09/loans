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
        </div>
        <div class="address-wrapper">
          <span class="text">户籍：</span>
          <input class="address" placeholder="省 - 市/县" v-model="user.address"/>
        </div>
        <div class="work-wrapper">
          <span class="text">工作：</span>
          <select class="work" v-model="user.work" @change="changeWork">
            <option value="企业主">企业主</option>
            <option value="个体户">个体户</option>
            <option value="上班族">上班族</option>
          </select>
        </div>
      </div>
      <div class="identity-info">
        <div class="company-wrapper" v-if="user.work === '企业主' || user.work === '个体户'">
          <div class="legal-representative-wrapper">
            <span class="text">是否法人代表：</span>
            <select class="legal-representative" v-model="user.legalRepresentative">
              <option selected value="是">是</option>
              <option value="否">否</option>
            </select>
          </div>
          <div class="company-opearte-state-wrapper">
            <span class="text">企业是否正常运营：</span>
            <select class="company-opearte-state" v-model="user.companyOpearteState">
              <option selected value="是">是</option>
              <option value="否">否</option>
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
        <div class="worker-wrapper" v-if="user.work === '上班族'">
          <div class="monthly-salary-wrapper">
            <span class="text">月打卡工资：</span>
            <input class="monthly-salary" v-model="user.monthlySalary"/>
            <span class="monthly-salary-unit">元</span>
          </div>
          <div class="provide-income-proof-wrapper">
            <span class="text">能否提供收入证明：</span>
            <select class="provide-income-proof" v-model="user.provideIncomeProof">
              <option selected value="是">是</option>
              <option value="否">否</option>
            </select>
          </div>
          <div class="work-time-wrapper">
            <span class="text">现单位工作时间：</span>
            <input class="work-time" v-model="user.workTimeInCurrentCompany"/>
          </div>
          <div class="workplace-wrapper">
            <span class="text">工作所在地：</span>
            <input class="workplace" v-model="user.workplace"/>
          </div>
          <div class="social-security-wrapper">
            <span class="text">有无社保公积金：</span>
            <select class="social-security" v-model="user.publicFundOfSocialSecurity">
              <option selected value="有">有</option>
              <option value="无">无</option>
            </select>
          </div>
          <div class="pay-time-wrapper" v-if="user.publicFundOfSocialSecurity === '有'">
            <span class="text">社保公积金连续缴纳时间：</span>
            <input class="pay-time" v-model="user.continuedPayTimeOfSocialSecurityPublicFund"/>
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
          <select class="house" v-model="user.hasHouse" @change="changeHouse">
            <option value="有">有</option>
            <option value="无">无</option>
          </select>
        </div>
        <div class="house-type-wrapper" v-if="user.hasHouse === '有'">
          <span class="text">房产类型：</span>
          <select class="house-type" v-model="user.houseType" @change="changeHouseType">
            <option value="商铺">商铺</option>
            <option value="别墅">别墅</option>
            <option value="住宅">住宅</option>
          </select>
        </div>
        <div class="house-property-wrapper" v-if="user.houseType === '住宅' && user.hasHouse === '有'">
          <span class="text">房产性质：</span>
          <select class="house-property" v-model="user.houseProperty">
            <option value="商品房">商品房</option>
            <option value="保障性住房">保障性住房</option>
          </select>
        </div>
        <div class="house-state-wrapper" v-if="user.hasHouse === '有'">
          <span class="text">房产状态：</span>
          <select class="house-state" v-model="user.houseState">
            <option value="全款">全款</option>
            <option value="按揭">按揭</option>
          </select>
        </div>
        <div class="car-wrapper">
          <span class="text">本人名下有无车产：</span>
          <select class="car" v-model="user.hasCar" @change="changeCar">
            <option value="有">有</option>
            <option value="无">无</option>
          </select>
        </div>
        <div class="car-license-wrapper" v-if="user.hasCar === '有'">
          <span class="text">牌照归属地：</span>
          <input class="car-license" placeholder="省 - 市" v-model="user.carLicenseBelong"/>
        </div>
        <div class="car-price-wrapper" v-if="user.hasCar === '有'">
          <span class="text">车辆购买价格：</span>
          <input class="car-price" v-model="user.carPrice"/>
          <span class="car-price-unit">元</span>
        </div>
        <div class="car-age-wrapper" v-if="user.hasCar === '有'">
          <span class="text">车龄：</span>
          <input class="car-age" v-model="user.carAge"/>
        </div>
        <div class="car-loan-wrapper" v-if="user.hasCar === '有'">
          <span class="text">车辆有无贷款：</span>
          <select class="car-loan" v-model="user.hasLoanOnCar">
            <option value="有">有</option>
            <option value="无">无</option>
          </select>
        </div>
      </div>
      <div class="submit" @click="submitInfo">确认提交</div>
      <div class="footer"> 网站备案号：苏ICP备17057254号-1 </div>
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
      // console.log(this.user)
      axios({
        method: 'post',
        url: './adduser',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        data: JSON.stringify(this.user)
      }).then(res => {
        console.log(res)
        if (res.status === 200) {
          alert('提交成功！')
        } else {
          alert('提交失败，请稍后再试！')
        }
      }).catch(() => {
        alert('提交失败，请稍后再试！')
      })
    },
    changeWork () {
      this.user.legalRepresentative = ''
      this.user.companyOpearteState = ''
      this.user.businessLicenseAge = ''
      this.user.publicAccountMonthly = ''
      this.user.privateAccountMonthly = ''
      this.user.monthlySalary = ''
      this.user.provideIncomeProof = ''
      this.user.workTimeInCurrentCompany = ''
      this.user.workplace = ''
      this.user.publicFundOfSocialSecurity = ''
      this.user.continuedPayTimeOfSocialSecurityPublicFund = ''
    },
    changeHouse () {
      this.user.houseType = ''
      this.user.houseProperty = ''
      this.user.houseState = ''
    },
    changeHouseType () {
      this.user.houseProperty = ''
      this.user.houseState = ''
    },
    changeCar () {
      this.user.carLicenseBelong = ''
      this.user.carPrice = ''
      this.user.carAge = ''
      this.user.hasLoanOnCar = ''
    }
  }
}
</script>

<style lang="less" scoped>
  .info {
    &:before {
      display: block;
      position: fixed;
      top: 0;
      left: 0;
      content: '';
      width: 100%;
      height: 100%;
      background: url('../assets/bg_img.jpg');
      background-size: cover;
      background-repeat: no-repeat;
      z-index: -1;
      opacity: 0.5;
    }
    // width: 100%;
    margin: 10px;
    margin-top: 0;
    .main-info {
      width: 100%;
      margin: 0 0 20px;
      padding-top: 20px;
      .demand-money-wrapper {
        display: flex;
        margin: 0 0 10px;
        .text {
          display: inline-block;
          flex: 0 0 80px;
          height: 21px;
          line-height: 21px;
        }
        .demand-money {
          display: inline-block;
          flex: 1;
          margin: 0 10px;
          height: 17px;
          line-height: 17px;
          overflow: hidden;
        }
        .demand-money-unit {
          display: inline-block;
          flex: 0 0 16px;
          height: 21px;
          line-height: 21px;
        }
      }
      .loan-period-wrapper {
        display: flex;
        margin: 10px 0;
        .text {
          display: inline-block;
          flex: 0 0 80px;
          height: 21px;
          line-height: 21px;
        }
        .loan-period {
          display: inline-block;
          flex: 1;
          margin-left: 10px;
          margin-right: 26px;
          height: 17px;
          line-height: 17px;
          overflow: hidden;
        }
      }
      .address-wrapper {
        display: flex;
        margin: 10px 0;
        .text {
          display: inline-block;
          flex: 0 0 80px;
          height: 21px;
          line-height: 21px;
        }
        .address {
          display: inline-block;
          flex: 1;
          margin-left: 10px;
          margin-right: 26px;
          height: 17px;
          line-height: 17px;
          overflow: hidden;
        }
      }
      .work-wrapper {
        display: flex;
        margin: 10px 0;
        .text {
          display: inline-block;
          flex: 0 0 80px;
          height: 21px;
          line-height: 21px;
        }
        .work {
          display: inline-block;
          flex: 1;
          height: 21px;
          line-height: 21px;
          margin-left: 10px;
          margin-right: 26px;
        }
      }
    }
    .identity-info {
      width: 100%;
      margin: 20px 0;
      .legal-representative-wrapper {
        display: flex;
        margin: 10px 0;
        .text {
          display: inline-block;
          flex: 0 0 144px;
          height: 21px;
          line-height: 21px;
        }
        .legal-representative {
          display: inline-block;
          flex: 1;
          height: 21px;
          line-height: 21px;
          margin-left: 10px;
          margin-right: 26px;
        }
      }
      .company-opearte-state-wrapper {
        .legal-representative-wrapper;
        .company-opearte-state {
          .legal-representative;
        }
      }
      .business-license-age-wrapper {
        .legal-representative-wrapper;
        .business-license-age {
          display: inline-block;
          flex: 1;
          margin: 0 10px;
          height: 17px;
          line-height: 17px;
          overflow: hidden;
        }
        .business-license-age-unit {
          display: inline-block;
          flex: 0 0 16px;
          height: 21px;
          line-height: 21px;
        }
      }
      .public-account-monthly-wrapper {
        .business-license-age-wrapper;
        .public-account-monthly {
          .business-license-age;
        }
        .public-account-monthly-unit {
          .business-license-age-unit;
        }
      }
      .private-account-monthly-wrapper {
        .business-license-age-wrapper;
        .private-account-monthly {
          .business-license-age;
        }
        .private-account-monthly-unit {
          .business-license-age-unit;
        }
      }
      .monthly-salary-wrapper {
        display: flex;
        margin: 10px 0;
        .text {
          display: inline-block;
          flex: 0 0 192px;
          height: 21px;
          line-height: 21px;
        }
        .monthly-salary {
          display: inline-block;
          flex: 1;
          margin: 0 10px;
          height: 17px;
          line-height: 17px;
          overflow: hidden;
        }
        .monthly-salary-unit {
          display: inline-block;
          flex: 0 0 16px;
          height: 21px;
          line-height: 21px;
        }
      }
      .provide-income-proof-wrapper {
        display: flex;
        margin: 10px 0;
        .text {
          display: inline-block;
          flex: 0 0 192px;
          height: 21px;
          line-height: 21px;
        }
        .provide-income-proof {
          display: inline-block;
          flex: 1;
          height: 21px;
          line-height: 21px;
          margin-left: 10px;
          margin-right: 26px;
        }
      }
      .work-time-wrapper {
        .monthly-salary-wrapper;
        .work-time {
          display: inline-block;
          flex: 1;
          margin-left: 10px;
          margin-right: 26px;
          height: 17px;
          line-height: 17px;
          overflow: hidden;
        }
      }
      .workplace-wrapper {
        .work-time-wrapper;
        .workplace {
          .work-time;
        }
      }
      .social-security-wrapper {
        .provide-income-proof-wrapper;
        .social-security {
          .provide-income-proof;
        }
      }
      .pay-time-wrapper {
        .work-time-wrapper;
        .pay-time {
          .work-time;
        }
      }
    }
    .user-info {
      width: 100%;
      margin: 20px 0;
      .credit-wrapper {
        margin: 10px 0;
        flex-wrap: wrap;
        display: flex;
        .text {
          width: 100%;
          height: 21px;
          line-height: 21px;
        }
        .credit-time {
          flex: 1;
          margin: 5px 26px 0 90px;
          overflow: hidden;
        }
      }
      .house-wrapper {
        display: flex;
        margin: 10px 0;
        .text {
          display: inline-block;
          flex: 0 0 160px;
          height: 21px;
          line-height: 21px;
        }
        .house {
          display: inline-block;
          flex: 1;
          height: 21px;
          line-height: 21px;
          margin-left: 10px;
          margin-right: 26px;
        }
      }
      .house-type-wrapper {
        .house-wrapper;
        .house-type {
          .house;
        }
      }
      .house-property-wrapper {
        .house-wrapper;
        .house-property {
          .house;
        }
      }
      .house-state-wrapper {
        .house-wrapper;
        .house-state {
          .house;
        }
      }
      .car-wrapper {
        .house-wrapper;
        .car {
          .house;
        }
      }
      .car-license-wrapper {
        .house-wrapper;
        .car-license {
          display: inline-block;
          flex: 1;
          margin: 0 26px 0 10px;
          height: 17px;
          line-height: 17px;
          overflow: hidden;
        }
      }
      .car-price-wrapper {
        .house-wrapper;
        .car-price {
          display: inline-block;
          flex: 1;
          margin: 0 10px;
          height: 17px;
          line-height: 17px;
          overflow: hidden;
        }
        .car-price-unit {
          display: inline-block;
          flex: 0 0 16px;
          height: 21px;
          line-height: 21px;
        }
      }
      .car-age-wrapper {
        .car-license-wrapper;
        .car-age {
          .car-license;
        }
      }
      .car-loan-wrapper {
        .house-wrapper;
        .car-loan {
          .house;
        }
      }
    }
    .submit {
      margin: 20px 0 0;
      height: 30px;
      line-height: 30px;
      background: rgb(246, 92, 2);
      font-size: 15px;
      text-align: center;
      color: #fff;
      letter-spacing: 2px;
    }
    .footer {
      position: absolute;
      bottom: -100px;
      left: auto;
      right: auto;
      width: 100%;
      text-align: center;
      color: black;
    }
  }
</style>
