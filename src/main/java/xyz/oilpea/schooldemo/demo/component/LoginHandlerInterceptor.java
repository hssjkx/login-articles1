package xyz.oilpea.schooldemo.demo.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器，登陆检查，
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    //preHandle目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");//拿到session，在session中来获取loginUser属性
        if (user == null) {//判断user是不是空的
            //未登陆，返回登陆页面
            request.setAttribute("msg", "没有权限请先登陆");//错误消息
            request.getRequestDispatcher("/index.html").forward(request, response);
            //获取到转发器，视图映射，当我们访问当前项目或者当前项目index都会让它回到登录页面，让它转发到index这个请求
            //请求和响应转出去
            return false;
        } else {
            //已登陆，放行请求
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

//拦截器写完后，一定要配置出来，springMvc才能用的到
