package org.xander.spring.springIdol.minimizingXMLConfiguration.wiringWithAnnotations;

public class PerformanceException extends Exception {
    public PerformanceException() {
        throw new RuntimeException("Performance problem");
    }
}
