package project;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * Created by Concord on 2014/5/12 012.
 */
@Configuration
@ComponentScan(basePackages = {"sample.**.bso", "sample.**.dao", "com.linktech.**.service", "com.linktech.**.controller", "com.linktech.**.dao", "com.linktech.mybatis.template"}, useDefaultFilters = false, includeFilters = {
        @ComponentScan.Filter(org.springframework.stereotype.Service.class),
        @ComponentScan.Filter(org.springframework.stereotype.Repository.class)
})
@EnableTransactionManagement
//@Import(JDBCConfig.class)
@Import({JDBCConfig.class, ShiroConfig.class})
@ImportResource("classpath:spring/spring-mybatis.xml")
public class AppConfig {

    Log logger = LogFactory.getLog(this.getClass());

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
