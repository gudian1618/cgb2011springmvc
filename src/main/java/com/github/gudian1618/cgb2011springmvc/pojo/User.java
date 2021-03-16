package com.github.gudian1618.cgb2011springmvc.pojo;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/3/15 9:02 下午
 * 用于封装用户信息
 */

public class User implements Serializable {

    private static final long serialVersionUID = 7049291176517327033L;
    private String name;
    private Integer age;
    private String addr;

    public User() {
    }

    public User(String name, Integer age, String addr) {
        this.name = name;
        this.age = age;
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "User{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", addr='" + addr + '\'' +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(age, user.age) && Objects.equals(addr, user.addr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, addr);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
