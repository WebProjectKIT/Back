function check()
{
    var form = document.loginform;

    if (form.user_id.value == "")
    {
       alert("아이디를 입력해야 합니다!");
        form.user_id.focus();
        return;
    }

    if (form.pass_id.value == "")
    {
       alert("패스워드를 입력 해야 합니다!");
        form.pass_id.focus();
        return;
    }

   form.submit();
   }