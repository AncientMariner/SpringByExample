package org.xander.spring.springIdol.wiringBeans.injectingIntoBeanProperties;

public class PerformanceException extends Exception {
    public PerformanceException() {
        throw new RuntimeException("Performance problem");
    }
}
