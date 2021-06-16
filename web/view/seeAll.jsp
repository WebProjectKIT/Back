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
                <section>
                    <h2>Portfolio</h2>
                    <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Nisi aliquam natus
                        provident voluptates deleniti, deserunt alias nam similique porro nostrum
                        asperiores maxime voluptatibus odit possimus nesciunt recusandae veniam
                        aspernatur? Hic.</p>
                    <div id="cardBody">
                        <div class="card">
                            <img class="star" src="asset/star_blank.png" onclick=addStar()>
                            <img src="asset/typewriter-801921_1920.jpg">
                            <h1>Project1</h1>
                            <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. In quo perferendis
                                placeat fuga voluptatem. Itaque, in! Quos debitis similique sunt? Non tempora
                                iste libero quidem aliquid molestiae commodi omnis eum!</p>
                            <div class="from">made BY HJ</div>
                        </div>
                    </div>
                </section>
                <div class="pagination">
                    <span><img src="./asset/arrow-down-sign-to-navigate.png" class="arrow" id="leftArr"></span>
                    <span>1</span>
                    <span>2</span>
                    <span>3</span>
                    <span>4</span>
                    <span>5</span>
                    <span>1</span>
                    <span>2</span>
                    <span>3</span>
                    <span>4</span>
                    <span>5</span>
                    <span><img src="./asset/arrow-down-sign-to-navigate.png" class="arrow" id="rightArr"></span>
                </div>
            </article>

            <footer>WebProjectKIT</footer>

        </div>

        <script src="./script/main.js"></script>
        <script src="./script/add.js"></script>
    </body>
</html>