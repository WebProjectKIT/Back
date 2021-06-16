<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="./css/navi.css">
        <link rel="stylesheet" href="./css/main.css">
        <link rel="stylesheet" href="./css/cardview.css">
        <link rel="stylesheet" href="./css/pagination.css">
        <link rel="stylesheet" href="./css/modal.css">
        <link rel="stylesheet" href="./css/mypage.css">
    </head>
    <body>
        <div id="mySidenav" class="sidenav">
            <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
            <a href="main.jsp" class="navItem">Main</a>
            <a href="seeAll.jsp" class="navItem">All Portfolio</a>
            <a href="./profile.jsp" class="navItem">My page</a>
            <a href="https://github.com/WebProjectKIT" class="navItem" id="git">
                <img src="asset/git-squared.png"></a>
        </div>
        <div id="main">
            <span onclick="openNav()">&#9776;
            </span>
            <header>
                <img src="asset/typewriter-801921_1920.jpg">
            </header>
    
            <article>
                <section>
                    <h2>My Page</h2>
                    <div class = "profile_background">
                        <ul class ="profile_list">
                            <li class = "myinfo_index">
                                <h3 id ="info_title">아이디</h3>
                                <div id = "pageinfo">helloworld</div>
                            </li>
                            <li class = "myinfo_index">
                                <h3 id ="info_title">이메일</h3>
                                <div id = "pageinfo"><span id = useremail>suminlee2323@gmail.com</span></div>
                            </li>
                            <li class = "myinfo_index">
                                <h3 id ="info_title">소속</h3>
                                <div id = "pageinfo"><span id = usergroup>금오공과대학교 컴퓨터공학과</span></div>
                            </li>
                            <li class = "myinfo_index">
                                <h3 id ="info_title">전화번호</h3>
                                <div id = "pageinfo"><span id = userphone>010 - 1234 - 4567</span></div>
                            </li>
                            <li class = "myinfo_index">
                                <h3 id ="info_title">주소</h3>
                                <div id = "pageinfo"><span id = useraddress>경상북도 구미시 거의동 양호동</span></div>
                            </li>
                        </ul>
                    </div>
                </section>
                <section>
                    <h2>Favorites</h2>
                    <a href="seeAll.jsp">
                        <p class="seeMore">더보기</p>
                    </a>
                    <div id="cardBody">
                        <div class="card">
                            <img class="star" src="asset/star_blank.png" onclick=addStar()>
                            <img class="cancel" src="asset/cancel.png" onclick=cancel()>
                            <img src="asset/typewriter-801921_1920.jpg">
                            <h1>Project1</h1>
                            <p>어떻게 밑으로 내리지 아아아아아아ㅏ아아아아아아아</p>
                            <div class="from">made BY HJ</div>
                        </div>
                        <div class="card">
                            <img class="star" src="asset/star_blank.png" onclick=addStar()>
                            <img class="cancel" src="asset/cancel.png" onclick=cancel()>
                            <img src="asset/typewriter-801921_1920.jpg">
                            <h1>Project2</h1>
                            <p>어떻게 밑으로 내리지 아아아아아아ㅏ아아아아아아아</p>
                            <div class="from">made BY HJ</div>
                            </div>
                </section>
            </article>
            <footer>WebProjectKIT</footer>
        </div>
        <script src="./script/main.js"></script>
        <script src="./script/modal.js"></script>
        <script src="./script/modify.js"></script>
        <script src="./script/add.js"></script>
    </body>
</html>