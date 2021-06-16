<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
            <jsp:include page="/view/css/navi.css" />
            <jsp:include page="/view/css/main.css" />
            <jsp:include page="/view/css/cardview.css" />
            <jsp:include page="/view/css/modal.css" />
            <jsp:include page="/view/css/login.css" />
            <jsp:include page="/view/css/pagination.css" />
        </style>
    </head>
    <body>
        <div id="mySidenav" class="sidenav">
            <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
            <a href="main.jsp" class="navItem">Main</a>
            <a href="portfolioBoard.jsp" class="navItem">All Portfolio</a>
            <a href="profile.jsp" class="navItem">My page</a>
            <a href="https://github.com/WebProjectKIT" class="navItem" id="git">
                <img src="/view/asset/git-squared.png"></a>
        </div>
        <div id="main">
            <span onclick="openNav()">&#9776;
            </span>
            <header>
                <img src="/view/asset/typewriter-801921_1920.jpg">
            </header>
            <article>
                <section class="login-input-section-wrap">
                    <form name = loginform method = post action="/front/login/">
                    <div class = "login_input">
                        <span>아이디</span>
                        <div class="login-input-wrap">	
                            <input type="text" name="email" placeholder="Username" type="text">
                        </div>
                    </div>
                    <div class = "login_input">
                    <span>비밀번호</span>
                        <div class="login-input-wrap password-wrap">	
                            <input type="password" name="password" placeholder="Password" type="password"></input>
                        </div>
                    </div>
                    <button onclick="check()" class="loginBtn">Login</button>
                    </form>
                </section>
            </article>
            <footer>WebProjectKIT</footer>
        </div>
        <script><jsp:include page="/view/script/main.js"/></script>
        <script><jsp:include page="/view/script/modal.js" /></script>
        <script><jsp:include page="/view/script/login.js" /></script>
    </body>
</html>