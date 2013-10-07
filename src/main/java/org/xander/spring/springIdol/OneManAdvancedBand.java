package org.xander.spring.springIdol;

import java.util.Map;

public class OneManAdvancedBand implements Performer {
    private Map<String, Instrument> instruments;

    public OneManAdvancedBand() {
    }

    @Override
    public void perform() throws PerformanceException {
        for (String key : instruments.keySet()) {
            System.out.println(key + " : ");
            Instrument instrument = instruments.get(key);
            instrument.play();
        }
    }

    public void setInstruments(Map<String, Instrument> instruments) {
        this.instruments = instruments;
    }
}
