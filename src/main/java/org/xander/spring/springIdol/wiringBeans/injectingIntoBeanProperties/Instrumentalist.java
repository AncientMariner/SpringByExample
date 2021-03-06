package org.xander.spring.springIdol.wiringBeans.injectingIntoBeanProperties;

public class Instrumentalist implements Performer {
    public Instrumentalist() {
    }

    private String song;
    private Instrument instrument;

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
