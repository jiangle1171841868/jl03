package cn.itcast.web;

import cn.itcast.pojo.User;
import cn.itcast.pojo.UserVo;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: spring_day04_04
 * @description:
 * @author: Mr.Jiang
 * @create: 2019-06-18 20:34
 **/
@Controller
//@RequestMapping("hello")//添加了一个一级路径  访问时需要在路径上添加hello  (http://localhost:8080/hello/show1.do)
public class HelloController {

    @RequestMapping("show1")
    public ModelAndView test1() {
        ModelAndView modelAndView = new ModelAndView();
        //设置要显示的视图
        modelAndView.setViewName("hello");
        //添加要显示的数据,数据保存在request域中
        modelAndView.addObject("msg", "这是springmvc的第一个程序！");
        return modelAndView;
    }

    //?:通配任意单个字符
    //*:通配任意对个字符 0或多个
    //**:通配任意多个路径
    //放在前面**/show2  可以通过http://localhost:8080/show2.do访问
    //放在后面show2/**  必须有路径才能访问   http://localhost:8080/show2/.do 最短也要加/
    @RequestMapping("show2/{name}/{id}")
    public ModelAndView test2(@PathVariable("name") String name, @PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        //设置要显示的视图
        modelAndView.setViewName("hello");
        //添加要显示的数据,数据保存在request域中
        modelAndView.addObject("msg", "占位符的映射:" + name + "--" + id);
        return modelAndView;
    }

