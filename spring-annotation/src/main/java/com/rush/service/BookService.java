package com.rush.service;

import com.rush.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;

@Service
public class BookService {
    //如果使用了@Qualifier注解，无论是否使用了@Primary注解，都会装配@Qualifier注解标注的对象
    /*@Qualifier("bookDao")
    @Autowired(required = false)*/
    //@Resource(name="bookDao2")
    @Inject
    private BookDao bookDao;

    public void print() {
        System.out.println(bookDao);
    }

    @Override
    public String toString() {
        return "BookService [bookDao=" + bookDao + "]";
    }
}
