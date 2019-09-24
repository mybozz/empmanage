<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>员工列表页</title>
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
    <script src="/js/jquery-3.4.1.min.js"></script>
    <script>
        $(function () {
            //绑定删除点击事件
           $('.delete').click(function () {
               //1.获得需要删除的数据id
               var id = $(this).data('id');
               //2.发送网络请求将id携带到servlet
               location.href ='deleteemp?id=' + id;
           });
           //绑定修改点击事件
            $('.update').click(function () {
                //1.获得需要删除的数据id
                var id = $(this).data('id');
                //2.发送网络请求将id携带到servlet
                location.href ='updateempview?id=' + id;
            });
        });
    </script>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col">
            <table class="table table-dark">
                <thead>
                <tr>
                    <th scope="col">姓名</th>
                    <th scope="col">年龄</th>
                    <th scope="col">性别</th>
                    <th scope="col">工资</th>
                    <th scope="col">部门</th>
                    <th scope="col">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${empList}" var="emp">
                    <tr>
                        <td>${emp.name}</td>
                        <td>${emp.age}</td>
                        <td>${emp.sex}</td>
                        <td>${emp.salary}</td>
                        <td>${emp.dept.dname}</td>
                        <td>
                            <button type="button" class="btn btn-primary btn-sm update" data-id="${emp.empId}">修改</button>
                            <button type="button" class="btn btn-danger btn-sm delete" data-id="${emp.empId}">删除</button>
                        </td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <a href="/addempview" class="btn btn-success">添加员工</a>
        </div>
    </div>
</div>


<script src="/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
