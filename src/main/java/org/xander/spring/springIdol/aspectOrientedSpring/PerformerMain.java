package org.xander.spring.springIdol.aspectOrientedSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PerformerMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("org/xander/spring/springIdol/aspectOrientedSpring/spring-idol.xml");
        MindReader magician = (MindReader) context.getBean("magician");
        magician.interceptThoughts();
    }
}
