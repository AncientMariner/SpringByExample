package org.xander.spring.springIdol.wiringBeans.injectingIntoBeanProperties;

import org.xander.spring.springIdol.wiringBeans.injectingIntoBeanProperties.City;

import java.util.ArrayList;

public class CountryDescription {
    private String emptyString;

    public ArrayList<String> getList() {
        return list;
    }

    private ArrayList<String> list;

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    public String getEmptyString() {
        return emptyString;
    }

    public void setEmptyString(String emptyString) {
        this.emptyString = emptyString;
    }

    public City getCity() {
        return city;
    }

    private City city;

    public CountryDescription(City city) {
        this.city = city;
    }
}
