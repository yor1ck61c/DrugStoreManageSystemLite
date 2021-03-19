<%--
  Created by IntelliJ IDEA.
  User: 我今天一定要早睡
  Date: 2020/6/19
  Time: 10:00
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
    <div style="margin-top: 150px; margin-left: 250px; ">
      <h1 class="display-1" style="color: gainsboro">欢迎使用药店管理系统</h1>
      <p class="lead" style="color: gainsboro; margin-top: 20px">版本:v1.0 &nbsp;&nbsp;&nbsp;&nbsp;作者:我今天一定要早睡</p>
      <hr class="my-4 "style="color: gainsboro">


      <!-- Button trigger modal -->
      <a href="#" class="btn btn-primary-outline" data-toggle="modal" data-target="#exampleModalScrollable" style="margin-left:-13px;color: gainsboro">
        安全提示
      </a>

      <!-- Modal -->
      <div class="modal fade" id="exampleModalScrollable" tabindex="-1" role="dialog" aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-scrollable" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalScrollableTitle" style="margin-left: 190px; color: gold">安全提示</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body" style="text-align: center">
              国家食品药品监督管理局提示您：<br>
              网上购药需到经过食品药品监管机<br>
              构批准的具有向个人消费者销售药<br>
              品资格的网站进行购买。
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
            </div>
          </div>
        </div>
      </div>
      <div style="margin-top: 120px">
        <a class="btn btn-primary-outline btn-lg border rounded-pill" href="managerLogin.jsp" role="button" style="margin-left: 305px; color: gainsboro">我是管理员</a>
        <a class="btn btn-primary-outline btn-lg border rounded-pill" href="userLogin.jsp" role="button" style="margin-left: 150px; color: gainsboro">我是顾客</a>
      </div>
    </div>
  </div>
</div>
</body>
</html>