package org.xander.spring.springIdol.minimizingXMLConfiguration.wiringWithAnnotations;

public class Harmonica implements Instrument {
    public Harmonica() {
    }

    @Override
    public void play() {
        System.out.println("Viu viu viu");
    }
}
