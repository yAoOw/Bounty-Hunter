function toRegister() {

    window.location.href = "user/toRegister";
}
function toLogin() {
    window.location.href = "/";
}

function toAdd() {
    var username = $("#userName").val();
    var password = $("#password").val();
    var rePassword = $("#rePassword").val();
    var phone = $("#phone").val();
    if (username == '') {
        swal("用户名不可为空");
        return false;
    }
    if (password != rePassword) {
        swal("两次输入密码不一致");
        return false;
    }
    if (phone == '') {
        swal("手机号不可以为空");
        return false;
    }
    var form = new FormData();
    form.append("userName", username);
    form.append("password", password);
    form.append("phone", phone);
    $.ajax({
        url: "doRegister",
        type: "post",
        data: form,
        processData: false,
        contentType: false,
        success: function (data) {
            console.log(data.info);
            if (data.code == 1) {
                swal("注册成功").then((value) => {
                    window.location.href = "/";
            });
            } else {
                swal("注册失败").then(()=>{
                    location.reload();
                });
            }
        },
    });
    // $("#registerForm").submit();

}

function doLogin() {
    var username = $("#userName").val();
    var password = $("#password").val();
    if (username == '' && password == '') {
        swal("用户名密码不可为空").then((value)=>{
            location.reload();
        });
    }
    var form = new FormData();
    form.append("userName",username);
    form.append("password",password);
    $.ajax({
        url: "user/doLogin",
        type: "post",
        data: form,
        processData: false,
        contentType: false,
        success:function (data) {
            if(data.code==1){
                swal("登录成功").then((value)=>{

                });
            }
        }

    })
}

function alerttest() {
    swal("1111").then((value)=>{
        window.location.href = "/";
    });
}