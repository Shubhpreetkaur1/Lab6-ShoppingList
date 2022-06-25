
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1><b>Shopping List</b></h1>
        <p> Hello ${username}</p>
        <a href=ShoppingList?action=logout>Logout</a>
        <br>
        <h2><b>List</b></h2>
        <br>
        <form method="post" action ="ShoppingList">
            <label>Add Item: </label>
            <input type="text" name="item" value="">
            <input type="submit" value="Add">
            <input type="hidden" name="action" value="add">
        </form>
        <p>${message1}</p>
        
    <c:if test="${itemsList != null}">
        <form action ="" method="post">
            <c:forEach var="items" items="${itemsList}">
                 <input type="radio" name="Items" value="${items}">
                <label for="${items}">${items}</label>
                <br>
            </c:forEach>
                <input type="hidden" name="action" value="delete">
                <input type="submit" value="Delete">
        </form>
         <p>${message2}</p>
    </c:if>
    </body>
</html>
