package org.xander.spring.springIdol.minimizingXMLConfiguration.wiringWithAnnotations;

public class Saxophone implements Instrument {
    public Saxophone() {
    }

    @Override
    public void play() {
        System.out.println("TOOT TOO TOOT");
    }
}
