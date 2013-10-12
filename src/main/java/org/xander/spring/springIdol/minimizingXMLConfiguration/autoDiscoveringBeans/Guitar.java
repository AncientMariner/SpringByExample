package org.xander.spring.springIdol.minimizingXMLConfiguration.autoDiscoveringBeans;

import org.springframework.stereotype.Component;

@Component
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
