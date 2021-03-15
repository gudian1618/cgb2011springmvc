package com.github.gudian1618.cgb2011springmvc.controller;

import com.github.gudian1618.cgb2011springmvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/3/15 7:31 下午
 * Controller注解作用:
 * 1.表示当前类属于Controller类
 * 2.表示当前类对象有spring容器负责创建管理
 */

@Controller
public class HelloController {

    /**
     * RequestMapping注解表示映射路径,浏览器url该地址时就会执行此方法
     *
     * @return
     */
    @RequestMapping("/hello")
    public String testHello() {
        System.out.println("hello springmvc~~~");
        return "home";
    }

    /**
     * 1.简单类型参数绑定
     * 通过springmvc获取请求中参数的值,/testParam1?name=张飞&age=20&addr=北京
     * 1.方法上形参的类型要和请求参数类型保持一致
     * 2.方法上形参的名字要和接收参数的名字保持一致
     */
    @RequestMapping("/testParam1")
    public String testParam1(String name, Integer age, String addr) {
        System.out.println("name=" + name);
        System.out.println("age=" + age);
        System.out.println("addr=" + addr);
        return "home";
    }

    /**
     * 2.包装类型参数绑定
     * 通过springmvc获取请求中参数的值,/testParam2?name=赵云&age=30&addr=上海
     * 如果请求参数较多,或者参数需要封装到POJO对象中
     * 注意:
     * 在包装类型中的属性名和请求参数的名字保持一致,底层通过pojo对象的get和set方法调用实现
     */
    @RequestMapping("/testParam2")
    public String testParam2(User user) {
        System.out.println("user.name=" + user.getName());
        System.out.println("user.age=" + user.getAge());
        System.out.println("user.addr=" + user.getAddr());
        return "home";
    }


}
