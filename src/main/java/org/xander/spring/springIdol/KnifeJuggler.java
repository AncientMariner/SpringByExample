package org.xander.spring.springIdol;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class KnifeJuggler implements Performer {
    private Set<Knife> knives;
    //lazzy injection using provider
    //    Rather than inject a reference directly, you could ask @Inject to inject a Provider.
    //    The Provider interface enables, among other things, lazy injection of bean refer-
    //    ences and injection of multiple instances of a bean.
    @Inject
    //    The key difference between Spring’s @Qualifier and JSR-330’s @Named is one of
    //    semantics. Whereas @Qualifier helps narrow the selection of matching beans (using the bean’s ID by default),
    //    @Named specifically identifies a selected bean by its ID.
    //    Rather than inject a reference directly, you could ask @Inject to inject a Provider.
    //    The Provider interface enables, among other things, lazy injection of bean refer-
    //    ences and injection of multiple instances of a bean.
    @Named("knife")
    public KnifeJuggler(Provider<Knife> knifeProvider) {
        knives = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            knives.add(knifeProvider.get());
        }
    }

    @Override
    public void perform() throws PerformanceException {
        Iterator<Knife> iter = knives.iterator();
        for (Knife knife : knives) {
            System.out.println(iter.next().hashCode());
        }
    }
}
