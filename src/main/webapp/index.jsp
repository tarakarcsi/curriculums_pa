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
        <div id = "login-page" class="login-page">
            <div class="form">
              <form id="register-form" class="hidden content">
                <h2>Register</h2>
                <input name="name" type="text" placeholder="name"/>
                <input name="password" type="password" placeholder="password"/>
                <input name="email" type="text" placeholder="email address"/>
                <button id = "register-button" >create</button> 
                <p id="signin" class="message">Already registered? <a href="javascript:void(0);" onclick="onSignInClicked()">Sign In</a></p>
              </form>
              <form id="login-form" class="login-form">
                <h2>Login</h2>
                <input name="email" type="text" placeholder="email"/>
                <input name="password" type="password" placeholder="password"/>
                <button id = "login-button" >login</button>
                <p id="create-account" class="message">Not registered? <a href="javascript:void(0);" onclick="onCreateAccountClicked()";>Create an account</a></p>
              </form>
            </div>
          </div>
    </body>
</html>
