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
            <jsp:include page="/view/css/pagination.css" />
            <jsp:include page="/view/css/modal.css" />
        </style>

        <script>
            function pageMove(page) {
                location.href = "/front/my-portfolio/?page=" + page;
            }
        </script>

    </head>
    <body>
        <div id="mySidenav" class="sidenav">
            <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
            <a href="${pageContext.request.contextPath}/front/" class="navItem">Main</a>
            <a href="${pageContext.request.contextPath}/front/portfolio-board/" class="navItem">Portfolio Board</a>
            <a href="${pageContext.request.contextPath}/front/my-page/" class="navItem">My page</a>
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
                    <h2>My Portfolio</h2>
                    <div class="cardBody" >

                        <c:forEach var="board" items="${boards}">
                        <div class="card">

                            <a href="/front/my-portfolio/delete/?id=${board.portfolioId}"><img class="cancel" src="/view/asset/cancel.png"></a>
                            <img src="/view/asset/typewriter-801921_1920.jpg">

                            <h1><a href="https://${board.link}">${board.title}</a></h1>
                            <div class="from">${board.creationDate}</div>

                        </div>
                        </c:forEach>


                </section>

                <p class="addMine" id="openBtn">글쓰기</p>
                <div id="modal">
                    <form method="POST" action="${pageContext.request.contextPath}/front/my-portfolio/write/">
                        <h1>포트폴리오 추가</h1>
                        <div>
                            <label for="title">제목</label>
                            <input type="text" id="title" name="title"></div>
                        <div>
                            <label for="link">링크</label>
                            <input type="text" id="link" name="link"></div>

                        <button onclick=getEle()>추가하기</button>
                    </form>
                    <a class="closeBtn"><img src="./asset/cancel.png"></a>
                </div>



                <ul class="pagination">
                    <li><a href="javascript:pageMove(${paging.firstPageNo})">맨앞으로</a></li>
                    <li><a href="javascript:pageMove(${paging.prevPageNo})">앞으로</a></li>
                    <c:forEach var="i" begin="${paging.startPageNo}" end="${paging.endPageNo}" step="1">
                        <c:choose>
                            <c:when test="${i eq paging.pageNo}">
                                <li class="active"><a href="javascript:pageMove(${i})">${i}</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="javascript:pageMove(${i})">${i}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <li><a href="javascript:pageMove(${paging.nextPageNo});">뒤로</a></li>
                    <li><a href="javascript:pageMove(${paging.finalPageNo});">맨뒤로</a></li>
                </ul>
            </article>

            <footer>WebProjectKIT</footer>

        </div>
        <script><jsp:include page="/view/script/main.js"/></script>
        <script><jsp:include page="/view/script/modal.js" /></script>
        <script><jsp:include page="/view/script/add.js" /></script>

    </body>
</html>