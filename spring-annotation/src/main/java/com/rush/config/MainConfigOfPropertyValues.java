package com.rush.config;

import com.rush.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:person.properties")
@Configuration
@ComponentScan("com.rush.bean")
public class MainConfigOfPropertyValues {

    @Bean
    public Person person(){
        return  new Person();
    }
}
