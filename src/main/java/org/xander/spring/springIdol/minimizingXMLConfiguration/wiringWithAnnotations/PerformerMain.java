package org.xander.spring.springIdol.minimizingXMLConfiguration.wiringWithAnnotations;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PerformerMain {
    public static void main(String[] args) throws PerformanceException {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("org/xander/spring/springIdol/minimizingXMLConfiguration/wiringWithAnnotations/spring-idol.xml");

        System.out.println();
        Performer knifeJuggler = (Performer) ctx.getBean("knifeJuggler");
        knifeJuggler.perform();
        System.out.println();
    }
}
