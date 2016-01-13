package sample.login.alo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sample.login.bso.LoginBSO;

@Controller
public class LoginALO {

    Log log = LogFactory.getLog(this.getClass());

    @Autowired
    public LoginBSO shiroLoginBSO;

    @RequestMapping("/login")
    public String shiroLogin() {
        log.info("shiro login!!!!.........");
        return "login/login";
    }

    @RequestMapping("/logon")
    public String shiroLogin(String username, String password) {
        log.info("代码测试");
        log.info("username:" + username);
        log.info("password:" + password);
        shiroLoginBSO.shiroLogin(username, password);
        log.info("shiro logon!!!!.........");
        return "index";
//		return "login/success";
    }


}
