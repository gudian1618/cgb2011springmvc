package com.github.gudian1618.cgb2011springmvc.controller;

import com.github.gudian1618.cgb2011springmvc.pojo.User;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

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

    /**
     * 3.日期类型参数绑定
     * 通过springmvc获取请求中参数的值,/testParam3?date=2028-8-8%8:8:8&like=篮球&like=足球
     * 方法一:将浏览器提交日期修改为能够识别的/分割年月日
     * 方法二:将springmvc的底层修改为
     */
    @RequestMapping("/testParam3")
    public String testParam3(Date date, String[] like) {
        System.out.println(date);
        System.out.println("like="+ Arrays.toString(like));
        return "home";
    }

    /**
     * 4.测试springmvc的请求转发
     * (1).从controller方法转发到一个页面
     * (2).从controller方法转发到另一个方法中
     */
    @RequestMapping("/testForward")
    public String testForward() {
        System.out.println("HelloController.testForward()...");
        // 跳转到转发方法
        return "forward:/test";
    }

    @RequestMapping("/test")
    public String test() {
        System.out.println("HelloController.test()...");
        return "home";
    }

    /**
     * 5.测试springmvc实现请求重定向
     * (1).从controller中的一个方法重定向到另外一个方法 return "redirect:/方法上的请求路径"
     * (2).从controller中的一个方法重定向到本软件之外的页面链接
     */
    @RequestMapping("/testRedirect")
    public String testRedirect() {
        System.out.println("HelloController.testRedirect()...");
        // return "redirect:/test";
        return "redirect:https://www.baidu.com";
    }

    /* 自定义日期格式转换器: 将springmvc框架底层默认的以斜杠分隔日期, 改为以横杠分隔! */
    @InitBinder
    public void InitBinder (ServletRequestDataBinder binder){
        binder.registerCustomEditor(java.util.Date.class,
            new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true)
        );
    }

}
