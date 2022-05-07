package com.rush.config;

import com.rush.bean.Color;
import com.rush.bean.ColorFactoryBean;
import com.rush.bean.Person;
import com.rush.bean.Red;
import com.rush.condition.LinuxCondition;
import com.rush.condition.MyImportBeanDefinitionRegistrar;
import com.rush.condition.MyImportSelector;
import com.rush.condition.WindowsCondition;
import org.springframework.context.annotation.*;

@Configuration
@Conditional(WindowsCondition.class)
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class,MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {

    @Lazy
    @Bean
    public Person person (){
        System.out.println("给容器中添加咱们这个Person对象...");
        return new Person("李四",25);
    }

    @Bean("bill")
    public Person person01() {
        return new Person("Bill Gates", 62);
    }

    @Bean("linus")
    @Conditional(LinuxCondition.class)
    public Person person02() {
        return new Person("linus", 48);
    }


    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }

}
