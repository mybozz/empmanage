package com.edu.servlet;

import com.edu.entity.Dept;
import com.edu.service.DeptService;
import com.edu.service.impl.DeptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/addempview"})
public class AddEmpViewServlet extends HttpServlet {

    private DeptService deptService = new DeptServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Dept> deptList = deptService.listDept();
        req.setAttribute("deptList",deptList);
        req.getRequestDispatcher("/WEB-INF/pages/addemp.jsp").forward(req,resp);
    }
}
