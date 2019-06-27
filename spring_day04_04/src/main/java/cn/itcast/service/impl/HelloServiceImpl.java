package cn.itcast.service.impl;

import cn.itcast.dao.IHelloDao;
import cn.itcast.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @program: spring_day04_04
 * @description:
 * @author: Mr.Jiang
 * @create: 2019-06-18 19:51
 **/
@Service("helloService")
public class HelloServiceImpl implements IHelloService {

    @Autowired
    private IHelloDao helloDao;

    @Override
    public void sayHello() {
        helloDao.sayHello();
    }
}
