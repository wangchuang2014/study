package com.rush.condition;

import com.rush.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar  implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean definition = registry.containsBeanDefinition("com.rush.bean.Bule");
        boolean definition2 = registry.containsBeanDefinition("com.rush.bean.Red");
        if (definition && definition2) {
            // 指定bean的定义信息，包括bean的类型、作用域等等
            // RootBeanDefinition是BeanDefinition接口的一个实现类
            RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class); // bean的定义信息
            // 注册一个bean，并且指定bean的名称
            registry.registerBeanDefinition("rainBow", beanDefinition);
        }
    }
}
