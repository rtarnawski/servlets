

<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@page language="java" contentType="text/html;" pageEncoding="utf-8" %>
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
    <c:if test="${logged != null}">
     <p>
      Hi ${logged.fullName}!
     </p>
    </c:if>
    <p>Happy shopping!</p>
</div>

<div class="container">
    <div class="row">

        <c:forEach items="${productList}" var="product">

        <div class="col-sm-4">
            <h3>${product.name}</h3>
            <p>Description: ${product.description}</p>
            <p>Price: ${product.price} PLN</p>


            <form method="post" action="/basketadding">
                <input type="hidden" value=${product.id} name="productId" />
                <input type="hidden" name="uri", value="/shop" />
            <button type="submit" class="btn btn-success">Add to basket</button>

            </form>


        </div>
        </c:forEach>

    </div>
            </div>

<br><br>

<div class="container" style="alignment: center">

    <a href="/basket" style="alignment: left" class="btn btn-primary"><h2>Go to basket</h2></a>

    <c:if test="${logged != null}">

        <a href="/logout" style="alignment: right" class="btn btn-primary"><h2>Log out</h2></a>
    </c:if>


</div>


<br><br>
<div class="container">

    <a href="/newproduct" class="btn btn-info btn-block"><h2>Add product(admin only)</h2></a>

</div>
</div>

</body>
</html>
