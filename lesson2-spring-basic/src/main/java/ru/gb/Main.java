package ru.gb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.service.CartService;


public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        CartService cartService = context.getBean("cartService", CartService.class);
        CartService cartService1 = context.getBean("cartService", CartService.class);
        CartService cartService2 = context.getBean("cartService", CartService.class);

        System.out.println("Product count: " + cartService);
    }
}
