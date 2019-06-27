package cn.itcast.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: spring_day04_04
 * @description:
 * @author: Mr.Jiang
 * @create: 2019-06-22 17:05
 **/
public class MyInterceptor1 implements HandlerInterceptor {

    //ctlr+I重写方法
    //在Handler(处理器)方法执行之前执行
    //返回值  返回true 拦截放行  返回false 业务中断  后续业务逻辑不在执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor1...预处理回调方法正在执行......");
        return true;
    }

    //在Handler方法执行之后执行  倒叙执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor1...后处理回调方法正在执行......");
    }

    //在视图渲染之后执行 倒叙执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor1...请求完成回调方法正在执行......");
    }
}
