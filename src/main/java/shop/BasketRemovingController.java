package shop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "BasketRemovingController", value = "/basketremoving")
public class BasketRemovingController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        HttpSession session = httpServletRequest.getSession();
        Basket basket = (Basket) session.getAttribute("basket");
        String productId = httpServletRequest.getParameter("productId");
        Integer id = Integer.parseInt(productId);
        Product productById = Shop.findProductById(ShopController.productList, id);
        Integer qty = basket.getBasketMap().get(productById) - 1;
        if(qty <= 0){
            basket.getBasketMap().remove(productById);
        } else {
            basket.getBasketMap().put(productById, qty);
        }
        String uri = httpServletRequest.getParameter("uri");
        httpServletResponse.sendRedirect(uri);
    }
}
