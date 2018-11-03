package shop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RegisterController", value = "/register")
public class RegisterController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String fullName = httpServletRequest.getParameter("fullName");
        if (fullName == null || fullName.isEmpty()) {
            httpServletRequest.setAttribute("fullNameNull", "error");
            httpServletRequest.getRequestDispatcher("login.jsp").forward(httpServletRequest, httpServletResponse);
        }
        String userName = httpServletRequest.getParameter("username");
        if (userName == null || userName.isEmpty()) {
            httpServletRequest.setAttribute("userNameNull", "error");
            httpServletRequest.getRequestDispatcher("login.jsp").forward(httpServletRequest, httpServletResponse);
        }
        String email = httpServletRequest.getParameter("email");
        if (email == null || email.isEmpty()) {
            httpServletRequest.setAttribute("emailNull", "error");
            httpServletRequest.getRequestDispatcher("login.jsp").forward(httpServletRequest, httpServletResponse);
        }
        String password2 = httpServletRequest.getParameter("password2");
        if (password2 == null || password2.isEmpty()) {
            httpServletRequest.setAttribute("passwordNull", "error");
            httpServletRequest.getRequestDispatcher("login.jsp").forward(httpServletRequest, httpServletResponse);
        }
        String password3 = httpServletRequest.getParameter("password3");
        String password = null;
        if (password2.equals(password3)) {
            password = password2;
        } else {
            httpServletRequest.setAttribute("passwordError", "error");
            httpServletRequest.getRequestDispatcher("login.jsp").forward(httpServletRequest, httpServletResponse);
        }
        if (isUserNameAvailable(Shop.userList, userName)) {
            User user = new User(userName, fullName, email, password);
            Shop.userList.add(user);
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("logged", user);
            httpServletResponse.sendRedirect("/shop");
        } else {
            httpServletRequest.setAttribute("userNameError", "error");
            httpServletRequest.getRequestDispatcher("login.jsp").forward(httpServletRequest, httpServletResponse);
        }
    }

    boolean isUserNameAvailable(List<User> userList, String userName) {
        for (User user : userList) {
            if (user.getUsername().equalsIgnoreCase(userName)) {
                return false;
            }
        }
        return true;
    }
}
