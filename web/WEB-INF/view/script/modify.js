function changeSelect(){
    var Select = document.getElementById("user_phone1");
    const selectedValue = Select.options[Select.selectedIndex].value;
    const selectedText = Select.options[Select.selectedIndex].text;
}

function modifyEle() {
    if(document.modifyform.user_email.value == "") {
		alert("이메일을 입력하세요.");
		document.modifyform.user_address.focus();
		return;
	}
    if(document.modifyform.user_group.value == "") {
		alert("소속을 입력하세요.");
		document.modifyform.user_group.focus();
		return;
	}
    if(document.modifyform.user_phone2.value == "") {
		alert("전화번호를 입력하세요.");
		document.modifyform.user_phone.focus();
		return;
	}
    if(document.modifyform.user_address.value == "") {
		alert("주소를 입력하세요.");
		document.modifyform.user_address.focus();
		return;
	}

	let email = document.getElementById("user_email").value;
	let useremail = document.getElementById("useremail");
	useremail.innerHTML=email;
	let group = document.getElementById("user_group").value;
	let usergroup = document.getElementById("usergroup");	
	usergroup.innerHTML=group;
	let address = document.getElementById("user_address").value;
	let useraddress = document.getElementById("useraddress");
	useraddress.innerHTML=address;
	let phone2 = document.getElementById("user_phone2").value;
	let userphone2 = document.getElementById("userphone");
	userphone2.innerHTML= phone2;

	
	document.modifyform.submit();
    
}
