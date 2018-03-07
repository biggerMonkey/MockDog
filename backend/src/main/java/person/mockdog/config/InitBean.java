package person.mockdog.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import person.mockdog.filter.RequestFilter;

@Configuration
public class InitBean {
    @Bean
    public FilterRegistrationBean reqFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new RequestFilter());// 添加过滤器
        registration.addUrlPatterns("/*");// 设置过滤路径，/*所有路径
        registration.setName("MockReqFilter");// 设置优先级
        registration.setOrder(1);// 设置优先级
        return registration;
    }
}
