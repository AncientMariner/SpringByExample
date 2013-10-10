package org.xander.spring.springIdol;

@SkipIt
public class BrokenPiano implements Instrument {
    @Override
    public void play() {
        System.out.println("Broken piano");
    }
}
