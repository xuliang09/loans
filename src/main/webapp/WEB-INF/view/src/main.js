// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
/* eslint-disable no-unused-vars */
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
require('!style-loader!css-loader!less-loader!@/common/css/index.less')
require('!style-loader!css-loader!less-loader!@/common/css/icon.less')

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App }
})
