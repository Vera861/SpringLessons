package ru.gb;

import ru.gb.persist.Product;
import ru.gb.persist.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/product/*")
public class ProductServlet extends HttpServlet {

    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
        productRepository = (ProductRepository) getServletConfig().getServletContext().getAttribute("productRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter wr = resp.getWriter();

        wr.println("<table>");
        wr.println("<tr>");
        wr.println("<th>ID</th>");
        wr.println("<th>Название</th>");
        wr.println("<tr>");


        if (req.getPathInfo() != null && !req.getPathInfo().equals("/")) {

            for (Product product : productRepository.findAll()) {

                wr.println("<tr>");
                wr.println("<th>" + product.getId() + "</th>");
                if (product.getId() == Long.valueOf(req.getParameter("id"))) {
                    wr.println("<th>" + "<a href='product?id="
                            + req.getParameter("id") + "'>" + product.getName() + "</a>" + "</th>");
                } else {
                    wr.println("<th>" + product.getName() + "</th>");
                }
                wr.println("<tr>");
            }
        } else if (req.getPathInfo() == null || req.getPathInfo().equals("/")) {

            for (Product product : productRepository.findAll()) {
                wr.println("<tr>");
                wr.println("<th>" + product.getId() + "</th>");
                wr.println("<th>" + product.getName() + "</th>");
                wr.println("<tr>");
            }
        }
      wr.println("</table>");
    }
}
