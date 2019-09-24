<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改员工页</title>
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col">
            <form action="updateemp" method="post">

                <div class="form-group">
                    <label for="name">姓名</label>
                    <input type="text" class="form-control" id="name"  placeholder="姓名" name="name" value="${emp.name}">
                </div>
                <div class="form-group">
                    <label for="age">年龄</label>
                    <input type="number" class="form-control" id="age" placeholder="年龄" name="age" value="${emp.age}">
                </div>


                <div class="custom-control custom-radio">
                    <input type="radio" id="customRadio1" name="sex" class="custom-control-input" value="男" <c:if test="${emp.sex == '男'}">checked</c:if>>
                    <label class="custom-control-label" for="customRadio1">男</label>
                </div>
                <div class="custom-control custom-radio">
                    <input type="radio" id="customRadio2" name="sex" class="custom-control-input" value="女" <c:if test="${emp.sex == '女'}">checked</c:if>>
                    <label class="custom-control-label" for="customRadio2">女</label>
                </div>

                <div class="form-group">
                    <label for="salary">工资</label>
                    <input type="number" class="form-control" id="salary" placeholder="工资" name="salary" value="${emp.salary}">
                </div>

                <label for="dept">部门</label>
                <select class="custom-select" id="dept" name="deptId">
                    <c:forEach items="${deptList}" var="dept">
                        <c:if test="${dept.deptId != emp.deptId}">
                            <option value="${dept.deptId}">${dept.dname}</option>
                        </c:if>
                        <c:if test="${dept.deptId == emp.deptId}">
                            <option value="${dept.deptId}" selected>${dept.dname}</option>
                        </c:if>

                    </c:forEach>
                </select>
                <input type="hidden" name="empId" value="${emp.empId}">
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>

<script src="/js/jquery-3.4.1.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
