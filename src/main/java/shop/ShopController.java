package shop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "ShopController", value = "/shop")
public class ShopController extends HttpServlet {
    public static List<Product> productList = new ArrayList<Product>();

    static {
        Product product1 = new Product("Pepsi", "Puszka 0,33l", 2);
        Product product2 = new Product("WW", "Wafelki czekoladowe", 2);
        Product product3 = new Product("Lays", "chrupki serowe", 4);
        Product product4 = new Product("Kanapka", "Pyycha", 5);
        Product product5 = new Product("Kawa", "Zawsze dobra", 3);
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        HttpSession session = httpServletRequest.getSession();
        if(session.getAttribute("basket") == null) {
            session.setAttribute("basket", new Basket(new HashMap<Product, Integer>()));
        }

        httpServletRequest.setAttribute("productList", productList);
        httpServletRequest.getRequestDispatcher("shop.jsp").forward(httpServletRequest, httpServletResponse);
    }

}
