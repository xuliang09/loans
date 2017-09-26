<template>
  <div class="app">
    <div class="content-wrapper" v-show="!infoFormShow">
      <div class="title">
        <div class="title-one">放款快至2小时</div>
        <div class="title-two">最低一万起放</div>
      </div>
      <div class="content">
        <div class="tips">21-60周岁均可申请</div>
        <div class="form">
          <div class="name-wrapper">
            <span class="name-icon icon-user"></span>
            <input class="name" placeholder="请输入您的姓名" v-model="user.name"/>
          </div>
          <div class="tel-wrapper">
            <span class="tel-icon icon-mobile"></span>
            <input class="tel" type="tel" placeholder="请输入您的手机号码" v-model="user.phoneNumber"/>
          </div>
          <div class="apply" @click="showInfoForm">立即申请</div>
        </div>
      </div>
    </div>
    <div class="footer-wrapper" v-show="!infoFormShow">
      <div class="title">贷款产品</div>
      <div class="prod-wrapper">
        <span class="prod-one">
          <div class="image"></div>
          <div class="desc">有房就能贷</div>
        </span>
        <span class="prod-two">
          <div class="image"></div>
          <div class="desc">有车险就能贷</div>
        </span>
        <span class="prod-three">
          <div class="image"></div>
          <div class="desc">信用贷</div>
        </span>
        <span class="prod-four">
          <div class="image"></div>
          <div class="desc">零用贷</div>
        </span>
      </div>
    </div>
    <userInfo v-if="infoFormShow" :user="this.user"></userInfo>
    <div class="footer" v-show="!infoFormShow">网站备案号：苏ICP备17057254号-1 </div>
  </div>

</template>

<script>
import userInfo from '@/components/userInfo'

export default {
  data () {
    return {
      user: {
        name: '',
        phoneNumber: '',
        demandMoney: '',
        loanPeriod: '',
        address: '',
        work: '',
        credit: '',
        hasHouse: '',
        houseType: '',
        houseProperty: '',
        houseState: '',
        hasCar: '',
        carLicenseBelong: '',
        carPrice: '',
        carAge: '',
        hasLoanOnCar: '',
        monthlySalary: '',
        provideIncomeProof: '',
        workTimeInCurrentCompany: '',
        workplace: '',
        publicFundOfSocialSecurity: '',
        continuedPayTimeOfSocialSecurityPublicFund: '',
        legalRepresentative: '',
        companyOpearteState: '',
        businessLicenseAge: '',
        publicAccountMonthly: '',
        privateAccountMonthly: ''
      },
      infoFormShow: false
    }
  },
  methods: {
    showInfoForm () {
      if (this.user.name && this.user.phoneNumber) {
        if (this.user.phoneNumber.length === 11) {
          this.infoFormShow = true
        } else {
          alert('请输入正确的手机号码')
        }
      } else {
        alert('请输入完整的信息')
      }
    }
  },
  components: {
    userInfo
  }
}
</script>

