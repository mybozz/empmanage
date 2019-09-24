package com.edu.servlet;

import com.edu.entity.Emp;
import com.edu.service.EmpService;
import com.edu.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(urlPatterns = {"/updateemp"})
public class UpdateEmpServlet extends HttpServlet {

    private EmpService empService = new EmpServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        Integer empId = Integer.parseInt(req.getParameter("empId"));
        String name = req.getParameter("name");
        Integer age = Integer.parseInt(req.getParameter("age"));
        String sex = req.getParameter("sex");
        BigDecimal salary = new BigDecimal(req.getParameter("salary"));
        Integer deptId = Integer.parseInt(req.getParameter("deptId"));

        Emp empParam = new Emp();
        empParam.setEmpId(empId);
        empParam.setName(name);
        empParam.setAge(age);
        empParam.setSex(sex);
        empParam.setSalary(salary);
        empParam.setDeptId(deptId);
        empService.updateEmpById(empParam);
        //转发
        //req.getRequestDispatcher("/emplist").forward(req,resp);
        //重定向
        resp.sendRedirect("emplist");
    }
}
