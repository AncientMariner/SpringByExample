package org.xander.spring.springIdol.wiringBeans.injectingIntoBeanProperties;

public class Harmonica implements Instrument {
    public Harmonica() {
    }

    @Override
    public void play() {
        System.out.println("Viu viu viu");
    }
}
