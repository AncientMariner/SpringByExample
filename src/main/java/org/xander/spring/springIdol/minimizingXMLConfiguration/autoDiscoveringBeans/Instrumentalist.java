package org.xander.spring.springIdol.minimizingXMLConfiguration.autoDiscoveringBeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("danny")
public class Instrumentalist implements Performer {
    @Value("Creation")
    private String song;
    //    @Autowired(required = false) indicates it is possible to set null here if bean is absent
    @Autowired
    @BigInstrument
    private Instrument instrument;

    public Instrumentalist() {
    }

    @Override
    public void perform() throws PerformanceException {
        System.out.println("Playing " + song + " : ");
        instrument.play();
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getSong() {
        return song;
    }

    public String screamSong() {
        return song;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }
}
