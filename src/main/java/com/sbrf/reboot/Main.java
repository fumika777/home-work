package com.sbrf.reboot;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        AccountBean account = context.getBean("account", AccountBean.class);
        Customer customer = context.getBean("customer", Customer.class);

        System.out.println(account.getCurrency());
        System.out.println(customer.getAccount());

        context.close();
    }
}
