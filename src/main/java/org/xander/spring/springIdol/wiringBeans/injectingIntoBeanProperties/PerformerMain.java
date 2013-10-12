package org.xander.spring.springIdol.wiringBeans.injectingIntoBeanProperties;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PerformerMain {
    public static void main(String[] args) throws PerformanceException {
        ConfigurableApplicationContext ctx =
                new ClassPathXmlApplicationContext("org/xander/spring/springIdol/wiringBeans/injectingIntoBeanProperties/spring-idol.xml");

        Performer performerKenny = (Performer) ctx.getBean("kennySaxophonist");
        performerKenny.perform();
        System.out.println();

        Performer performerHank = (Performer) ctx.getBean("kennySinger");
        performerHank.perform();
        System.out.println();

        Performer duke = (Performer) ctx.getBean("duke");
        duke.perform();
        System.out.println();

        Performer hank = (Performer) ctx.getBean("hank");
        hank.perform();
        System.out.println();

        Performer advancedBand = (Performer) ctx.getBean("advancedBand");
        advancedBand.perform();
        System.out.println("carl");

        Performer carl = (Performer) ctx.getBean("carl");
        carl.perform();
        System.out.println();


        CountryDescription countryDescription = (CountryDescription) ctx.getBean("countryDescription");
        System.out.println(countryDescription.getCity().getName());
        System.out.println(countryDescription.getEmptyString());
        System.out.println(countryDescription.getList());
    }
}
