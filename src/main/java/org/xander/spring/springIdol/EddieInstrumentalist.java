package org.xander.spring.springIdol;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component("eddie")
public class EddieInstrumentalist implements Performer {
    @Value("Eruption")
//    @Value("#{systemProperties.myFavoriteSong}")
    private String song;

//    Just like @Autowired, @Inject can be used to autowire properties, methods, and con-
//    structors. Unlike @Autowired, @Inject doesn’t have a required attribute. Therefore,
//    @Inject-annotated dependencies are expected to be fulfilled, failing with an excep-
//    tion if they’re not.
//    JSR-330
    @Inject
    @BigInstrument
    private Instrument instrument;

    @Override
    public void perform() throws PerformanceException {
        System.out.println("here's Eddie plays his song " + song);
        instrument.play();
    }
}
