<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工添加页</title>
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col">
                <form action="addemp" method="post">
                    <div class="form-group">
                        <label for="name">姓名</label>
                        <input type="text" class="form-control" id="name"  placeholder="姓名" name="name">
                    </div>
                    <div class="form-group">
                        <label for="age">年龄</label>
                        <input type="number" class="form-control" id="age" placeholder="年龄" name="age">
                    </div>

                    <div class="custom-control custom-radio">
                        <input type="radio" id="customRadio1" name="sex" class="custom-control-input" value="男" checked>
                        <label class="custom-control-label" for="customRadio1">男</label>
                    </div>
                    <div class="custom-control custom-radio">
                        <input type="radio" id="customRadio2" name="sex" class="custom-control-input" value="女">
                        <label class="custom-control-label" for="customRadio2">女</label>
                    </div>

                    <div class="form-group">
                        <label for="salary">工资</label>
                        <input type="number" class="form-control" id="salary" placeholder="工资" name="salary">
                    </div>

                    <label for="dept">部门</label>
                    <select class="custom-select" id="dept" name="deptId">
                        <c:forEach items="${deptList}" var="dept">
                        <option value="${dept.deptId}">${dept.dname}</option>
                        </c:forEach>
                    </select>

                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    </div>




<script src="/js/jquery-3.4.1.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
