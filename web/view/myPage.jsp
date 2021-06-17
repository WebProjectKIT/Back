<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <a href="${pageContext.request.contextPath}/front/" class="navItem">Main</a>
            <a href="${pageContext.request.contextPath}/front/my-portfolio/" class="navItem">My Portfolio</a>
            <a href="${pageContext.request.contextPath}/front/portfolio-board/" class="navItem">Portfolio Board</a>
            <a href="https://github.com/WebProjectKIT" class="navItem" id="git">
                <img src="/view/asset/git-squared.png"></a>


            <a href="${pageContext.request.contextPath}/front/login/logout/" class="navItem">logout</a>


        </div>
        <div id="main">
            <span onclick="openNav()">&#9776;
            </span>
            <header>
                <img src="/view/asset/typewriter-801921_1920.jpg">
            </header>
    
            <article>
                <section>
                    <h2>My Page</h2>
                    <div class = "profile_background">
                        <ul class ="profile_list">
                            <li class = "myinfo_index">
                                <h3 id ="info_title">이메일</h3>
                                <div id = "pageinfo"><span id = userEmail>${member.email}</span></div>
                            </li>
                            <li class = "myinfo_index">
                                <h3 id ="info_title">이름</h3>
                                <div id = "pageinfo"><span id = userName>${member.name}</span></div>
                            </li>
                            <li class = "myinfo_index">
                                <h3 id ="info_title">전화번호</h3>
                                <div id = "pageinfo"><span id = userPhoneNumber>${member.phoneNumber}</span></div>
                            </li>
                        </ul>
                    </div>
                </section>

                <section>
                    <h2>Favorite</h2>
                    <div id="cardBody">
                        <c:forEach var="board" items="${boards}">
                            <div class="card">
                                <img class="star" src="${pageContext.request.contextPath}/view/asset/star_blank.png" onclick=addStar()>
                                <img src="${pageContext.request.contextPath}/view/asset/typewriter-801921_1920.jpg">
                                <h1>${board.title}</h1>
                                <p>${board.creationDate}</p>
                                <p>${board.view}</p>
                                <div class="from">made BY ${board.email}</div>
                            </div>
                        </c:forEach>
                    </div>
                    <a href="${pageContext.request.contextPath}/front/portfolio-board/">
                        <p class="seeMore">더보기</p>
                    </a>

                </section>

            </article>

            <footer>WebProjectKIT</footer>


        <script><jsp:include page="/view/script/main.js"/></script>
        <script><jsp:include page="/view/script/modal.js" /></script>
        <script><jsp:include page="/view/script/modify.js" /></script>
        <script><jsp:include page="/view/script/add.js" /></script>

    </body>
</html>