package com.rush.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Boss {
    private Car car;
    private Cat cat;


    public Boss(Car car, Cat cat) {
        System.out.println("Boss---------有参构造器");
        this.car = car;
        this.cat = cat;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car,Cat cat) {
        this.car = car;
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                ", cat=" + cat +
                '}';
    }
}
