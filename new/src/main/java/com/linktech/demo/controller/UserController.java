package com.linktech.demo.controller;

import com.linktech.demo.model.User;
import com.linktech.demo.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 例子测试类
 * Created by 飞 on 2015/12/16.
 */
@RestController
@Scope("prototype")
@RequestMapping("/user")
public class UserController {
    private Logger log = Logger.getLogger(UserController.class);

    @Autowired
    protected UserService userService;

    /**
     * 获取用户信息
     */

    @RequestMapping("/getUserInfo")
    public User getUserInfo(HttpServletRequest req) {
        log.info("开始执行...");
        String id = req.getParameter("id");
        
        return userService.getUserInfo(id);
    }


}
