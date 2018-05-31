function toRegister() {

    window.location.href="user/torRegister";
}

function toAdd() {
    var username = $("#username").val();
    var password = $("#password").val();
    var repassword = $("#rePassword").val();
    if(username ==''){
        alert("用户名不可为空");
        return ;
    }
    if(password != repassword){
        return ;
    }
    $("#registerForm").submit();

}