package org.xander.spring.springIdol;

import org.springframework.beans.factory.annotation.Autowired;

public class Instrumentalist implements Performer {
    private String song;
    //    @Autowired(required = false) indicates it is possible to set null here if bean is absent
    @Autowired
//    @Qualifier("yamaha")
    @StringedInstrument  //may conflict if qualifier is already defined in .xml
    @Strummed
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
