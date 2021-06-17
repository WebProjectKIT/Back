function getEle() {
    let cardBody = document.getElementById("cardBody");

    let title = document
        .getElementById("title")
        .value;
    let about = document
        .getElementById("about")
        .value;

    let newDiv = document.createElement('div');
    let newH1 = document.createElement('h1');
    let newP = document.createElement('p');
    let newWho = document.createElement('div');
    let img = document.createElement('img');
    let starImg = document.createElement('img');
    let cancelImg = document.createElement('img');

    img.setAttribute("src", "/view/asset/typewriter-801921_1920.jpg");

    starImg.setAttribute("src", "/view/asset/star_blank.png");
    starImg
        .classList
        .add("star");
    starImg.onclick = addStar;

    cancelImg.setAttribute("src", "/view/asset/cancel.png");
    cancelImg
        .classList
        .add("cancel");
    cancelImg.onclick = cancel;

    let addTitle = document.createTextNode(title);
    newH1.appendChild(addTitle);

    let addAbout = document.createTextNode(about);
    newP.appendChild(addAbout);

    let addWho = document.createTextNode('made BY Who');
    newWho.appendChild(addWho);
    newWho
        .classList
        .add("from");

    newDiv
        .classList
        .add("card");
    newDiv.append(starImg);
    newDiv.append(cancelImg);
    newDiv.append(img);
    newDiv.append(newH1);
    newDiv.append(newP);
    newDiv.append(newWho);
    cardBody.appendChild(newDiv);
}

function cancel() {
    let target = event.currentTarget.parentNode;
    target.remove();
}

function addStar() {
    let target = event.currentTarget;

    //img src로 판단하는 것인데 기준을 좀 더 생각해봐야할 듯
    tmp = "http://localhost:" + location.port + "/view/asset/star.png"

    if (target.src === tmp) {
        target.src = "/view/asset/star_blank.png";
    } else {
        target.src = "/view/asset/star.png";
    }
}