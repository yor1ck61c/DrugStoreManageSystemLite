<%--
  Created by IntelliJ IDEA.
  User: 我今天一定要早睡
  Date: 2020/6/22
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <title>药品信息</title>
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
<div class="content-front"><h1 class="display-4" style="margin-top: 100px; margin-left: 600px; color: gainsboro">查看用户订单</h1></div>
<div class="content-front container">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-8">
            <table class="table table-bordered" style="margin-top: 220px;margin-left: 100px; text-align:center;color: gainsboro">
                <thead>
                <tr>
                    <th scope="col">用户名</th>
                    <th scope="col">药品名称</th>
                    <th scope="col">订购数量</th>
                    <th scope="col">电话号码</th>
                    <th scope="col">收货地址</th>
                    <th scope="col">操作</th>
                </tr>
                </thead>
                <c:forEach items="${requestScope.managerOrder.items}" var="order">
                    <tbody>
                    <tr>
                        <th scope="row">${order.username}</th>
                        <td>${order.medicine_name}</td>
                        <td>${order.medicine_num}</td>
                        <td>${order.phoneNum}</td>
                        <td>${order.address}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/DeleteOrderServlet?id=${order.id}" style="color: gainsboro; ">已发货</a>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
            <a href="managerSuccessLogin.jsp" class="btn btn-primary-outline btn-lg border rounded-pill" style="color: gainsboro; margin-left: 430px; margin-top: 10px">返回</a>
        </div>
    </div>

</div>
</body>
</html>