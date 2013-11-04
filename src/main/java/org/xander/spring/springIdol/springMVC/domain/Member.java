package org.xander.spring.springIdol.springMVC.domain;

public class Member {
    private double id;
    private String name;

    public Member(String name, double id) {
        this.name = name;
        this.id = id;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
