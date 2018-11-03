package com.shopadvisor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "AdvisorServlet", urlPatterns = {"/advise.me", "/shopper", "/advisor"})
public class AdvisorServlet extends HttpServlet {
    List<String> shoes = Arrays.asList("Lasocki", "Cat Walk", "Manolo Blahnik");
    List<String> dresses = Arrays.asList("Mohito", "Pierre Cardin", "Górnik");
    List<String> jeans = Arrays.asList("Lee", "Levi's", "Diesel");
    List<String> tshirts = Arrays.asList("Lee", "Levi's", "Diesel");

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        RequestDispatcher dispatcher = httpServletRequest.getRequestDispatcher("advisor.jsp");
        dispatcher.forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String type = httpServletRequest.getParameter("type");
        String stuffByType = getStuffByType(type);
        httpServletRequest.setAttribute("type", stuffByType);
        httpServletRequest.getRequestDispatcher("advise.jsp").forward(httpServletRequest, httpServletResponse);
    }

    public String getStuffByType(String type) {
        StringBuilder builder = new StringBuilder();
        int count = 1;
        if (type.equalsIgnoreCase("shoes")) {
            for (String shoe : shoes) {
                builder.append(count + ". ");
                builder.append(shoe + "<br>");
                count++;
            }
        } else if (type.equalsIgnoreCase("dresses")) {
            for (String dress : dresses) {
                builder.append(count + ". ");
                builder.append(dress + "<br>");
                count++;
            }
        } else if (type.equalsIgnoreCase("jeans")) {
            for (String jeans : jeans) {
                builder.append(count + ". ");
                builder.append(jeans + "<br>");
                count++;
            }
        } else {
            for (String tshirt : tshirts) {
                builder.append(count + ". ");
                builder.append(tshirt + "<br>");
                count++;
            }
        }
        return builder.toString();
    }
}
