package project;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.charwer.cs.framework.shiro.IShiroLogin;
import org.charwer.cs.framework.shiro.ShiroLoginAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.shiro.filter.HierarchyRolesAutorizationFilter;
import project.shiro.realm.HierarchyRolesJdbcRealm;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


@Configuration
public class ShiroConfig {

    Log log = LogFactory.getLog(this.getClass());

    @Autowired
    private DataSource ds;

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean initShiroFilter() {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(getSecurityManager());
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/success");
        shiroFilterFactoryBean.setUnauthorizedUrl("/login");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(initOriginalFilterChainMap());

//		Map<String, Filter> filterMap = new HashMap<String, Filter>();
//		filterMap.put("hroles", hierarchyRolesFilter());
//		shiroFilterFactoryBean.setFilters(filterMap);

        return shiroFilterFactoryBean;
    }

    public Map<String, String> initOriginalFilterChainMap() {
        Map<String, String> filterChainMap = new HashMap<String, String>();
        filterChainMap.put("/test/**", "authc");
        filterChainMap.put("/role/**", "roles[admin]");
        filterChainMap.put("/user/**", "perms[user:edit]");
//		filterMap.put("/user/**", "perms[\"user:add,user:del\"]");
        filterChainMap.put("/**", "anon");
        return filterChainMap;
    }

    public Map<String, String> initHierarchyFilterChainMap() {
        Map<String, String> filterChainMap = new HashMap<String, String>();
        filterChainMap.put("/test/**", "authc");
        filterChainMap.put("/role/**", "hroles[admin2]");
        filterChainMap.put("/user/**", "perms[user:edit]");
        filterChainMap.put("/**", "anon");
        return filterChainMap;
    }

    //	@Bean
    public Filter hierarchyRolesFilter() {
        return new HierarchyRolesAutorizationFilter();
    }

    public DefaultWebSecurityManager getSecurityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(getJdbcRealm());
//		securityManager.setRealm(getHierarchyRolesJdbcRealm());
        return securityManager;
    }

    public Realm getJdbcRealm() {
        JdbcRealm jdbcRealm = new JdbcRealm();
        jdbcRealm.setDataSource(ds);
        jdbcRealm.setPermissionsLookupEnabled(true);
        jdbcRealm.setAuthenticationCachingEnabled(false);
        return jdbcRealm;
    }

    public Realm getHierarchyRolesJdbcRealm() {
        JdbcRealm jdbcRealm = new HierarchyRolesJdbcRealm();
        jdbcRealm.setDataSource(ds);
        jdbcRealm.setPermissionsLookupEnabled(true);
        jdbcRealm.setAuthorizationCachingEnabled(false);
        return jdbcRealm;
    }

    @Bean
    public IShiroLogin initShiroLogin() {
        return new ShiroLoginAdapter();
    }

}
