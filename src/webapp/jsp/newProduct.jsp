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
</head>
<body>

<div class="jumbotron text-center">
    <h1>Shop Online</h1>
    <p>Happy shopping!</p>
</div>

<form method="post" action="/newproduct">
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputName">Name</label>
            <input type="text" class="form-control" id="inputName" name="inputName" placeholder="Name of a product">
        </div>
        <div class="form-group col-md-6">
            <label for="inputPrice">Price</label>
            <input type="text" class="form-control" id="inputPrice" name="inputPrice" placeholder="Price">
        </div>
    </div>
    <div class="form-group">
            <label for="inputDescription">Description</label>
        <input type="text" class="form-control" id="inputDescription" name="inputDescription" placeholder="Description of a product">
    </div>


    </div>
    </div>


    <button type="submit" class="btn btn-primary">ADD</button>


</form>

</div>
</div>

</body>
</html>
