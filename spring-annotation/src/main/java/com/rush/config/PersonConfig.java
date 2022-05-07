package com.rush.config;

import com.rush.bean.Person;
import com.rush.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.type.filter.AspectJTypeFilter;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * 按照注解进行包含或者排除
 */
/*@ComponentScan(value = "com.rush",includeFilters={@ComponentScan.Filter(type =FilterType.ANNOTATION,classes={Controller.class})},useDefaultFilters=false)
@ComponentScan(value = "com.rush",includeFilters={@ComponentScan.Filter(type =FilterType.ASSIGNABLE_TYPE, classes={BookService.class})},useDefaultFilters=false)*/
/**按照自定义规则进行包含或者排除*/
@ComponentScan(value = "com.rush",includeFilters={@ComponentScan.Filter(type = FilterType.CUSTOM,classes = MyTypeFilter.class)},useDefaultFilters=false)
@Configuration
public class PersonConfig {


    @Bean("person01")
    public Person person(){
        return  new Person("张三",23);
    }
}
