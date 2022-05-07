package com.rush;

import com.rush.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_LifeCycle {

    @Test
    public void test02() {
        // 1. 创建IOC容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成");
        System.out.println("--------");

        // 调用时创建对象
        Object bean = applicationContext.getBean("cat");
        System.out.println("--------");

        // 调用时创建对象
        Object bean1 = applicationContext.getBean("cat");
        System.out.println("--------");

        // 关闭容器
        applicationContext.close();
    }


    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成");

        applicationContext.close();
    }
}
