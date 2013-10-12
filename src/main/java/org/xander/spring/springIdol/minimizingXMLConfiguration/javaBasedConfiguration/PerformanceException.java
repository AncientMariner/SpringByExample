package org.xander.spring.springIdol.minimizingXMLConfiguration.javaBasedConfiguration;

public class PerformanceException extends Exception {
    public PerformanceException() {
        throw new RuntimeException("Performance problem");
    }
}
