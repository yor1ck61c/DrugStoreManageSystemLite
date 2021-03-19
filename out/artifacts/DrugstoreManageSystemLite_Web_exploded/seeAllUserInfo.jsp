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

    <title>所有用户信息</title>
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
<div class="content-front">
    <h1 class="display-4" style="margin-top: 100px; margin-left: 550px; color: gainsboro">查看所有用户信息</h1>
</div>
<div class="content-front container">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-8">
            <table class="table table-bordered" style="margin-top: 220px;margin-left: 100px; text-align:center;color: gainsboro">
                <thead>
                <tr>
                    <th scope="col">用户名</th>
                    <th scope="col">联系方式</th>
                    <th scope="col">余额</th>
                    <th scope="col">收货地址</th>
                    <th scope="col">操作</th>
                </tr>
                </thead>
                <c:forEach items="${requestScope.userByPage.items}" var="user">
                    <tbody>
                    <tr>
                        <th scope="row">${user.username}</th>
                        <td>${user.phoneNum}</td>
                        <td>${user.balance}</td>
                        <td>${user.address}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/UpdateBalanceServlet?id=${user.userId}" style="color: gainsboro; ">修改</a>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>

            </table>
            <nav aria-label="Page navigation example" style="margin-left: 99px">
                <ul class="pagination">
                    <c:if test="${requestScope.userByPage.currentPage == 1}">
                        <li class="page-item">
                            <a class="page-item" href="#" aria-label="Previous">
                                <span aria-hidden="">&laquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <c:if test="${requestScope.userByPage.currentPage != 1}">
                        <li class="page-item">
                            <a class="page-link " href="${pageContext.request.contextPath}/FindAllUserServlet?currentPage=${requestScope.userByPage.currentPage-1}&rows=5" aria-label="Previous">
                                <span aria-hidden="">&laquo;</span>
                            </a>
                        </li>
                    </c:if>

                    <c:forEach begin="1" end="${requestScope.userByPage.totalPages}" var="i">
                        <c:if test="${requestScope.userByPage.currentPage == i}">
                            <li class="page-item active"><a class="page-link" href="${pageContext.request.contextPath}/FindAllUserServlet?currentPage=${i}&rows=5">${i}</a></li>
                        </c:if>
                        <c:if test="${requestScope.userByPage.currentPage != i}">
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/FindAllUserServlet?currentPage=${i}&rows=5">${i}</a></li>
                        </c:if>

                    </c:forEach>
                    <c:if test="${requestScope.userByPage.currentPage == requestScope.userByPage.totalPages}">
                        <li class="page-item">
                            <a class="page-item " href="#" aria-label="Next">
                                <span aria-hidden="">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <c:if test="${requestScope.userByPage.currentPage != requestScope.userByPage.totalPages}">
                        <li class="page-item">
                            <a class="page-link" href="${pageContext.request.contextPath}/FindAllUserServlet?currentPage=${requestScope.userByPage.currentPage + 1}&rows=5" aria-label="Next">
                                <span aria-hidden="">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <span><h2 style="margin-left: 20px; color:gainsboro;">共${requestScope.userByPage.totalItems}名用户，${requestScope.userByPage.totalPages}页</h2></span>

                </ul>
            </nav>
        </div>
    </div>
    <a href="managerSuccessLogin.jsp" class="btn btn-primary-outline btn-lg border rounded-pill" style="color: gainsboro; margin-left: 730px; margin-top: 10px">返回</a>
</div>
</body>
</html>