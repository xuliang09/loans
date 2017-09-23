# loans
本项目是一个前端由nodejs和vue开发、后端由java开发的web项目，项目中所用到的包由maven插件统一管理，项目中使用的云短信服务是购买的阿里的SMS。

### 前端
前端的所有文件放在 src\main\webapp\WEB-INF 目录下，使用时需先安装nodejs
```
#命令行进入loans\src\main\webapp\WEB-INF\view目录（使用cd命令）
npm run install #自动安装所有用到的package
npm run dev #在浏览器中查看效果，这一步可以省略
npm run build #生成loans\src\main\webapp\WEB-INF\view\build文件夹
```

nodejs版本为v8.4.0


### 后端
采用java语言和eclipse工具开发，eclipse版本信息如下
>Eclipse Java EE IDE for Web Developers.
>Version: Neon.3 Release (4.6.3)
>Build id: 20170314-1500

http服务器采用tomcat8.0


### UI
ui主要由两个页面构成，用户填写完所有的信息之后点击确认提交即可
1. 页面1，用户输入自己的姓名、手机号等基本信息
![image](https://github.com/PowerfulSpider/loans/blob/master/doc/页面1.jpg)
2. 页面2，用户输入更详细的信息
![image](https://github.com/PowerfulSpider/loans/blob/master/doc/页面2.jpg)
3. 输入完所有的信息之后用户点击确认提交，会有弹框提示表明当前操作是否成功