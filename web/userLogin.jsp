<%--
  Created by IntelliJ IDEA.
  User: 我今天一定要早睡
  Date: 2020/6/23
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/jquery@3.4.1/dist/jquery.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <script src="https://lib.sinaapp.com/js/jquery/2.0.2/jquery-2.0.2.min.js"></script>

    <title>用户登录</title>
    <style>
        .bg {
            background: url('img/bg02.jpg');
            height: 790px;
            text-align: center;
            line-height: 800px;
        }
        .bg-blur {
            float: left;
            width: 100%;
            background-repeat: no-repeat;
            background-position: center;
            background-size: cover;
            -webkit-filter: blur(15px);
            -moz-filter: blur(15px);
            -o-filter: blur(15px);
            -ms-filter: blur(15px);
            filter: blur(15px);
        }
        .content-front {
            position:absolute;
        }
    </style>

</head>
<body>
<div class="bg bg-blur"></div>
<div class="content-front container-fluid">
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <h1 class="display-4" style="margin-top: 100px; text-align: center; color: gainsboro">用户登录</h1>
            <form action="${pageContext.request.contextPath}/UserLoginServlet" method="post" style="margin-top: 50px; color: gainsboro" >
                <div class="form-group">
                    <label for="username">用户名</label>
                    <input type="text"  class="form-control" id="username" name="username" placeholder="请输入用户名" style="background-color: transparent; color: gainsboro" aria-describedby="emailHelp">
                </div>
                <div class="form-group">
                    <label for="password">密码</label>
                    <input type="password"  name="password" class="form-control" placeholder="请输入密码" style="background-color: transparent; color: gainsboro" id="password">
                </div>


                <hr class="my-4">
                <a href="userRegister.jsp" style="color: gainsboro;text-align: center">还没有账号？立即注册</a><br>
                <button type="submit" class="btn btn-primary-outline btn-lg border rounded-pill" style="color: gainsboro; margin-left: 40%; margin-top: 50px">登录</button>
                <p style="text-align: center; color: gainsboro; margin-top: 15px;">${requestScope.loginMsg}</p>
            </form>
        </div>
    </div>
</div>