<%-- 
    Document   : shoppinglist
    Created on : 13-Feb-2023, 9:57:10 AM
    Author     : mdkul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>theList</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        Hello ${username}<Br>
        <a href="?action=logout">Logout</a>
        
        <form action="" method="post">
            <h2>Add Item</h2>
            <input type="text" name="item"> <input type="submit" value="Add Item">
            <input type="hidden" name="action" value="add">
        </form>
        
        <form action="" method="post">
            <ul>
                <c:forEach items="${theStuff}" var="item">
                    <li>${item}</li>
                </c:forEach>
               
                
            </ul>
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
        </form>
    </body>
</html>
