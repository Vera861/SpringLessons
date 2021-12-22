package ru.gb;

import ru.gb.persist.Product;
import ru.gb.persist.ProductRepository;
import ru.gb.persist.ProductRepositoryImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class BootsrapListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();

        ProductRepository productRepository = new ProductRepositoryImpl();
        productRepository.save(new Product(1l, "Яблоко"));
        productRepository.save(new Product(2l, "Груша"));
        productRepository.save(new Product(3l, "Вишня"));
        sc.setAttribute("productRepository",productRepository);
    }
}
