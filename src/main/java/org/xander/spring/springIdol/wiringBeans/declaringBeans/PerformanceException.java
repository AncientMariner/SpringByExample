package org.xander.spring.springIdol.wiringBeans.declaringBeans;

public class PerformanceException extends Exception {
    public PerformanceException() {
        throw new RuntimeException("Performance problem");
    }
}
