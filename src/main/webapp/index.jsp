<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
    <head>
        <c:url value="/style.css" var="styleUrl"/>
        <link rel="stylesheet" type="text/css" href="${styleUrl}">
        <c:url value="/index.js" var="indexScriptUrl"/>
        <script src="${indexScriptUrl}"></script>
        <c:url value="/login.js" var="loginScriptUrl"/>
        <script src="${loginScriptUrl}"></script>
        <c:url value="/register.js" var="registerScriptUrl"/>
        <script src="${registerScriptUrl}"></script>
    </head>
    <body>
        <nav class="navbar">
            <span class="navbar-toggle" id="js-navbar-toggle">
                <i class="fas fa-bars"></i>
            </span>
            <a href="#" class="logo">logo</a>
            <ul class="main-nav" id="js-menu">
                <li>
                    <a href="#" class="nav-links">Home</a>
                </li>
                <li>
                    <a href="#" class="nav-links">Products</a>
                </li>
                <li>
                    <a href="#" class="nav-links">About Us</a>
                </li>
                <li>
                    <a href="#" class="nav-links">Contact Us</a>
                </li>
                <li>
                    <a href="#" class="nav-links">Blog</a>
                </li>
            </ul>
        </nav>
    </body>
</html>
