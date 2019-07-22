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
        <c:url value="/profile.js" var="profileScriptUrl"/>
        <script src="${profileScriptUrl}"></script>
        <c:url value="/credits.js" var="creditsScriptUrl"/>
        <script src="${creditsScriptUrl}"></script>
        <c:url value="/topics.js" var="topicsScriptUrl"/>
        <script src="${topicsScriptUrl}"></script>
    </head>
    <body>
        <div id = "login-page" class="">
            <div id="form" class="content">
                <form id="register-form" class="hidden content">
                    <input name="name" type="text" placeholder="name"/>
                    <input name="password" type="password" placeholder="password"/>
                    <input name="email" type="text" placeholder="email address"/>
                    <button id = "register-button" >create</button> 
                    <p class="message">Already registered?
                    <a href="javascript:void(0);" onclick="onSignInButtonClicked()">Sign In</a></p>
                </form>
                <form id="login-form" class="login-form" onsubmit="return false;">
                    <input name="email" type="text" placeholder="email"/>
                    <input name="password" type="password" placeholder="password"/>
                    <button id = "login-button">login</button>
                    <p id="create-account" class="message">Not registered? 
                    <a href="javascript:void(0);" onclick="onCreateAccountClicked()";>Create an account</a></p>
                </form>
            </div>
        </div>
        <div id="navbar" class="content hidden">
            <nav>
                <span class="navbar-toggle" id="js-navbar-toggle">
                    <i class="fas fa-bars"></i>
                </span>
                <a href="#" class="logo" style="vertical-align:middle;">Curriculums</a>
                <ul class="main-nav" id="js-menu">
                    
                    <p style="color:gold;"><img src="https://cdn1.iconfinder.com/data/icons/cash-coin-essentials-colored/48/JD-09-512.png" style="width: 25px; vertical-align: bottom; text-align: left;"></p><div id="credits"></div>
                    <p class="nav-links"><img src="https://cdn2.iconfinder.com/data/icons/business-management-52/96/Artboard_20-512.png" style="width:25px; text-align: left; vertical-align: bottom;"><div id="profile"></div>
                    <li>
                        <p class="nav-links"><img src="https://cdn0.iconfinder.com/data/icons/cosmo-culture/40/books_1-512.png" style="width:25px; text-align: left; vertical-align: bottom;"> Library</p>
                    </li>
                    <!-- <li>
                        <p class="nav-links"><img src="https://image.flaticon.com/icons/png/512/130/130304.png" style="width:25px; text-align: left; vertical-align: bottom;"> Curriculums</p>
                    </li> -->
                    <li>
                        <p class="nav-links"><img src="https://cdn4.iconfinder.com/data/icons/money-13/24/Wallet-2-512.png" style="width:25px; vertical-align: bottom; text-align: left;"> Wallet</p>
                    </li>
                    <li>
                        <p class="nav-links"><img src="https://cdn1.iconfinder.com/data/icons/materia-arrows-symbols-vol-3/24/018_128_arrow_exit_logout-512.png" style="width:25px; text-align: left; vertical-align: bottom;"> Logout</p>
                    </li>
                </ul>
            </nav>
        </div>

        <div id="topics" class="content hidden">
            <table id="topics-table">
                <div>Topics</div>
                <tbody>
                </tbody>
            </table>
        </div>
    </body>
</html>
