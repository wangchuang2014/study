package com.rush.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

public class Color {
    public Car car;
    public Bule bule;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Bule getBule() {
        return bule;
    }

    public void setBule(Bule bule) {
        this.bule = bule;
    }

    @Override
    public String toString() {
        return "Color{" +
                "car=" + car +
                ", bule=" + bule +
                '}';
    }
}
