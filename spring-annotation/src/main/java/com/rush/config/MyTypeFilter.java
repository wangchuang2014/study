package com.rush.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MyTypeFilter implements TypeFilter {
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        // 获取当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        // 获取当前正在扫描的类的类信息，比如说它的类型是什么啊，它实现了什么接口啊之类的
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        // 获取当前类的资源信息，比如说类的路径等信息
        Resource resource = metadataReader.getResource();
        // 获取当前正在扫描的类的类名
        String className = classMetadata.getClassName();
        System.out.println("--->" + className);
        // 现在来指定一个规则
        if (className.contains("er")) {
            return true; // 匹配成功，就会被包含在容器中
        }

        return false; // 匹配不成功，所有的bean都会被排除
    }
}
