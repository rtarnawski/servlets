package shop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "BasketCotroller", value = "/basket")
public class BasketController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        HttpSession session = httpServletRequest.getSession();
        Basket basket = (Basket) session.getAttribute("basket");
        Object[] products = basket.getBasketMap().keySet().toArray();
        httpServletRequest.setAttribute("products", products);
        httpServletRequest.setAttribute("basketMap", basket.getBasketMap());

        httpServletRequest.getRequestDispatcher("basket.jsp").forward(httpServletRequest, httpServletResponse);
    }
}
