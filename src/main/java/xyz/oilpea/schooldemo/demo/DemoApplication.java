package xyz.oilpea.schooldemo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.Locale;

@SpringBootApplication
@MapperScan("xyz.oilpea.schooldemo.demo.dao")
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public ViewResolver myViewReolver() {
        return new MyViewResolver();
    }

    public static class MyViewResolver implements ViewResolver {

        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            return null;
        }
    }
}
