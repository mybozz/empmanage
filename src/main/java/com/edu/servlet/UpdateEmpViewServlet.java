package com.edu.servlet;

import com.edu.entity.Dept;
import com.edu.entity.Emp;
import com.edu.service.DeptService;
import com.edu.service.EmpService;
import com.edu.service.impl.DeptServiceImpl;
import com.edu.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/updateempview"})
public class UpdateEmpViewServlet extends HttpServlet {
    private  DeptService deptService = new DeptServiceImpl();
    private EmpService empService = new EmpServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取id
        Integer empId = Integer.parseInt(req.getParameter("id"));
        //2.根据id查询数据
        Emp emp = empService.getEmpById(empId);
        //3.emp对象绑定和所有部门数据到req
        req.setAttribute("emp",emp);
        List<Dept> deptList = deptService.listDept();
        req.setAttribute("deptList",deptList);
        //4.转发到jsp
        req.getRequestDispatcher("/WEB-INF/pages/updateemp.jsp").forward(req,resp);

    }
}
