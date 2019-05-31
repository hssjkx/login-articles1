package xyz.oilpea.schooldemo.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

//    @DeleteMapping
//    @PutMapping
//    @GetMapping

    //@RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @PostMapping(value = "/user/login")//处理的请求地址
    public String login(@RequestParam("username") String username,//@RequestParam明确的告诉它，从请求参数里获取username
                        @RequestParam("password") String password,//用@RequestParam标注的属性，一旦没提交就会给我们报错
                        Map<String, Object> map, HttpSession session)//错误消息封装Map里面，
    {//从请求参数上获取username和password
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {//用户名不为空 且 密码为123456则登录成功
//        if ("admin".equals(username) && "123456".equals(password)) {
            //登陆成功，防止表单重复提交，可以重定向到主页
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";//登陆成功来到主页
            //springMvc以前加一个redirect前缀，'/'代表重定向到当前项目下
            // 成功后来到main页面，而main添加了视图映射，是最终要到dashboard的
            //重定向http://localhost:8081/crud/main.html
        } else {
            //登陆失败

            map.put("msg", "用户名密码错误");//放错误消息msg
            return "login";//回到登录页面
        }

    }
}

