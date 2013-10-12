package org.xander.spring.springIdol.minimizingXMLConfiguration.autoDiscoveringBeans;

public class PerformanceException extends Exception {
    public PerformanceException() {
        throw new RuntimeException("Performance problem");
    }
}
