var index = {
    login:function (accountNameDom,passwordDom) {
        var accountName = accountNameDom.val();
        var password = passwordDom.val();
        if(accountName == ""){
            $("#loginStatus").html("请输入账户名！");
            return;
        }
        if(password == ""){
            $("#loginStatus").html("请输入密码！");
            return;
        }
        //后台登陆验证
        $.ajax({
            type: 'post',
            url: _ctxPath + "/login/doLogin",
            data: {
                accountName:accountName,
                password:password
            },
            success:function (data) {
                console.log(data);
                if(data.status == "Fail"){
                    $("#loginStatus").html(data.message);
                }else{
                    console.log(data.data);
                    window.top.location.href = _ctxPath + "/login/toMain"
                }
            },
            error:function () {
            }
        });
    }
}