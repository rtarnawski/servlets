package shop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        HttpSession session = httpServletRequest.getSession();
        if (session.getAttribute("logged") != null) {
            httpServletResponse.sendRedirect("/shop");
        } else
            httpServletRequest.getRequestDispatcher("login.jsp").forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String username = (String) httpServletRequest.getParameter("username");
        String password = (String) httpServletRequest.getParameter("password");
        User user = checkLogin(Shop.userList, username, password);
        if (user != null) {
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("logged", user);
            httpServletResponse.sendRedirect("/shop");
        } else {
            httpServletRequest.setAttribute("error", "error");
            httpServletRequest.getRequestDispatcher("login.jsp").forward(httpServletRequest, httpServletResponse);
        }
    }

    User checkLogin(List<User> userList, String username, String password) {
        for (User user : userList) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                if (user.getPassword().equals(password)) {
                    return user;
                }
            }
        }
        return null;
    }
}
