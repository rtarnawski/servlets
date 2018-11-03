<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page language="java" contentType="text/html; UTF8" %>
<html>

<head>
    <title>Best shopping place</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

</head>
<body class="body-green" data-elink-extension-installed="1.1.5">

<div class="jumbotron text-center">
    <h1>Shop Online</h1>
    <p>Please log in or register</p>
</div>
<!-- Body -->
<div class="wrapper body-inverse"> <!-- wrapper -->
    <div class="container">
        <div class="row">
            <!-- Sign In form -->
            <div class="col-sm-5 col-sm-offset-1">
                <h3>Sign In to your account</h3>
                <p class="text-muted">
                    Please fill out the form below to login to your account.
                </p>
                <div class="form-white">
                    <form role="form" method="post" action="/login">
                        <div class="form-group">
                            <label for="username1">Username</label>
                            <input type="text" class="form-control" id="username1" name="username"
                                   placeholder="Enter email">
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" name="password" id="password"
                                   placeholder="Password">
                        </div>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox"> Remember me
                            </label>
                        </div>
                        <button type="submit" class="btn btn-block btn-color btn-xxl">Submit</button>
                        <c:if test="${error != null}">
                            <p style="color: #962E22">Invalid username or password</p>
                        </c:if>

                    </form>
                    <hr>
                    <p><a href=".html#" id="lost-btn">Lost your password?</a></p>
                    <div class="hidden" id="lost-form">
                        <p>Enter your email address and we will send you a link to reset your password.</p>
                        <form role="form">
                            <div class="form-group">
                                <label for="email-lost">Email address</label>
                                <input type="email" class="form-control" id="email-lost" placeholder="Enter email">
                            </div>
                            <button type="submit" class="btn btn-default">Send</button>
                        </form>
                    </div>
                    <div class="form-avatar hidden-xs">
				<span class="fa-stack fa-4x">
				  <i class="fa fa-circle fa-stack-2x"></i>
				  <i class="fa fa-user fa-stack-1x"></i>
				</span>
                    </div>
                </div>
            </div>
            <!-- Sign Up form -->
            <div class="col-sm-5">
                <h3 class="text-right-xs">Sign Up to your account</h3>
                <p class="text-muted text-right-xs">
                    Please fill out the form below to create a new account.
                </p>
                <div class="form-white">
                    <form role="form" method="post" action="/register">
                        <div class="form-group">
                            <label for="name">Full Name</label>
                            <input type="text" class="form-control" name="fullName" id="name" placeholder="Your name">
                        </div>
                        <div class="form-group">
                            <label for="username">Username</label>
                            <input type="text" class="form-control" name="username" id="username"
                                   placeholder="Username">
                        </div>
                        <div class="form-group">
                            <label for="email2">Email address</label>
                            <input type="email" class="form-control" name="email" id="email2" placeholder="Enter email">
                        </div>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-sm-6">
                                    <label for="password2">Password</label>
                                    <input type="password" class="form-control" name="password2" id="password2"
                                           placeholder="Password">
                                </div>
                                <div class="col-sm-6">
                                    <label for="password2">Repeat password</label>
                                    <input type="password" class="form-control" name="password3" id="password3"
                                           placeholder="Password">
                                </div>
                            </div>
                        </div>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox"> I agree to the <a .html#">Terms of Service</a> and <a
                                    href=".html#">Privacy Policy</a>
                            </label>
                        </div>
                        <button type="submit" class="btn btn-block btn-color btn-xxl">Create an account</button>
                        <c:if test="${passwordError != null}">
                            <p style="color: #962E22">Password repeated incorrectly</p>
                        </c:if>
                        <c:if test="${userNameError != null}">
                            <p style="color: #962E22">user name is already taken</p>
                        </c:if>
                        <c:if test="${fullNameNull !=null}">
                            <p style="color: #962E22">Full name can not be empty</p>
                        </c:if>
                        <c:if test="${userNameNull != null}">
                            <p style="color: #962E22">User name can not be empty</p>
                        </c:if>
                        <c:if test="${emailNull != null}">
                            <p style="color: #962E22">Email can not be empty</p>
                        </c:if>
                        <c:if test="${passwordNull != null}">
                            <p style="color: #962E22">Password can not be empty</p>
                        </c:if>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div> <!-- / wrapper -->
</html>
