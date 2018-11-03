<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
    <p>Your basket</p>
</div>

<div class="container">
    <div class="row">

        <c:forEach items="${products}" var="product">

            <div class="col-sm-4">
                <h3>${product.name}</h3>
                <p>Description: ${product.description}</p>
                <p>Price: ${product.price} PLN</p>
                <p>Quantity: ${basketMap.get(product)}</p>
                <p>SUM: ${product.price * basketMap.get(product)} PLN</p>


                <form method="post" action="/basketadding">
                    <input type="hidden" value=${product.id} name="productId"/>
                    <input type="hidden" name="uri" value="/basket"/>

                    <button type="submit" class="btn btn-success">Add another one</button>

                </form>

                <form method="post" action="/basketremoving">
                    <input type="hidden" value=${product.id} name="productId"/>
                    <input type="hidden" name="uri" value="/basket"/>

                    <button type="submit" class="btn btn-success">Remove one</button>

                </form>


            </div>
        </c:forEach>

    </div>
</div>
<br><br>
<div class="container">

    <a href="/shop" class="btn btn-info btn-block"><h2>Continue shopping</h2></a>

</div>

</div>

</body>
</html>