    //method: 限定请求方式
    @RequestMapping(value = "show6", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView test6() {
        ModelAndView modelAndView = new ModelAndView();
        //设置要显示的视图
        modelAndView.setViewName("hello");
        //添加要显示的数据,数据保存在request域中
        modelAndView.addObject("msg", "限定请求方式的映射:post和get");
        return modelAndView;
    }

    //params:限定请求参数
    @RequestMapping(value = "show7", params = {"userId"})
    public ModelAndView test7() {
        ModelAndView modelAndView = new ModelAndView();
        //设置要显示的视图
        modelAndView.setViewName("hello");
        //添加要显示的数据,数据保存在request域中
        modelAndView.addObject("msg", "限定请求参数:必须有userId");
        return modelAndView;
    }

    //params:限定请求参数
    @RequestMapping(value = "show8", params = {"userId=100"})
    public ModelAndView test8() {
        ModelAndView modelAndView = new ModelAndView();
        //设置要显示的视图
        modelAndView.setViewName("hello");
        //添加要显示的数据,数据保存在request域中
        modelAndView.addObject("msg", "限定请求参数:必须有userId=100");
        return modelAndView;
    }

    //params:限定请求参数
    @RequestMapping(value = "show9", params = {"!userId"})
    public ModelAndView test9() {
        ModelAndView modelAndView = new ModelAndView();
        //设置要显示的视图
        modelAndView.setViewName("hello");
        //添加要显示的数据,数据保存在request域中
        modelAndView.addObject("msg", "限定请求参数:必须没有userId");
        return modelAndView;
    }

    //params:限定请求参数
    @RequestMapping(value = "show10", params = {"userId!=100"})
    public ModelAndView test10() {
        ModelAndView modelAndView = new ModelAndView();
        //设置要显示的视图
        modelAndView.setViewName("hello");
        //添加要显示的数据,数据保存在request域中
        modelAndView.addObject("msg", "限定请求参数:userId不等于100");
        return modelAndView;
    }

    //params:限定请求参数
    @RequestMapping(value = "show11", params = {"name=zhangsan", "userId!=100"})
    public ModelAndView test11() {
        ModelAndView modelAndView = new ModelAndView();
        //设置要显示的视图
        modelAndView.setViewName("hello");
        //添加要显示的数据,数据保存在request域中
        modelAndView.addObject("msg", "限定请求参数:name=zhangsan,userId不等于100");
        return modelAndView;
    }

    @GetMapping("show12")
    public ModelAndView test12() {
        ModelAndView modelAndView = new ModelAndView();
        //设置要显示的视图
        modelAndView.setViewName("hello");
        //添加要显示的数据,数据保存在request域中
        modelAndView.addObject("msg", "限定请求:get");
        return modelAndView;
    }

    @PostMapping("show13")
    public ModelAndView test13() {
        ModelAndView modelAndView = new ModelAndView();
        //设置要显示的视图
        modelAndView.setViewName("hello");
        //添加要显示的数据,数据保存在request域中
        modelAndView.addObject("msg", "限定请求:post");
        return modelAndView;
    }

    @DeleteMapping("show14")
    public ModelAndView test14() {
        ModelAndView modelAndView = new ModelAndView();
        //设置要显示的视图
        modelAndView.setViewName("hello");
        //添加要显示的数据,数据保存在request域中
        modelAndView.addObject("msg", "限定请求:delete");
        return modelAndView;
    }


    @PutMapping("show15")
    public ModelAndView test15() {
        ModelAndView modelAndView = new ModelAndView();
        //设置要显示的视图
        modelAndView.setViewName("hello");
        //添加要显示的数据,数据保存在request域中
        modelAndView.addObject("msg", "限定请求:put");
        return modelAndView;
    }

    //简化代码
    @RequestMapping("show16")
    public String test16(Model model) {
        //相当于 modelAndView.addObject("msg", "简化后的代码");
        model.addAttribute("msg", "简化后的代码");

        //相当于 modelAndView.setViewName("hello");
        return "hello";
    }

    @RequestMapping("show17")
    @ResponseStatus(HttpStatus.OK)
    public void test17() {
        System.out.println("返回值是void....");
    }

    //接收servlet常用的对象 request response session
    @RequestMapping("show18")
    public String test18(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        //使用StringBuilder将request response session连接起来
        //StringBuilder sb = new StringBuilder();
        //sb.append(request).append(response).append(session);
        model.addAttribute("msg", request + "<br/>" + response + "<br/>" + session);
        return "hello";

    }

    @RequestMapping("show19")
    public String test19(Model model, @RequestParam(value = "name", required = false, defaultValue = "lisi") String name) {
        model.addAttribute("msg", "name=" + name);
        return "hello";
    }

    //需求：将cookie中的jsessionid打印到页面
    //传统方式
    @RequestMapping("show20")
    public String test20(Model model, HttpServletRequest request) {
        //获取cookie
        Cookie[] cookies = request.getCookies();
        //第一次访问cookie为null  需要判断一下
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                //equalsIgnoreCase 忽略大小写
                if (cookie.getName().equalsIgnoreCase("jsessionid")) {
                    model.addAttribute("msg", cookie.getValue());
                }
            }
        }
        return "hello";
    }

    //注解获取
    @RequestMapping("show21")
    public String test21(Model model, @CookieValue(value = "JSESSIONID", required = false) String jessionid) {
        model.addAttribute("msg", jessionid);
        return "hello";
    }

    //需求：通过一个页面提交某些数据，由自定义处理器获取这些数据并打印到控制台，但是不需要响应任何页面。
    //获取表单中的数据
    @RequestMapping("show22")
    public String test22(Model model,
                         @RequestParam("name") String name,
                         @RequestParam("age") Integer age,
                         @RequestParam("income") Float income,
                         @RequestParam("interests") String[] interests) {

        model.addAttribute("msg", name + "</br>" + age + "</br>" + income + "</br>" + Arrays.toString(interests));
        return "hello";
    }

    //pojo对象的绑定 将请求数据封装到pojo对象中
    @RequestMapping("show23")
    public String test23(Model model, User user) {
        model.addAttribute("msg", user);
        return "hello";
    }

    //使用集合接收参数
    @RequestMapping("show24")
    public String test24(Model model, @RequestParam("ids") List<String> ids) {
        model.addAttribute("msg", ids);
        return "hello";
    }

    //集合中的元素是pojo类型
    @RequestMapping("show25")
    public String test25(Model model, UserVo uservo) {
        model.addAttribute("msg", uservo);
        return "hello";
    }

    //1.将一个静态页面userList.html转换成jsp
    //2.发送请求,在页面userList.jsp上使用jstl标签显示20个用户信息
    @RequestMapping("show26")
    public String test26(Model model) {
        List<User> users = new ArrayList<>();
        //封装20条数据  20.fori
        for (int i = 0; i < 20; i++) {
            User user = new User();
            user.setId(i + 1L);
            user.setUsername("admin" + i);
            user.setName("liunneg" + i);
            user.setAge(i + 20);
            users.add(user);
        }

        //添加要显示的数据,封装到request域中
        model.addAttribute("users", users);
        //设置需要显示的视图
        return "userList";

    }

    //将List<User>封装成json
    //使用@ResponseBody注解 将方法的返回值  封装成json
    @RequestMapping("show27")
    @ResponseBody //将方法的返回值响应为json
    public List<User> test27(Model model) {
        List<User> users = new ArrayList<>();
        //封装20条数据  20.fori
        for (int i = 0; i < 20; i++) {
            User user = new User();
            user.setId(i + 1L);
            user.setUsername("admin" + i);
            user.setName("liunneg" + i);
            user.setAge(i + 20);
            users.add(user);
        }
        return users;
    }

    //@requestBody将参数中的json数据转化为pojo对象或者String类型
    //使用pojo对象接收json
    @RequestMapping("show28")
    public String test28(Model model, @RequestBody User user) {

        //设置需要响应的数据,封装到request域中
        model.addAttribute("msg", user);
        return "hello";
    }

    //使用String接收json
    @RequestMapping("show29")
    public String test29(Model model, @RequestBody String user) {

        //设置需要响应的数据,封装到request域中
        model.addAttribute("msg", user);
        return "hello";
    }

    //文件上传
    //上传的文件必须使用MultipartFile类型接收
    @RequestMapping("show30")
    public String test30(Model model, @RequestParam("file") MultipartFile file) throws IOException {

        if (file != null) {
            //将文件保存到指定路径
            file.transferTo(new File("D://updown//" + file.getOriginalFilename()));
        }
        model.addAttribute("msg", "上传成功...");
        return "hello";
    }

    //文件上传  上传多个 直接使用数组接收后遍历循环即可。
    //@RequestMapping("show32")
    //上传的文件必须使用MultipartFile类型接收
    @RequestMapping("show31")
    public String test31(Model model, @RequestParam("files") MultipartFile[] files) throws IOException {

        for (MultipartFile file : files) {
            if (file != null) {
                //将文件保存到指定路径
                file.transferTo(new File("D:/updown/" + file.getOriginalFilename()));
            }
        }
        model.addAttribute("msg", "上传成功...");
        return "hello";
    }

    //转发
    @RequestMapping(value = "show32")
    public String test32() {

        //转发路径不带/  是相对路径转发
        //带/ 是绝对路径转发
        //return "forward:/show34.do?id=101&type=forword";
        return "forward:show34.do?id=101&type=forword";
    }

    //重定向
    @RequestMapping(value = "show33")
    public String test33() {

        return "redirect:show34.do?id=101&type=redirect";
    }

    //转发或者重定向的资源
    @RequestMapping(value = "show34")
    public String test34(Model model, @RequestParam("id") Long id, @RequestParam("type") String type) {
        model.addAttribute("msg", "是转发还是重定向？" + id + "..." + type);
        return "hello";
    }

    //自定义处理器拦截器
    @RequestMapping(value = "show35")
    public String test35(Model model) {
        model.addAttribute("msg", "自定义处理器拦截器正在执行......,");
        return "hello";
    }

    @RequestMapping(value = "show36")
    public String test36(Model model, @RequestParam(value = "name",required = false) String name) {
        model.addAttribute("msg", name);
       System.out.println(name);
        return "hello";
    }

}


