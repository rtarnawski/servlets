package shop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "BasketAddingController", value = "/basketadding")
public class BasketAddingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        HttpSession session = httpServletRequest.getSession();

        Basket basket = (Basket) session.getAttribute("basket");
        String productId = httpServletRequest.getParameter("productId");
        Integer id = Integer.parseInt(productId);
        for (Product product : ShopController.productList) {
            if (id.equals(product.getId())) {
                if (basket.getBasketMap().containsKey(product)) {
                    Integer quantity = basket.getBasketMap().get(product) + 1;
                    basket.getBasketMap().put(product, quantity);
                } else {
                    basket.getBasketMap().put(product, 1);
                }
            }
        }
        String uri = httpServletRequest.getParameter("uri");
        httpServletResponse.sendRedirect(uri);
    }
}
