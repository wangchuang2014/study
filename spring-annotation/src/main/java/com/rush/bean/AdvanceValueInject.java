package com.rush.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@PropertySource("classpath:advance_value_inject.properties")
@Component
public class AdvanceValueInject {
    @Value("${author.name:meimeixia}")
    private String name;

    // SpEL：调用字符串Hello World的concat方法
    @Value("#{'Hello World'.concat('!')}")
    private String helloWorld;

    // SpEL：调用字符串的getBytes方法，然后再调用其length属性
    @Value("#{'Hello World'.bytes.length}")
    private String helloWorldBytes;

    // SpEL：传入一个字符串，根据","切分后插入列表中， #{}和${}配合使用时，注意不能反过来${}在外面，而#{}在里面
    @Value("#{'${server.name}'.split(',')}")
    private List<String> severs;

    // SpEL：注意不能反过来，${}在外面，而#{}在里面，因为这样会执行失败
    @Value("${#{'HelloWorld'.concat('_')}}")
    private List<String> severs2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHelloWorld() {
        return helloWorld;
    }

    public void setHelloWorld(String helloWorld) {
        this.helloWorld = helloWorld;
    }

    public String getHelloWorldBytes() {
        return helloWorldBytes;
    }

    public void setHelloWorldBytes(String helloWorldBytes) {
        this.helloWorldBytes = helloWorldBytes;
    }

    public List<String> getSevers() {
        return severs;
    }

    public void setSevers(List<String> severs) {
        this.severs = severs;
    }

    public List<String> getSevers2() {
        return severs2;
    }

    public void setSevers2(List<String> severs2) {
        this.severs2 = severs2;
    }

    @Override
    public String toString() {
        return "AdvanceValueInject{" +
                "name='" + name + '\'' +
                ", helloWorld='" + helloWorld + '\'' +
                ", helloWorldBytes='" + helloWorldBytes + '\'' +
                ", severs=" + severs +
                ", severs2=" + severs2 +
                '}';
    }
}
