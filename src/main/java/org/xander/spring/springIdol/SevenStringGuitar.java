package org.xander.spring.springIdol;

import org.springframework.stereotype.Component;

@Component
@BigInstrument
public class SevenStringGuitar implements Instrument {
    @Override
    public void play() {
        System.out.println("7 - string guitar plays");
    }
}
