package com.rush;

import com.rush.bean.Boss;
import com.rush.bean.Car;
import com.rush.bean.Cat;
import com.rush.bean.Color;
import com.rush.config.MainConfigOfAutowired;
import com.rush.dao.BookDao;
import com.rush.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Autowired {
    @Test
    public void test02() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);

        Color color = applicationContext.getBean(Color.class);
        System.out.println(color);

        applicationContext.close();
    }

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);

        /*BookService bookService = applicationContext.getBean(BookService.class);
        System.out.println(bookService);*/

       /* BookDao bookDao = applicationContext.getBean(BookDao.class);
        System.out.println(bookDao);*/

        Boss boss = applicationContext.getBean(Boss.class);
        System.out.println(boss);

        Car car = applicationContext.getBean(Car.class);
        System.out.println(car);

        Cat cat = applicationContext.getBean(Cat.class);
        System.out.println(cat);

        applicationContext.close();
    }
}
