<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
    <head>
        <c:url value="/style.css" var="styleUrl"/>
        <link rel="stylesheet" type="text/css" href="${styleUrl}">
        <c:url value="/index.js" var="indexScriptUrl"/>
        <script src="${indexScriptUrl}"></script>
    </head>
    <body>
        <div class="register" id="redisterDiv">
            <h2>Register</h2>
            <form id="register-form">
                    <input type="email" name="email" placeholder="" required/>
                    <label for="email">E-mail</label>
                    <input type="password" name="password" placeholder="" required/>
                    <label for="email">password</label>
                    <input type="submit" value="Register" id = "register-button" />
            </form>
        </div>
        <div class="login" id = "loginDiv">
            <h2>Login</h2>
            <form id="login-form">
                <input type="email" name="email" required>
                <label for="email">E-mail</label>
                <input type="password" name="password" required>
                <input type="submit" id="login-button" value="Login">
            </form>
        </div>
    </body>
</html>