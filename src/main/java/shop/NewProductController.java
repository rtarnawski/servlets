package shop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "NewProductController", value = "/newproduct")
public class NewProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("newProduct.jsp").forward(httpServletRequest, httpServletResponse);

    }
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String newProductName = httpServletRequest.getParameter("inputName");
        Integer newProductPrice = Integer.valueOf(httpServletRequest.getParameter("inputPrice"));
        String newProductDescription = httpServletRequest.getParameter("inputDescription");
        ShopController.productList.add(new Product(newProductName, newProductDescription, newProductPrice));
        httpServletRequest.setAttribute("productList", ShopController.productList);
        httpServletRequest.getRequestDispatcher("shop.jsp").forward(httpServletRequest, httpServletResponse);
    }

}
