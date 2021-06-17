<%@page import="java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>

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

    <c:if test="${isLogin}">
        <a href="${pageContext.request.contextPath}/front/login/logout/" class="navItem">logout</a>
    </c:if>
    <c:if test="${!isLogin}">
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
            <c:if test="${isLogin}">
                <h2>My Portfolio</h2>
                <p>마이 포트폴리오</p>
                <p>내가 쓴글</p>
                <div class="cardBody">
                    <c:forEach var="myPortolioBoard" items="${myPortolioBoard}">
                        <div class="card">
                            <img src="${pageContext.request.contextPath}/view/asset/typewriter-801921_1920.jpg">
                            <h1><a href="/front/portfolio-board/detail/?id=${myPortolioBoard.postingId}">${myPortolioBoard.title}</a></h1>
                            <p>${myPortolioBoard.creationDate}</p>
                            <p>${myPortolioBoard.view}</p>
                            <div class="from">made BY ${myPortolioBoard.email}</div>
                        </div>
                    </c:forEach>
                </div>
                <a href="${pageContext.request.contextPath}/front/my-portfolio/">
                    <p class="seeMore">더보기</p>
                </a>
            </c:if>

            <c:if test="${!isLogin}">
                <div>
                    <h1 style="text-align: center; margin-bottom: 20px">웹프로그래밍 텀프로젝트</h1>
                    <div class="intro">
                        <div style="padding: 0 40px">
                            <p>Front-End</p>
                            <p>20180847 이수민</p>
                            <p>20180982 이효진</p>
                        </div>
                        <div style="padding: 0 40px">
                            <p>Back-End</p>
                            <p>20170210 김승형</p>
                            <p>20170499 박진우</p>
                        </div>
                    </div>
                </div>

            </c:if>


        </section>
        <section>
            <h2>Portfolio</h2>
            <p>포트폴리오 게시판</p>
            <div class="cardBody">
                <c:forEach var="board" items="${boards}">
                    <div class="card">
                        <img src="${pageContext.request.contextPath}/view/asset/typewriter-801921_1920.jpg">
                        <h1><a href="/front/portfolio-board/detail/?id=${board.postingId}">${board.title}</a></h1>
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

</div>

<script>
    <jsp:include page="/view/script/main.js"/>
</script>
<script>
    <jsp:include page="/view/script/add.js"/>
</script>
</body>
</html>