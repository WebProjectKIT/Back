<jsp:useBean id="post" scope="request" type="domain.PortfolioBoard"/>
<jsp:setProperty name="post" property="*"/>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>

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
    <a href="main.jsp" class="navItem">Main</a>
    <a href="myPortfolio.jsp" class="navItem">My Portfolio</a>
    <a href="myPage.jsp" class="navItem">My page</a>
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
                        <form method="post" action="/front/portfolio-board/comment-register">
                            <textarea id="comment-add" name="comment-add" row=4></textarea>
                            <button onclick="submitComment()" type="submit" class="submitBtn">작성</button>
                        </form>
                    </div>
                    <div class="comment-row">
                        <div class="comment-date">2020-06-15 17:10</div>
                        <div class="comment-content">
                            ddddddddddddddddddddddddddddddddddddddddddddddddddddddㅁㄴㄻㄴㄹㅇㅇㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴ
                        </div>
                    </div>
                    <div class="comment-row">
                        <div class="comment-date">2020-06-15 17:10</div>
                        <div class="comment-content">아과제하기진짜싫다</div>
                    </div>
                    <div class="comment-row">
                        <div class="comment-date">2020-06-15 17:10</div>
                        <div class="comment-content">아과제하기진짜싫다</div>
                    </div>
                </div>
            </div>

        </section>
        <div class="back">
            <button class="back_btn" onclick="goBack()">이전 페이지</button>
            <form method="post" action="/front/portfolio-board/delete?id=${post.postingId}">
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