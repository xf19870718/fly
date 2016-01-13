package project;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.util.Log4jConfigListener;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.EnumSet;

/**
 * Created by Concord on 2014/5/10 010.
 */
//A 100% code-based approach to configuration
public class ProjectWebApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext container) throws ServletException {
        System.out.println("onStartup!!!!");
        container.setInitParameter("webAppRootKey", "framework.root");
        container.setInitParameter("log4jConfigLocation", "classpath:log4j.properties");
        container.addListener(Log4jConfigListener.class);
        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext =
                new AnnotationConfigWebApplicationContext();
        rootContext.register(AppConfig.class);

        // Manage the lifecycle of the root application context
        container.addListener(new ContextLoaderListener(rootContext));

        //create the shiro filter
        Dynamic shiroFilter = container.addFilter("DelegatingFilterProxy", DelegatingFilterProxy.class);
        shiroFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
        shiroFilter.setInitParameter("targetBeanName", "shiroFilter");
        shiroFilter.setInitParameter("targetFilterLifecycle", "true");

        // create the characterEncodingFilter
        Dynamic characterEncodingFilter = container.addFilter(
                "Set Character Encoding", CharacterEncodingFilter.class);
        characterEncodingFilter.addMappingForUrlPatterns(
                EnumSet.of(DispatcherType.REQUEST), true, "/*");
        characterEncodingFilter.setInitParameter("encoding", "UTF-8");
        characterEncodingFilter.setInitParameter("forceEncoding", "true");

        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherContext =
                new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(WebConfig.class);

        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
//        dispatcher.addMapping("/*");
    }
}