<style lang="less" scoped>
  .app {
    position: relative;
  }
  .content-wrapper {
    width: 100%;
    height: 400px;
    margin: 0;
    // background: url('./assets/bg_img.jpg');
    // background-size: 100%;
    // background-repeat: no-repeat;
    text-align: center;
    &:before {
      display: block;
      position: fixed;
      top: 0;
      left: 0;
      content: '';
      width: 100%;
      height: 100%;
      background: url('./assets/bg_img.jpg');
      background-size: cover;
      background-repeat: no-repeat;
      z-index: -1;
      opacity: 0.5;
    }
    .title {
      font-size: 0;
      .title-one {
        padding: 30px 0 20px;
        height: 30px;
        line-height: 30px;
        font-size: 30px;
        font-weight: 700;
        color: rgb(217, 131, 79);
      }
      .title-two {
        padding: 0 0 30px;
        height: 25px;
        line-height: 25px;
        font-size: 25px;
        color: rgb(217, 131, 79);
      }
    }
    .content {
      width: 80%;
      margin: 0 auto;
      box-sizing: border-box;
      border: 1px solid rgb(127, 71, 48);
      font-size: 0;
      text-align: center;
      .tips {
        height: 50px;
        line-height: 50px;
        background: rgb(127, 71, 48);
        font-size: 20px;
        color: #fff;
      }
      .form {
        width: 100%;
        padding: 20px 15px 40px;
        box-sizing: border-box;
        .name-wrapper {
          display: flex;
          // height: 29px;
          padding: 0 0 20px;
          .name-icon {
            display: inline-block;
            flex: 0 0 29px;
            margin-right: 5px; 
            width: 29px;
            height: 29px;
            line-height: 29px;
            vertical-align: top;
            font-size: 20px;
            color: #fff;
            background: rgb(246, 92, 2);
          }
          .name {
            display: inline-block;
            flex: 1;
            height: 25px;
            line-height: 25px;
            vertical-align: top;
            border: 2px solid rgb(127, 71, 48);
          }
        }
        .tel-wrapper {
          display: flex;
          height: 29px;
          .tel-icon {
            display: inline-block;
            flex: 0 0 29px;
            margin-right: 5px; 
            width: 29px;
            height: 29px;
            line-height: 29px;
            vertical-align: top;
            font-size: 20px;
            color: #fff;
            background: rgb(246, 92, 2);
          }
          .tel {
            display: inline-block;
            flex: 1;
            height: 25px;
            line-height: 25px;
            border: 2px solid rgb(127, 71, 48);
          }
        }
        .apply {
          margin: 20px 0 0;
          height: 30px;
          line-height: 30px;
          background: rgb(246, 92, 2);
          font-size: 15px;
          color: #fff;
        }
      }
    }
  }
  .footer-wrapper {
    width: 80%;
    margin: 0 auto;
    font-size: 0;
    text-align: center;
    .title {
      font-size: 20px;
      color: #666;
    }
    .prod-wrapper {
      width: 100%;
      padding: 20px 0 0;
      box-sizing: border-box;
      .prod-one {
        display: inline-block;
        margin: 0;
        padding: 0 15px 15px 0;
        width: 50%;
        box-sizing: border-box;
        .image {
          width: 100%;
          height: 140px;
          background: url('./assets/house.jpg');
          background-size: contain;
          background-repeat: no-repeat;
        }
        .desc {
          width: 100%;
          height: 15px;
          line-height: 15px;
          text-align: center;
          font-size: 15px;
        }
      }
      .prod-two {
        display: inline-block;
        margin: 0;
        padding: 0 0 15px 15px;
        width: 50%;
        box-sizing: border-box;
        .image {
          //width: 100%;
          height: 140px;
          background: url('./assets/car.jpg');
          background-size: contain;
          background-repeat: no-repeat;
        }
        .desc {
          width: 100%;
          height: 15px;
          line-height: 15px;
          text-align: center;
          font-size: 15px;
        }
      }
      .prod-three {
        display: inline-block;
        margin: 0;
        padding: 0 15px 15px 0;
        width: 50%;
        box-sizing: border-box;
        .image {
          width: 100%;
          height: 140px;
          background: url('./assets/credit.jpg');
          background-size: contain;
          background-repeat: no-repeat;
        }
        .desc {
          width: 100%;
          height: 15px;
          line-height: 15px;
          text-align: center;
          font-size: 15px;
        }
      }
      .prod-four {
        display: inline-block;
        margin: 0;
        padding: 0 0 15px 15px;
        width: 50%;
        box-sizing: border-box;
        .image {
          //width: 100%;
          height: 140px;
          background: url('./assets/small.jpg');
          background-size: contain;
          background-repeat: no-repeat;
        }
        .desc {
          width: 100%;
          height: 15px;
          line-height: 15px;
          text-align: center;
          font-size: 15px;
        }
      }
    }
  }
  .footer {
    position: absolute;
    bottom: -10px;
    left: auto;
    right: auto;
    width: 100%;
    text-align: center;
    color: black;
  }
</style>
