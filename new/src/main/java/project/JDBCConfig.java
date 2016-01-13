package project;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@PropertySource(value = "classpath:jdbc.properties", name = "db")
public class JDBCConfig {

    @Autowired
    private Environment env;

//	 <util:properties id="settings" location="WEB-INF/classes/META-INF/spring/test.properties" />  
//	 @Value("#{db['jdbc.driver']}")

    @Value("${jdbc.driver}")
    String driverClass;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.initialPoolSize}")
    private Integer initialPoolSize;
    @Value("${jdbc.maxPoolSize}")
    private Integer maxPoolSize;
    @Value("#{new Integer('${jdbc.minPoolSize}')}")
    private Integer minPoolSize;

    @Bean(name = "dataSource")
    public DataSource initDataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //annotation
        try {
            dataSource.setDriverClass(driverClass);
        } catch (PropertyVetoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        dataSource.setInitialPoolSize(initialPoolSize);
        dataSource.setMaxPoolSize(maxPoolSize);
        dataSource.setMinPoolSize(minPoolSize);
        return dataSource;
    }
//   @Bean
//   public DataSource initDataSource(){
//       BasicDataSource dataSource = new BasicDataSource();
//       //hard coding
////       dataSource.setDriverClassName("com.mysql.jdbc.Driver");
////       dataSource.setUrl("jdbc:mysql://127.0.0.1/framework");
////       dataSource.setUsername("root");
////       dataSource.setPassword("");
//       
//       //annotation
//       dataSource.setDriverClassName(driverClass);
//       dataSource.setUrl(url);
//       dataSource.setUsername(username);
//       dataSource.setPassword(password);
//       
//       //environment
////       dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driver"));
////       dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
////       dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
////       dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
//       return dataSource;
//   }

    @Bean
    public JdbcTemplate initJdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(initDataSource());
        return jdbcTemplate;
    }

    @Bean
    public NamedParameterJdbcTemplate initNamedParameterJdbcTemplate() {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(initDataSource());
        return namedParameterJdbcTemplate;
    }

    @Bean
    public PlatformTransactionManager txManager() {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(initDataSource());
        return dataSourceTransactionManager;
    }
}
