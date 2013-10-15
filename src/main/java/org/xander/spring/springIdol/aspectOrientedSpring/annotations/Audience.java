package org.xander.spring.springIdol.aspectOrientedSpring.annotations;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {

    @Pointcut("execution(* org.xander.spring.springIdol.aspectOrientedSpring.annotations.MindReader.interceptThoughts(String))")
    public void performance() {

    }

    @Before("performance()")
    public void takeSeats() {
        System.out.println("The audience is taking their seats");
    }

    @Before("performance()")
    public void turnOffCellPhones() {
        System.out.println("The audience is turning off their cellphones");
    }

    @AfterReturning("performance()")
    public void applaud() {
        System.out.println("CLAP CLAP CLAP CLAP");
    }

    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Booo! We want our money back");
    }

//    @Around("performance()")
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
