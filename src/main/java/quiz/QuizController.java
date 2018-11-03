package quiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "QuizController", value = "/quiz")
public class QuizController extends HttpServlet {
    public static List<Quiz> questions = new ArrayList<Quiz>();

    static {
        Quiz quiz1 = new Quiz("Stolica Polski to:", Arrays.asList("Warszawa", "Bronx", "Wilno"), "Warszawa");
        Quiz quiz2 = new Quiz("Stolica Francji to:", Arrays.asList("Warszawa", "Paryz", "Berlin"), "Paryz");
        Quiz quiz3 = new Quiz("Stolica Niemiec to:", Arrays.asList("Berlin", "Mekka", "Londyn"), "Berlin");
        Quiz quiz4 = new Quiz("Stolica Belgii to:", Arrays.asList("Antwerpia", "Bruksela", "Brugia"), "Bruksela");
        questions.add(quiz1);
        questions.add(quiz2);
        questions.add(quiz3);
        questions.add(quiz4);
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("counter", 1);
        session.setAttribute("score", 0);
        httpServletRequest.setAttribute("quizQuestion", questions.get(0));
        httpServletRequest.getRequestDispatcher("quiz.jsp").forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        HttpSession session = httpServletRequest.getSession();
        Integer counter = (Integer) session.getAttribute("counter");
        validateIfPreviousQuestionIsCorrect(httpServletRequest, counter);
        if (counter == questions.size()) {
            httpServletRequest.getRequestDispatcher("score.jsp").forward(httpServletRequest, httpServletResponse);
        } else {
            httpServletRequest.setAttribute("quizQuestion", questions.get(counter));
            session.setAttribute("counter", counter + 1);
            httpServletRequest.getRequestDispatcher("quiz.jsp").forward(httpServletRequest, httpServletResponse);
        }
    }

    private void validateIfPreviousQuestionIsCorrect(HttpServletRequest request, Integer counter) {
        Quiz quiz = questions.get(counter - 1);
        String answer = request.getParameter("answer");
        if (quiz.getCorrectAnswer().equals(answer)) {
            HttpSession session = request.getSession();
            Integer currentScore = (Integer) session.getAttribute("score");
            session.setAttribute("score", currentScore + 1);
        }
    }
}
