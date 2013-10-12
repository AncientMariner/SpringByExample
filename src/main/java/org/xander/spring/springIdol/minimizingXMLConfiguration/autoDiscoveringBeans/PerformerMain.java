package org.xander.spring.springIdol.minimizingXMLConfiguration.autoDiscoveringBeans;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PerformerMain {
    public static void main(String[] args) throws PerformanceException {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("org/xander/spring/springIdol/minimizingXMLConfiguration/autoDiscoveringBeans/spring-idol.xml");

        Performer danny = (Performer) ctx.getBean("danny");
        danny.perform();
        System.out.println();


        Performer eddie = (Performer) ctx.getBean("eddie");
        eddie.perform();
        System.out.println();

    }
}
