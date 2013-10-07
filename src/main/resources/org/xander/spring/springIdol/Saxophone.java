package org.xander.spring.springIdol;

public class Saxophone implements Instrument {
    public Saxophone() {
    }

    @Override
    public void play() {
        System.out.println("TOOT TOO TOOT");
    }
}
