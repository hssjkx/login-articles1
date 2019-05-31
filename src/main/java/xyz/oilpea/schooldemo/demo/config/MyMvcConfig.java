package xyz.oilpea.schooldemo.demo.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

import org.springframework.web.servlet.config.annotation.*;
import xyz.oilpea.schooldemo.demo.component.LoginHandlerInterceptor;
import xyz.oilpea.schooldemo.demo.component.MyLocaleResolver;

//使用WebMvcConfigurerAdapter可以来扩展SpringMVC的功能
//@EnableWebMvc   不要接管SpringMVC
@Configuration
public class MyMvcConfig implements  WebMvcConfigurer {


//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        // super.addViewControllers(registry);
//        //浏览器发送 /atguigu 请求来到 success
//        registry.addViewController("/huashang").setViewName("success");
//    }

    //所有的WebMvcConfigurerAdapter组件都会一起起作用
    //将组件注册在容器
    @Bean
    public  WebMvcConfigurer webMvcConfigurerAdapter() {
        WebMvcConfigurer adapter = new  WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
                //路径来到main.html后台的主页，setViewName设置一个视图名（去掉前后缀）
                registry.addViewController("/articles.html").setViewName("articles");
                registry.addViewController("/editpage.html").setViewName("editpage");
                registry.addViewController("/logs.html").setViewName("logs");
                registry.addViewController("/emps.html").setViewName("emps");
                registry.addViewController("/swiper.html").setViewName("swiper");

            }

            //addInterceptors就是用来注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //super.addInterceptors(registry);
                //静态资源；  *.css , *.js
                //不用处理静态资源，SpringBoot已经做好了静态资源映射
              registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")//拦截任意多层路径下的任意请求
                 .excludePathPatterns("/index.html", "/", "/user/login");//排除第一个请求
            }
        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver() {

        return new MyLocaleResolver();
    }

}
