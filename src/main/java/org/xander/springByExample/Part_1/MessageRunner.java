package org.xander.springByExample.Part_1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Logger;

public class MessageRunner {

    final static Logger logger = Logger.getLogger(String.valueOf(MessageRunner.class));

    public static void main(String[] args) {
        logger.info("\n\nInitializing Spring context.");

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("org/xander/springByExample/Part_1/application-context.xml");
        logger.info("\n\nSpring context initialized.");

        Message message = (Message) applicationContext.getBean("message");
        logger.info("\n\nmessage = '" + message.getMessage() + "'");
    }
}
