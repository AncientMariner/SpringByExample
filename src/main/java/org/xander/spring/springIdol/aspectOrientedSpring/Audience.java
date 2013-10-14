package org.xander.spring.springIdol.aspectOrientedSpring;

import org.aspectj.lang.ProceedingJoinPoint;

public class Audience {
    public void takeSeats() {
        System.out.println("The audience is taking their seats");
    }

    public void turnOffCellPhones() {
        System.out.println("The audience is turning off their cellphones");
    }

    public void applaud() {
        System.out.println("CLAP CLAP CLAP CLAP");
    }

    public void demandRefund() {
        System.out.println("Booo! We want our money back");
    }

    public void watchPerformance(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("The audience is taking their seats and ");
            System.out.println("The audience is turning off their cellphones");

            long start = System.currentTimeMillis();
            joinPoint.proceed();

            long end = System.currentTimeMillis();
            System.out.println("CLAP CLAP CLAP CLAP");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("Booo! We want our money back");
        }
    }
}
