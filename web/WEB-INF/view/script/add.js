function getEle() {
    let cardBody = document.getElementById("cardBody");

    let title = document.getElementById("title").value;
    let about = document.getElementById("about").value;

    let newDiv = document.createElement('div');
    let newH1 = document.createElement('h1');
    let newP = document.createElement('p');
    let newWho = document.createElement('div');
    let img = document.createElement('img');
    let starImg = document.createElement('img');

    img.setAttribute("src","asset/typewriter-801921_1920.jpg");
    
    starImg.setAttribute("src", "asset/star_blanks.png");
    starImg.classList.add("star");

    let addTitle = document.createTextNode(title);
    newH1.appendChild(addTitle);

    let addAbout = document.createTextNode(about);
    newP.appendChild(addAbout);

    let addWho = document.createTextNode('made BY Who');
    newWho.appendChild(addWho);
    newWho.classList.add("from");

    newDiv.classList.add("card");
    newDiv.append(starImg);
    newDiv.append(img);
    newDiv.append(newH1);
    newDiv.append(newP);
    newDiv.append(newWho);
    cardBody.appendChild(newDiv);
}

function cancel() {
    
}