<%--
  Created by IntelliJ IDEA.
  User: 我今天一定要早睡
  Date: 2020/6/22
  Time: 11:46
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

    <title>欢迎使用药店管理系统</title>
    <script>
        window.onload = getTime;
        function getTime() {
            var d = document.getElementById('time');
            var date = new Date();
            var year = date.getFullYear();    //获取当前年份
            var mon = date.getMonth() + 1;      //获取当前月份
            var day = date.getDate();          //获取当前日
            var h = date.getHours();
            if (h < 10)
                h = "0"+h;
            var m = date.getMinutes();
            if (m < 10)
                m = "0"+m;//获取分钟
            var s = date.getSeconds();
            if (s < 10)
                s = "0"+s;//获取秒
            d.innerHTML = '现在的时间是 : ' + year + '年' + mon + '月' + day + '日' + h + ':' + m + ':' + s;
        }
        setInterval(getTime, 1000);
    </script>

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
        <div style="margin-top: 150px; margin-left: 220px; ">
            <h1 class="display-3" style="color:gainsboro">${sessionScope.time},${sessionScope.managerInfo.managerName}</h1>
            <p class="lead" id="time" style="color: gainsboro; margin-top: 30px">现在的时间是:</p>
            <hr class="my-4 "style="margin-top: 30px; ">
            <p class="lead" style="color: gainsboro">欢迎使用药店管理系统，请选择宁的操作</p>
            <div style="margin-top: 100px">
                <a class="btn btn-primary-outline btn-lg border rounded-pill" href="${pageContext.request.contextPath}/FindAllMedicineServlet?currentPage=1&rows=5" role="button" style="margin-left: 155px; color: gainsboro">查看库存</a>
                <a class="btn btn-primary-outline btn-lg border rounded-pill" href="${pageContext.request.contextPath}/addMedicine.jsp" role="button" style="margin-left: 100px; color: gainsboro">我要进货</a>
                <a class="btn btn-primary-outline btn-lg border rounded-pill" href="${pageContext.request.contextPath}/FindAllUserServlet?currentPage=1&rows=5" role="button" style="margin-left: 100px; color: gainsboro">查看用户信息</a>
                <a class="btn btn-primary-outline btn-lg border rounded-pill" href="${pageContext.request.contextPath}/CheckManagerOrderServlet" role="button" style="margin-left: 100px; color: gainsboro">查看用户订单</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>