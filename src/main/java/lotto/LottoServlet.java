package lotto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "LottoServlet", value = "/lotto")
public class LottoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        RequestDispatcher dispatcher = httpServletRequest.getRequestDispatcher("lotto.jsp");
        dispatcher.forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String number = httpServletRequest.getParameter("number");
        Integer choice = Integer.parseInt(number);
        String attribute = null;
        Random random = new Random();
        Integer randomInt = random.nextInt(5);
        if (choice.equals(randomInt)) {
            attribute = "You Winn!";
        } else {
            attribute = "You loose...";
        }
        httpServletRequest.setAttribute("lucky", attribute);
        httpServletRequest.getRequestDispatcher("result.jsp").forward(httpServletRequest, httpServletResponse);
    }
}
