package com.linktech.demo.service;

import com.linktech.demo.model.User;
import org.springframework.stereotype.Service;


/**
 * Created by 飞 on 2015/12/16.
 */
@Service
public class UserService {
    public User getUserInfo(String id) {
        User user = new User();
        user.setName("大飞");
        user.setAge(28);
        user.setEmail("xufei0718@163.com");
        return user;

    }
    public void updateUserInfo(String id){
        String sr = new String();
        sr.toString();
    }
}
