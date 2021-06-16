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
                                <h3 id ="info_title">���̵�</h3>
                                <div id = "pageinfo">helloworld</div>
                            </li>
                            <li class = "myinfo_index">
                                <h3 id ="info_title">�̸���</h3>
                                <div id = "pageinfo"><span id = useremail>suminlee2323@gmail.com</span></div>
                            </li>
                            <li class = "myinfo_index">
                                <h3 id ="info_title">�Ҽ�</h3>
                                <div id = "pageinfo"><span id = usergroup>�ݿ��������б� ��ǻ�Ͱ��а�</span></div>
                            </li>
                            <li class = "myinfo_index">
                                <h3 id ="info_title">��ȭ��ȣ</h3>
                                <div id = "pageinfo"><span id = userphone>010 - 1234 - 4567</span></div>
                            </li>
                            <li class = "myinfo_index">
                                <h3 id ="info_title">�ּ�</h3>
                                <div id = "pageinfo"><span id = useraddress>���ϵ� ���̽� ���ǵ� ��ȣ��</span></div>
                            </li>
                        </ul>
                    </div>
                </section>
                <section>
                    <h2>Favorites</h2>
                    <a href="seeAll.jsp">
                        <p class="seeMore">������</p>
                    </a>
                    <div id="cardBody">
                        <div class="card">
                            <img class="star" src="asset/star_blank.png" onclick=addStar()>
                            <img class="cancel" src="asset/cancel.png" onclick=cancel()>
                            <img src="asset/typewriter-801921_1920.jpg">
                            <h1>Project1</h1>
                            <p>��� ������ ������ �ƾƾƾƾƾƤ��ƾƾƾƾƾƾ�</p>
                            <div class="from">made BY HJ</div>
                        </div>
                        <div class="card">
                            <img class="star" src="asset/star_blank.png" onclick=addStar()>
                            <img class="cancel" src="asset/cancel.png" onclick=cancel()>
                            <img src="asset/typewriter-801921_1920.jpg">
                            <h1>Project2</h1>
                            <p>��� ������ ������ �ƾƾƾƾƾƤ��ƾƾƾƾƾƾ�</p>
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