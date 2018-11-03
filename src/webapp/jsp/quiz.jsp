<%@ page import="quiz.QuizController" %>
<%@page language="java" contentType="text/html; UTF8" %>
<html>
<head>
    <title>Win Your Life</title>
</head>

<body>

<body>
<div class="jumbotron text-center">
    <h1>Question number ${sessionScope.counter}</h1>
    <p>${quizQuestion.question}</p>
</div>
<div class="container">
    <form method="post" action="/quiz">
        <select name="answer">
            <option value="${quizQuestion.answers[0]}">${quizQuestion.answers[0]}</option>
            <option value="${quizQuestion.answers[1]}">${quizQuestion.answers[1]}</option>
            <option value="${quizQuestion.answers[2]}">${quizQuestion.answers[2]}</option>
            <option value="${quizQuestion.answers[3]}">${quizQuestion.answers[3]}</option>
        </select>
        <input type="submit" value="Next">
    </form>
</div>
</body>
</body>


</html>

