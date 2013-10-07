package org.xander.spring.springIdol;

public class Guitar implements Instrument {
    public Guitar() {
    }

    @Override
    public void play() {
        System.out.println("Tin tin trin");
    }
}
