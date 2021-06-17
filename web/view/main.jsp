<%@page import="java.util.List"%>
<%@taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
            <jsp:include page="/view/css/navi.css" />
            <jsp:include page="/view/css/main.css" />
            <jsp:include page="/view/css/cardview.css" />
        </style>
    </head>
    <body>

        <div id="mySidenav" class="sidenav">
            <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>

            <a href="${pageContext.request.contextPath}/front/my-page/" class="navItem">My page</a>
            <a href="${pageContext.request.contextPath}/front/my-portfolio/" class="navItem">My Portfolio</a>
            <a href="${pageContext.request.contextPath}/front/portfolio-board/" class="navItem">Portfolio Board</a>

            <c:if test = "${isLogin}">
                <a href="${pageContext.request.contextPath}/front/login/logout/" class="navItem">logout</a>
            </c:if>
            <c:if test = "${!isLogin}">
                <a href="${pageContext.request.contextPath}/login/" class="navItem">login</a>
            </c:if>


            <a href="https://github.com/WebProjectKIT" class="navItem" id="git">
                <img src="${pageContext.request.contextPath}/view/asset/git-squared.png"></a>
        </div>

        <div id="main">
            <span onclick="openNav()">&#9776;
            </span>
            <header>

                <img src="${pageContext.request.contextPath}/view/asset/typewriter-801921_1920.jpg">
            </header>

            <article>
                <section>
                    <h2>My Portfolio</h2>
                    <p>마이 포트폴리오</p>
                    <div id="cardBody1">
                        <div class="card">
                            <img class="star" src="${pageContext.request.contextPath}/view/asset/star_blank.png"  onclick=addStar()>
                            <img src="${pageContext.request.contextPath}/view/asset/typewriter-801921_1920.jpg">
                            <h1>Project1</h1>
                            <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. In quo perferendis
                                placeat fuga voluptatem. Itaque, in! Quos debitis similique sunt? Non tempora
                                iste libero quidem aliquid molestiae commodi omnis eum!</p>
                            <div class="from">made BY HJ</div>
                        </div>
                    </div>
                    <a href="${pageContext.request.contextPath}/front/my-portfolio/">
                        <p class="seeMore">더보기</p>
                    </a>
                </section>
                <section>
                    <h2>Portfolio</h2>
                    <p>포트폴리오 게시판</p>
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
                    <a href="${pageContext.request.contextPath}/front/portfolio-board">
                        <p class="seeMore">더보기</p>
                    </a>
                </section>
            </article>

            <footer>WebProjectKIT</footer>

        </div>

        <script><jsp:include page="/view/script/main.js" /></script>
        <script><jsp:include page="/view/script/add.js" /></script>
    </body>
</html>