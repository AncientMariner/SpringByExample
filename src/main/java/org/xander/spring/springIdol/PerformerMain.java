package org.xander.spring.springIdol;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PerformerMain {
    public static void main(String[] args) throws PerformanceException {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("org/xander/spring/springIdol/spring-idol.xml");
        Performer performer = (Performer) ctx.getBean("duke");
        performer.perform();
        System.out.println();
        Performer mightyPerformer = (Performer) ctx.getBean("dukeMightyJuggler");
        mightyPerformer.perform();
        System.out.println();
        Performer poeticPerformer = (Performer) ctx.getBean("poeticDuke");
        poeticPerformer.perform();
        System.out.println();

        Stage stage1= (Stage) ctx.getBean("stage");
        Stage stage2= (Stage) ctx.getBean("stage");

        if (stage1.equals(stage2)) {
            System.out.println("There is only one stage");
        } else {
            System.out.println("Stage is different");
        }

        Ticket ticket1 = (Ticket) ctx.getBean("ticket");
        Ticket ticket2 = (Ticket) ctx.getBean("ticket");

        if (ticket1.equals(ticket2)) {
            System.out.println("Ticket is the same");
        } else {
            System.out.println("Tickets are different");
        }


        Auditorium auditorium = (Auditorium) ctx.getBean("auditorium");
        ctx.close();
    }
}
