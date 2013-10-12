package org.xander.spring.springIdol.minimizingXMLConfiguration.javaBasedConfiguration;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PerformerMain {
    public static void main(String[] args) throws PerformanceException {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("org/xander/spring/springIdol/minimizingXMLConfiguration/javaBasedConfiguration/spring-idol.xml");
        Performer duke = (Performer) ctx.getBean("duke");
        duke.perform();
        System.out.println();

        Performer duke15 = (Performer) ctx.getBean("duke15");
        duke15.perform();
        System.out.println();

        Performer poeticDuke = (Performer) ctx.getBean("poeticDuke");
        poeticDuke.perform();
        System.out.println();
    }
}
