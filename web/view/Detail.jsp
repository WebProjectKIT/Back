<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="./css/navi.css">
        <link rel="stylesheet" href="./css/main.css">
        <link rel="stylesheet" href="./css/pagination.css">
        <link rel="stylesheet" href="./css/detail.css">
    </head>
    <body>
        <div id="mySidenav" class="sidenav">
            <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
            <a href="main.jsp" class="navItem">Main</a>
            <a href="myPortfolio.jsp" class="navItem">My Portfolio</a>
            <a href="profile.jsp" class="navItem">My page</a>
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
                <section class = "detail-design">
                    <h2>Project1</h2>
                    <div class = "content-info">
                    작성자 <span>어쩌고저쩌고</span></p>
                    작성시간 <span>2021-06-15 14:18</span>
                    </div>
                    <div id = "content">
                    <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Nisi aliquam natus
                        provident voluptates deleniti, deserunt alias nam similique porro nostrum
                        asperiores maxime voluptatibus odit possimus nesciunt recusandae veniam
                        aspernatur? Hic.</p>
                    </div>
                    <div id = "comments">
                        <div id = "comment-head" class="comment-row">
                            comments (<span id = "comment-count">1</span>)
                        </div>
                        <div class = "comment-row">
                            <div>
                            <textarea id = "comment-add" name = "comment-add" row = 4></textarea>
                            <button onclick="submitComment()" type="submit" class="submitBtn">작성</button>  
                            </div>   
                            <div class = "comment-row">
                                <div class = "comment-date">2020-06-15 17:10</div>
                                <div class="comment-content">ddddddddddddddddddddddddddddddddddddddddddddddddddddddㅁㄴㄻㄴㄹㅇㅇㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴ</div>
                            </div>
                            <div class = "comment-row">
                                <div class = "comment-date">2020-06-15 17:10</div>
                                <div class="comment-content">아과제하기진짜싫다</div>
                            </div>
                            <div class = "comment-row">
                                <div class = "comment-date">2020-06-15 17:10</div>
                                <div class="comment-content">아과제하기진짜싫다</div>
                            </div>
                        </div>
                    </div>
                   
                </section>
                <div class = "back">
                <button class ="back_btn" onclick="goBack()">이전 페이지</button>
            </div>
            </article>

            <footer>WebProjectKIT</footer>

        </div>
        <script src="./script/detail.js"></script>
        <script src="./script/main.js"></script>
    </body>
</html>