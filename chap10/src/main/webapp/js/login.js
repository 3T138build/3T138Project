
function form_submit() {
    var uname=$("#userCode").val();
    var pwd=$("#userPassword").val();
    if(pwd.trim().length<32){
        pwd=hex_md5(uname+hex_md5(pwd))
    }
    $("#userPassword").val(pwd);
    $("#actionForm").submit();
}
