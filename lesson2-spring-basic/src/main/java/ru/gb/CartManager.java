package ru.gb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.service.CartService;
import java.util.Scanner;

public class CartManager {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Scanner sc = new Scanner(System.in);

        CartService cart = null;
        while (true) {
            System.out.print("Enter command: ");
            String cmd = sc.nextLine().trim().toUpperCase();
            switch (cmd) {
                case "NEW CART":
                    cart = context.getBean(CartService.class);
                    System.out.println("New cart created");
                    break;
                case "ADD PRODUCT":
                    if (cart == null) {
                        System.out.println("Please create a new Cart");
                        break;
                    }
                    System.out.print("Enter id: ");
                    long id = sc.nextLong();
                    System.out.print("Enter count: ");
                    int count = sc.nextInt();
                    cart.addProduct(id, count);
                    break;
                case "DELETE PRODUCT":
                    if (cart == null) {
                        System.out.println("Cart not exists");
                        break;
                    }
                    System.out.print("Enter id: ");
                    long idDel = sc.nextLong();
                    System.out.print("Enter count: ");
                    int countDel = sc.nextInt();
                    cart.delProduct(idDel, countDel);
                    break;

                case "SHOW CART":
                    if (cart == null) {
                        System.out.println("Please create a new Cart");
                        break;
                    }
                    cart.getAll().forEach(System.out::println);
                    break;
                case "EXIT":
                    return;
            }
        }
    }
}
