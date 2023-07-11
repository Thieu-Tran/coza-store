// Khi nội dung file html đã được hiển thị trên browser thì sẽ kích hoạt
$(document).ready(function(){
    
    // SIGN-IN
    // Đăng ký sự kiện click cho thẻ tag được chỉ định bên HTML
    $("#btn-sign-in").click(function(){
        // .val() : Lấy giá trị của thẻ input được chỉ định
        var username = $("#user").val()
        var password = $("#pass").val()

        //ajax : Dùng để call ngầm API mà không cần trình duyệt
        //data : chỉ có khi tham số truyền ngầm
        $.ajax({
            url: "http://localhost:8080/signin",
            method: "post",
            data: {
                email: username,
                password: password
            }
        }).done(function(result){
            let token = result.data
            if(token!=null && token!=""){
                localStorage.setItem("token",token)

                window.location.href="index.html"
            }else{
                alert("hello");
            }
        })
    })

    // SIGN-UP

    $("#btn-sign-up").click(function(){
        // .val() : Lấy giá trị của thẻ input được chỉ định
        var username = $("#user-signup").val()
        var password = $("#pass-signup").val()
        var passwordRepeat = $("#pass-repeat").val()
        var email = $("#email-signup").val()

        if(username!=""&&email!=""&&password!=""&&password===passwordRepeat){
            $.ajax({
                url: "http://localhost:8080/signup",
                method: "post",
                data: {
                    username: username,
                    password: password,
                    email: email
                }
            }).done(function(result){
                document.getElementById("user-signup").value=""
                document.getElementById("pass-signup").value=""
                document.getElementById("pass-repeat").value=""
                document.getElementById("email-signup").value=""

                document.getElementById("user-signup-wanring").innerHTML = ""
                alert("Success")
            })
        }else{
            if(password!==passwordRepeat){
                document.getElementById("user-signup-wanring").innerHTML = "password does not match"
            }else{
                document.getElementById("user-signup-wanring").innerHTML = "username, password, email cannot be left blank!"
            }
        }

    })
})

