package cn.itcast.dao.impl;

import cn.itcast.dao.IHelloDao;
import org.springframework.stereotype.Repository;

/**
 * @program: spring_day04_04
 * @description:
 * @author: Mr.Jiang
 * @create: 2019-06-18 19:50
 **/
@Repository("helloDao")
public class HelloIDaompl implements IHelloDao {
    @Override
    public void sayHello() {
        System.out.println("hello  world");
    }
}
