package org.xander.spring.springIdol.springMVC.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Member {
    @NotNull
    @Size(min=2)
    private String name;
    @NotNull
    @Size(min = 9, max = 14)
    private String phone;
    @Pattern(regexp=".+@.+\\.[a-z]+")
    private String email;

    private double id;

    public Member(String name, double id, String phone, String email) {
        this.phone = phone;
        this.email = email;
        this.name = name;
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
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
