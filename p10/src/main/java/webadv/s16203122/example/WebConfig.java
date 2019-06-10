package webadv.s16203122.example;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import webadv.s16203122.example.aop.AuthInterceptor;

@Configuration          
public class WebConfig implements WebMvcConfigurer   {
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(new AuthInterceptor());     
        registration.addPathPatterns("/**");         //所有路径都被拦截
        registration.excludePathPatterns("/","/login","/css/**","/js/**","/vendors/**","/images/**");       //添加不拦截路径

    }

}
