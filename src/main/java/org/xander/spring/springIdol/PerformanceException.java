package org.xander.spring.springIdol;

public class PerformanceException extends Exception {
    public PerformanceException() {
        throw new RuntimeException("Performance problem");
    }
}
