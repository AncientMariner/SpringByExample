package org.xander.spring.springIdol.transactions;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

public class Main {
        public static void main(String[] args) {
            ApplicationContext context = new ClassPathXmlApplicationContext("org/xander/spring/springIdol/transactions/appcontext.xml");
//            BookShop bookShop = (BookShop) context.getBean("transactionalBookShop");
//            bookShop.purchase("1", "user1");




            Cashier cashier = (Cashier) context.getBean("cashier");
            List<String> isbnList = Arrays.asList(new String[]{"1", "2"});
            cashier.checkout(isbnList, "user1");

        }

}
