package sample.login.bso;

import org.charwer.cs.framework.shiro.IShiroLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginBSO {

    @Autowired
    protected IShiroLogin shiroLogin;

    public void shiroLogin(String username, String password) {
        shiroLogin.login(username, password);
    }
}
