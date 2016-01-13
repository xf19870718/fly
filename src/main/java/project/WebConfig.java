package project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Concord on 2014/5/10 010.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"project.common", "sample.**.alo", "sample.**.dto", "com.linktech.**.controller", "com.linktech.**.dto", "com.linktech.jsonp"})
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/**");
        registry.addResourceHandler("/**").addResourceLocations("/WEB-INF/page/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new JSONPInterceptor());
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public ContentNegotiatingViewResolver initViewResolver() {
//    	Map<String, String> mediaTypes = new HashMap<String, String>();
//    	mediaTypes.put("html", "text/html");
//    	mediaTypes.put("json", "application/json");

        List<ViewResolver> viewResolvers = new ArrayList<ViewResolver>();
        viewResolvers.add(new BeanNameViewResolver());
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/module/");
        internalResourceViewResolver.setSuffix(".jsp");
        internalResourceViewResolver.setContentType("text/html");
        internalResourceViewResolver.setViewClass(JstlView.class);
        viewResolvers.add(internalResourceViewResolver);

//    	List<View> defaultViews = new ArrayList<View>();
//    	MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
//    	Set<String> set = new HashSet<String>();
//    	set.add("jsonp");
//    	set.add("callback");
//    	set.add("jsonpcallback");
//    	jsonView.setJsonpParameterNames(set);
//    	defaultViews.add(jsonView);

//    	defaultViews.add(new CharwerMappingJaksonJsonView());

        ContentNegotiatingViewResolver contentNegotiatingViewResolver = new ContentNegotiatingViewResolver();
//    	contentNegotiatingViewResolver.setMediaTypes(mediaTypes);


//    	contentNegotiatingViewResolver.setContentNegotiationManager();
        contentNegotiatingViewResolver.setViewResolvers(viewResolvers);
//    	contentNegotiatingViewResolver.setDefaultViews(defaultViews);

        return contentNegotiatingViewResolver;
    }

    @Bean
    public RequestMappingHandlerAdapter initRequestMappingHandlerAdapter() {
        RequestMappingHandlerAdapter requestMappingHandlerAdapter = new RequestMappingHandlerAdapter();

        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();

        List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
        supportedMediaTypes.add(MediaType.TEXT_HTML);
        supportedMediaTypes.add(MediaType.APPLICATION_JSON);

        stringHttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        messageConverters.add(stringHttpMessageConverter);

        requestMappingHandlerAdapter.setMessageConverters(messageConverters);

        return requestMappingHandlerAdapter;
    }

}
