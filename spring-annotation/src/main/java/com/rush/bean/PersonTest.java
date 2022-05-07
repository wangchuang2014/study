package com.rush.bean;

import com.rush.config.PersonConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonTest {
    public static void main(String[] args) {
        /*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);*/

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersonConfig.class);
        Person person = applicationContext.getBean(Person.class);
        System.out.println(person);

        // Person这个类型的组件在IOC容器中的名字是什么呢？
        String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String name : namesForType) {
            System.out.println(name);
        }
    }
}
