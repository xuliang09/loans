<template>
  <div class="app">
    <div class="content-wrapper">
      <div class="title">
        <div class="title-one">放款快至2小时</div>
        <div class="title-two">最低一万起放</div>
      </div>
      <div class="content">
        <div class="tips">21-60周岁均可申请</div>
        <div class="form">
          <div class="name-wrapper">
            <span class="name-icon"></span>
            <input class="name" placeholder="请输入您的姓名"/>
          </div>
          <div class="tel-wrapper">
            <span class="tel-icon"></span>
            <input class="tel" placeholder="请输入您的手机号码"/>
          </div>
          <div class="apply">立即申请</div>
        </div>
      </div>
    </div>
    <div class="footer-wrapper"></div>
  </div>
  
</template>

<script>
export default {
  data () {
    return {
      user: {
        name: '',
        tel: 13000000000
      }

    }
  }
}
</script>

<style lang="less">
  .app .content-wrapper {
    width: 100%;
    height: 400px;
    margin: 0;
    // background: url('./assets/bg_img.jpg');
    // background-size: 100%;
    // background-repeat: no-repeat;
    text-align: center;
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
          height: 29px;
          padding: 0 0 20px;
          .name {
            display: inline-block;
            height: 25px;
            line-height: 25px;
            border: 2px solid rgb(127, 71, 48);
          }
        }
        .tel-wrapper {
          height: 29px;
          .tel {
            display: inline-block;
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
        }
      }
    }
  }
</style>
