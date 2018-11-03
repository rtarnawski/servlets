<%@ page import="quiz.QuizController" %>
<%@page language="java" contentType="text/html; UTF8" %>
<html>
<head>
    <title>Score</title>
</head>

</div>
<body>

<body>

<body>
<div class="jumbotron text-center">
    <h1>Question number ${sessionScope.counter}</h1>
    <p>${quizQuestion.question}</p>
</div>
<div class="container">
    <form method="post" action="/quiz">
        <h1 align="center">
            <% out.print(session.getAttribute("score")); %>
        </h1>
    </form>
</div>
</body>
</body>

</body>


</html>

