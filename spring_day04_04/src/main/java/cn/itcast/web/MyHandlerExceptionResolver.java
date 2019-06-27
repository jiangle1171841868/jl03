package cn.itcast.web;

import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: spring_day04_04
 * @description: 自定义处理器异常解析器
 * @author: Mr.Jiang
 * @create: 2019-06-22 16:26
 **/
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView();
        //判断是什么异常
        //instanceof  用于判断前面的对象是否是后面的类，或者其子类、实现类的实例
        if (ex instanceof MaxUploadSizeExceededException) {
            //添加异常信息
            mv.addObject("msg", "上传文件大小不得超过1kb");
            mv.setViewName("hello");
        }
        return mv;
    }
}
