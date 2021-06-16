function warnEmpty(){
    alert("내용이 비었습니다.");
}

function dateToString(date){
    const dateString = date.dateToString();
    const dateToString= dateString.substring(0,10) + " " + dateString.substring(11,19);
    return dateToString;
}

function submitComment(){
    const newcommentEL = document.getElementById("comment-add");
    const newcomment = newcommentEL.value;

    if(newcomment){
        const dateEL = document.createElement('div');
        dateEL.classList.add("comment-date");

        //실시간 시간 넣는 것은 동적인 거라서 백엔드에서 처리해줘야함
        // const dateString = dateToString(new Date());
        // dateEL.innerText=dateString;

        const contentEL = document.createElement('div');
        contentEL.classList.add('comment-content');
        contentEL.innerText = newcomment;

        const commentEL = document.createElement('div');
        commentEL.classList.add('comment-row');
        commentEL.appendChild(dateEL);
        commentEL.appendChild(contentEL);

        document.getElementById('comments').appendChild(commentEL);
        newcommentEL.value="";

        const countEL = document.getElementById('comment-count');
        const count = countEL.innerText;
        countEL.innerText = parseInt(count) + 1;
    }
    else warnEmpty();
}

function goBack() {
    window.history.back();
}