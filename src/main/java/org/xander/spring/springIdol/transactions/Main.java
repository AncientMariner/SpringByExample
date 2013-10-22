package org.xander.spring.springIdol.transactions;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
        public static void main(String[] args) {
            ApplicationContext context = new ClassPathXmlApplicationContext("org/xander/spring/springIdol/transactions/appcontext.xml");
            BookShop bookShop = (BookShop) context.getBean("transactionalBookShop");
            bookShop.purchase("1", "user1");
        }

}
