<jsp:useBean id="post" scope="request" type="domain.PortfolioBoard"/>
<%--<jsp:useBean id="comment" scope="request" type="domain.Comments" />--%>
<jsp:setProperty name="post" property="*"/>
<%--<jsp:setProperty name="comment" property="*" />--%>

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
        <jsp:include page="/view/css/pagination.css" />
        <jsp:include page="/view/css/detail.css" />
    </style>
</head>
<body>
<div id="mySidenav" class="sidenav">

    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>

    <a href="${pageContext.request.contextPath}/front/" class="navItem">Main</a>
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
        <img src="/view/asset/git-squared.png"></a>


</div>

<div id="main">
            <span onclick="openNav()">&#9776;
            </span>
    <header>
        <%--                <img src="/view/asset/typewriter-801921_1920.jpg">--%>
    </header>

    <article>
        <section class="detail-design">
            <h2>${post.title}</h2>
            <div class="content-info">
                작성자 <span>${post.email}</span></p>
                작성시간 <span>${post.creationDate}</span>
                조회수 <span>${post.view}</span>
            </div>
            <div id="content">
                <p>${post.contents}</p>
            </div>
            <div id="comments">

                <div id="comment-head" class="comment-row">
                    comments (<span id="comment-count">1</span>)
                </div>
                <div class="comment-row">
                    <div>
                        <form id="comment-form" method="post" action="/front/portfolio-board/comment-register/?id=${post.postingId}">
                            <textarea id="comment-add" name="content" row=4 form="comment-form"></textarea>
                            <button onclick="submitComment()" type="submit" class="submitBtn">작성</button>
                        </form>
                    </div>
                    <c:forEach var="comment" items="${comments}">
                        <div class="comment-row">
                            <div class="comment-date">${comment.creationDate}</div>
                            <div>작성자 : ${comment.email}</div>
                            <div class="comment-content">
                                ${comment.contents}
                            </div>
                            <c:if test = "${comment.email == member.email}">
                                <form method="post" action="/front/portfolio-board/comment-delete/?id=${comment.commentId}">
                                    <button class="back_btn">삭제</button>
                                </form>
                            </c:if>



                        </div>
                    </c:forEach>
                </div>
            </div>

        </section>
        <div class="back">
            <button class="back_btn" onclick="goBack()">이전 페이지</button>

            <c:if test = "${checkBookMark}">
            <form method="post" action="/front/bookmark/delete/?id=${post.postingId}">
                <button class="back_btn">즐겨찾기 제거</button>
            </form>
            </c:if>

            <c:if test = "${!checkBookMark}">
                <form method="post" action="/front/bookmark/insert/?id=${post.postingId}">
                    <button class="back_btn">즐겨찾기 추가</button>
                </form>
            </c:if>

            <form method="post" action="/front/portfolio-board/delete/?id=${post.postingId}">
                <button class="back_btn">삭제</button>
            </form>
        </div>
    </article>

    <footer>WebProjectKIT</footer>

</div>

<script>
    <jsp:include page="/view/script/detail.js"/>
</script>
<script>
    <jsp:include page="/view/script/main.js"/>
</script>
</body>
</html>