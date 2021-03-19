<%--
  Created by IntelliJ IDEA.
  User: 我今天一定要早睡
  Date: 2020/6/22
  Time: 14:11
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

    <title>新增药品结果</title>

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
    <script type="text/javascript">

        var x=3; //利用了全局变量来执行
        function go(){
            x--;
            if(x>0){
                document.getElementById("jumpToIndex").innerHTML= x+"秒后返回至管理员页面";  //每次设置的x的值都不一样了。
            }else{
                location.href='managerSuccessLogin.jsp';
            }
        }
        setInterval(go,1000);
    </script>

</head>
<body>
<div class="bg bg-blur"></div>
<div class="content-front container-fluid">
    <div class="row">
        <div class="col-md-10">
            <div style="margin-top: 150px; margin-left: 220px; ">
                <h1 class="display-3" style="color:gainsboro; text-align: center ">${requestScope.addStatus}</h1>
                <p class="lead" style="color: gainsboro; margin-top: 20px; text-align: center">富强民主文明和谐</p>
                <hr class="my-4 "style="color: gainsboro">
                <div style="margin-top: 100px;">
                    <h1 id="jumpToIndex" style="color: gainsboro;text-align: center">3秒后返回至管理员页面</h1>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>