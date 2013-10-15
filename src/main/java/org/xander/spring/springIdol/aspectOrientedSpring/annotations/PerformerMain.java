package org.xander.spring.springIdol.aspectOrientedSpring.annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PerformerMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("org/xander/spring/springIdol/aspectOrientedSpring/annotations/spring-idol.xml");
        Thinker thinker = (Thinker) context.getBean("volunteer");
        thinker.thinkOfSomething("Queen of blades");
    }
}
