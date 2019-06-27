package cn.itcast.web;

import cn.itcast.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: spring_day04_04
 * @description:
 * @author: Mr.Jiang
 * @create: 2019-06-22 18:58
 **/
@Controller
@RequestMapping("hello2")
@RestController//声明所有的方法都使用json格式进行响应
public class HelloController2 {


        /**
         * 此处不使用@ResponseBody
         * @return
         */
        @RequestMapping(value="demo1")
        public List<User> demo1(){
            List<User> list = new ArrayList<User>();
            for(int i = 0;i< 20;i++) {
                User user = new User();
                user.setId(i+1L);
                user.setUsername("zhangsan"+i);
                user.setName("张三"+i);
                user.setAge(18);
                list.add(user);
            }
            return list;
        }

        @RequestMapping(value="demo2")
        public String demo2(Model model) {
            model.addAttribute("msg", "使用@RestController注解");
            return "hello";
        }
    }


