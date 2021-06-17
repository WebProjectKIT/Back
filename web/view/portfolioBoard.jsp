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
            <jsp:include page="/view/css/cardview.css" />
            <jsp:include page="/view/css/cardview.css" />
            <jsp:include page="/view/css/pagination.css" />
        </style>
    </head>
    <body>
        <div id="mySidenav" class="sidenav">
            <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
            <a href="${pageContext.request.contextPath}/front/main" class="navItem">Main</a>
            <a href="${pageContext.request.contextPath}/front/my-portfolio" class="navItem">My Portfolio</a>
            <a href="${pageContext.request.contextPath}/front/my-page" class="navItem">My page</a>
            <a href="https://github.com/WebProjectKIT" class="navItem" id="git">
                <img src="${pageContext.request.contextPath}/view/asset/git-squared.png"></a>
        </div>

        <div id="main">
            <span onclick="openNav()">&#9776;
            </span>
            <header>
<%--                <img src="${pageContext.request.contextPath}/view/asset/typewriter-801921_1920.jpg">--%>
            </header>

            <article>
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
                </section>

                <p class="addMine" id="openBtn">글쓰기</p>
                <div id="modal">
                    <form method="POST">
                    <h1>포트폴리오 추가</h1>
                    <div>
                        <label for="title">제목</label>
                        <input type="text" id="title" name="title"></div>
                    <div class="form-group">
                        <label for="content">내용</label>
                        <textarea class="form-control" rows="10" id="content" name="content"></textarea>
                    </div>
                    <div>
                        <label for="link">링크</label>
                        <input type="text" id="link" name="link"></div>
                    <div>
                        <label for="about">설명</label>
                        <input type="text" id="about" name="about"></div>
                    <button onclick=getEle()>추가하기</button>
                    </form>
                    <a class="closeBtn"><img src="./asset/cancel.png"></a>
                </div>

                <div class="pagination">
                    <span><img src="${pageContext.request.contextPath}/view/asset/arrow-down-sign-to-navigate.png" class="arrow" id="leftArr"></span>
                    <span>1</span>
                    <span>2</span>
                    <span>3</span>
                    <span>4</span>
                    <span>5</span>
                    <span><img src="${pageContext.request.contextPath}/view/asset/arrow-down-sign-to-navigate.png" class="arrow" id="rightArr"></span>
                </div>
            </article>

            <footer>WebProjectKIT</footer>

        </div>

        <script><jsp:include page="/view/script/main.js" /></script>
        <script><jsp:include page="/view/script/add.js" /></script>
        <script><jsp:include page="/view/script/modal.js" /></script>
    </body>
</html>