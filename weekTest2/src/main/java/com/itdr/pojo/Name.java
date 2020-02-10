package com.itdr.pojo;

import org.springframework.stereotype.Component;

@Component
public class Name {
    private String xing;
    private String two;
    private String three;

    public Name() {
    }

    public Name(String xing, String two, String three) {
        this.xing = xing;
        this.two = two;
        this.three = three;
    }

    public String getXing() {
        return xing;
    }

    public void setXing(String xing) {
        this.xing = xing;
    }

    public String getTwo() {
        return two;
    }

    public void setTwo(String two) {
        this.two = two;
    }

    public String getThree() {
        return three;
    }

    public void setThree(String three) {
        this.three = three;
    }

    @Override
    public String toString() {
        return xing+two+three;
    }
}
