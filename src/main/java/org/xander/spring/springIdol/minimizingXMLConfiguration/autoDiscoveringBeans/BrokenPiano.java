package org.xander.spring.springIdol.minimizingXMLConfiguration.autoDiscoveringBeans;

@SkipIt
public class BrokenPiano implements Instrument {
    @Override
    public void play() {
        System.out.println("Broken piano");
    }
}
