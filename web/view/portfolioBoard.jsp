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
        <jsp:include page="/view/css/cardview.css" />
        <jsp:include page="/view/css/modal.css" />
        <jsp:include page="/view/css/main.css" />
        <jsp:include page="/view/css/pagination.css" />
    </style>
    <script>
        function pageMove(page) {
            location.href = "/front/portfolio-board/?page=" + page;
        }
    </script>
</head>
<body>
<div id="mySidenav" class="sidenav">
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <a href="${pageContext.request.contextPath}/front/" class="navItem">Main</a>
    <a href="${pageContext.request.contextPath}/front/my-portfolio/" class="navItem">My Portfolio</a>
    <a href="${pageContext.request.contextPath}/front/my-page/" class="navItem">My page</a>
    <a href="https://github.com/WebProjectKIT" class="navItem" id="git">
        <img src="${pageContext.request.contextPath}/view/asset/git-squared.png"></a>

    <c:if test="${isLogin}">
        <a href="${pageContext.request.contextPath}/front/login/logout/" class="navItem">logout</a>

    </c:if>

    <c:if test="${!isLogin}">
        <a href="${pageContext.request.contextPath}/login/" class="navItem">login</a>
    </c:if>


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

            <div class="cardBody">
                <c:forEach var="board" items="${boards}">
                    <div class="card">
<%--                        <a href="/front/portfolio-board/bookmark/?id=${board.portfolioId}">--%>
                            <img class="star" src="${pageContext.request.contextPath}/view/asset/star_blank.png"
                                 onclick=addStar()>
<%--                        </a>--%>
                        <img src="${pageContext.request.contextPath}/view/asset/typewriter-801921_1920.jpg">
                        <h1><a href="/front/portfolio-board/detail/?id=${board.postingId}">${board.title}</a></h1>
                        <p>${board.creationDate}</p>
                        <p>${board.view}</p>
                        <div class="from">made BY ${board.email}</div>
                    </div>
                </c:forEach>
            </div>
        </section>

        <p class="addMine" id="openBtn">글쓰기</p>
        <div id="modal">
            <form method="POST" action="/front/portfolio-board/register/">
                <h1>글쓰기</h1>
                <div>
                    <label for="title">제목</label>
                    <input type="text" id="title" name="title"></div>
                <div class="form-group">
                    <label for="content">내용</label>
                    <textarea class="form-control" rows="10" id="content" name="content"></textarea>
                </div>
<%--                <div>--%>
<%--                    <label for="link">링크</label>--%>
<%--                    <input type="text" id="link" name="link">--%>
<%--                </div>--%>
                <label for="myPort">포트폴리오 선택</label>
                <select id="myPort" name="myPort" size="1">
                    <option value="">선택하세요.</option>
<%--                        <option value="학생">학생</option>--%>
                    <c:forEach var="myPortfolio" items="${myPortfolio}">
                        <option value="${myPortfolio.portfolioId}">${myPortfolio.portfolioId} : ${myPortfolio.title}</option>
                    </c:forEach>
                </select> <br> <br>

                <button onclick=getEle()>추가하기</button>
            </form>
            <a class="closeBtn"><img src="${pageContext.request.contextPath}/view/asset/cancel.png"></a>
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

<script>
    <jsp:include page="/view/script/main.js"/>
</script>
<script>
    <jsp:include page="/view/script/add.js"/>
</script>
<script>
    <jsp:include page="/view/script/modal.js"/>
</script>
</body>
</html>