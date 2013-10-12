package org.xander.spring.springIdol.wiringBeans.injectingIntoBeanProperties;

public class Guitar implements Instrument {
    private int numberOfStrings;

    public Guitar() {
    }

    public int getNumberOfStrings() {
        return numberOfStrings;
    }

    public void setNumberOfStrings(int numberOfStrings) {
        this.numberOfStrings = numberOfStrings;
    }

    @Override
    public void play() {
        System.out.println("Tin tin trin");
    }
}
