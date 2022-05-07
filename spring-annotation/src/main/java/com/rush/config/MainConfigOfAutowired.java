package com.rush.config;

import com.rush.bean.Bule;
import com.rush.bean.Car;
import com.rush.bean.Color;
import com.rush.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan({"com.rush.service", "com.rush.dao", "com.rush.controller","com.rush.bean"})
public class MainConfigOfAutowired {

    @Bean
    public Color color(Car car,Bule bule) {
        Color color = new Color();
        color.setCar(car);
        color.setBule(bule);
        return color;
    }

    @Primary
    @Bean("bookDao2")
    public BookDao bookDao() {
        BookDao bookDao = new BookDao();
        bookDao.setLable("2");
        return bookDao;
    }
}
