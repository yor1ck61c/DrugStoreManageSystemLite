<%--
  Created by IntelliJ IDEA.
  User: 我今天一定要早睡
  Date: 2020/6/22
  Time: 14:05
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

    <title>新增一款药品</title>
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
<body >
<div class="bg bg-blur"></div>
<div class="content-front container-fluid">
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <h1 class="display-5" style="margin-top: 80px; text-align: center; color: gainsboro">新增一款药品</h1>
            <form id="form" action="${pageContext.request.contextPath}/AddMedicineServlet" method="post" style="margin-top: 50px; color: gainsboro" >
                <div class="container-fluid">
                    <div class="row">
                        <div class="col">
                            <div class="form-group" style="margin-left: -15px">
                                <label for="medicine_name">药品名称</label>
                                <input type="text" id="medicine_name" class="form-control" name="medicine_name" placeholder="例：维生素C片" style="background-color: transparent;color: gainsboro; width: 200px" >
                            </div>
                        </div>
                        <div class="col" style="margin-top: px">
                            <div class="form-group" style="margin-left: 30px">
                                <label for="medicine_type">药品类型</label>
                                <input type="text" id="medicine_type" class="form-control" name="medicine_type" placeholder="例：中成药" style="background-color: transparent;color: gainsboro; width: 200px" >
                            </div>
                        </div>
                    </div>
                </div>
                <div class="container-fluid">
                    <div class="row">
                        <div class="col">
                            <div class="form-group" style="margin-left: -15px">
                                <label for="medicine_bid">进价</label>
                                <input type="text" id="medicine_bid" class="form-control" name="medicine_bid" placeholder="单位：人民币" style="background-color: transparent;color: gainsboro; width: 200px">
                            </div>
                        </div>
                        <div class="col" style="margin-top: px">
                            <div class="form-group" style="margin-left: 30px">
                                <label for="medicine_price">售价</label>
                                <input type="text" id="medicine_price" class="form-control" name="medicine_price" placeholder="单位:人民币" style="background-color: transparent;color: gainsboro; width: 200px" >
                            </div>
                        </div>
                    </div>
                </div>
                <div class="container-fluid">
                    <div class="row">
                        <div class="col">
                            <div class="form-group" style="margin-left: -15px">
                                <label for="medicine_unit">计量方式</label>
                                <input type="text" id="medicine_unit" class="form-control" name="medicine_unit" placeholder="例：盒" style="background-color: transparent;color: gainsboro; width: 200px">
                            </div>
                        </div>
                        <div class="col" style="margin-top: px">
                            <div class="form-group" style="margin-left: 30px">
                                <label for="medicine_num">数量</label>
                                <input type="text" id="medicine_num" class="form-control" name="medicine_num"  style="background-color: transparent;color: gainsboro; width: 200px">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row" style="margin-left:1px">
                    <div class="mb-3" >
                        <label for="medicine_effect">药效</label>
                        <textarea name="medicine_effect" class="form-control" id="medicine_effect" placeholder="药效简述" style="width: 460px;background-color: transparent;color: gainsboro; "></textarea>
                    </div>
                </div>
                <hr class="my-4">
                <button type="submit" class="btn btn-primary-outline btn-lg border rounded-pill" style="color: gainsboro; margin-left: 40%; margin-top: 10px">提交</button>
            </form>
        </div>
    </div>
</div>
</body >
</html>