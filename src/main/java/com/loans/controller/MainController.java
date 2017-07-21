package com.loans.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户界面交互类
 * 〈一句话功能简述〉
 *
 * <p>〈功能详细描述〉
 * @author xul 2017年7月16日
 * @see [相关类/方法]
 * @since 1.0
 */
@Controller
public class MainController
{
    // 判断连通
    @RequestMapping(value = "/isalive", method = RequestMethod.GET)
    public @ResponseBody String isAlive()
    {
        return "index";
    }
}
