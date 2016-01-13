<%@ page language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'login.jsp' starting page</title>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
        <link rel="stylesheet" type="text/css" href="styles.css">
        -->
    <script type="text/javascript">
        function _onRegister(elClicked) {
            try {

                var doc = document.loginform;
                doc.action = "./logon";
                doc.submit();
            } catch (e) {
                alert("failerd");
            }
        }
        function _onLogin(elClicked) {
            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;
            if (username == null || username == '') {
                alert('type your username!');
                return;
            }
            else if (password == null || password == '') {
                alert('type your password!');
                return;
            }
            try {

                elClicked.form.submit();
            } catch (e) {
                alert("failerd");
            }
        }

    </script>
</head>

<body>
<form action="./logon" name="loginform" method="post">
测试添加12345678912213123
    <label for="username">用户名</label> <input name="username" id="username"/>
    <label for="password">密码</label> <input name="password" id="password"
                                            type="password"/> <input type="button" value="Login"
                                                                     onClick="_onLogin(this);"/> <input type="button"
                                                                                                        name="register"
                                                                                                        value="Register"
                                                                                                        onClick="_onRegister(this);"/>
</form>
</body>
</html>
