package com.rush;

import com.rush.bean.Person;
import com.rush.config.MainConfig2;
import com.rush.config.MainConfig3;
import com.rush.config.PersonConfig;
import com.rush.scope.ThreadScope;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class IOCTest {

    @Test
    public void testImport(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanname:
        beanDefinitionNames) {
            System.out.println(beanname);
        }

        // 工厂bean获取的是调用getObject方法创建的对象
        Object bean2 = applicationContext.getBean("colorFactoryBean");
        Object bean3 = applicationContext.getBean("colorFactoryBean");
        System.out.println("bean的类型：" + bean2.getClass());
        System.out.println(bean2 == bean3);

        Object bean4 = applicationContext.getBean("&colorFactoryBean");
        System.out.println(bean4.getClass());
    }

    @Test
    public void test06() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        // 我们现在就来看一下IOC容器中Person这种类型的bean都有哪些
        String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);

        for (String name : namesForType) {
            System.out.println(name);
        }

        Map<String, Person> beansOfType = applicationContext.getBeansOfType(Person.class);
        System.out.println(beansOfType);
    }

    @Test
    public void test05() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        System.out.println("IOC容器创建完成");
        Person person = (Person) applicationContext.getBean("person");
        Person person2 = (Person) applicationContext.getBean("person");
        System.out.println(person==person2);
    }

    @Test
    public void test04() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig3.class);
        // 向容器中注册自定义的Scope
        applicationContext.getBeanFactory().registerScope(ThreadScope.THREAD_SCOPE, new ThreadScope());

        // 使用容器获取bean
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread() + "," + applicationContext.getBean("person"));
                System.out.println(Thread.currentThread() + "," + applicationContext.getBean("person"));
            }).start();
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test03(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        Person person = (Person) applicationContext.getBean("person");
        Person person2 = (Person) applicationContext.getBean("person");
    }

    @Test
    public void test02() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        Person person = (Person) applicationContext.getBean("person");
        Person person2 = (Person) applicationContext.getBean("person");

        System.out.println(person==person2);
    }

    @Test
    public void test01(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersonConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name: beanDefinitionNames) {
            System.out.println("rush-king："+name);
        }
    }

    @Test
    public void test() {
        ApplicationContext applicationContext = new  ClassPathXmlApplicationContext("beans.xml");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name: beanDefinitionNames) {
            System.out.println("rush-king："+name);
        }
    }
}
