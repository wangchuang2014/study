package com.rush;

import com.rush.bean.AdvanceValueInject;
import com.rush.bean.Person;
import com.rush.config.MainConfigOfPropertyValues;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class IOCTest_PropertyValue {

    @Test
    public void test02() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:beans.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
    }


    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);

        printBeans(applicationContext);

        System.out.println("===================");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
        System.out.println("-------------------");
        AdvanceValueInject advanceValueInject = (AdvanceValueInject) applicationContext.getBean("advanceValueInject");
        System.out.println(advanceValueInject);
        System.out.println("++++++++++++++++++++");
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("person.nickName");
        System.out.println(property);

        // 关闭容器
        applicationContext.close();
    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext) {
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
    }

}
