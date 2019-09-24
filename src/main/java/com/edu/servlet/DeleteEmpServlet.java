package com.edu.servlet;

import com.edu.service.EmpService;
import com.edu.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/deleteemp"})
public class DeleteEmpServlet extends HttpServlet {

    private EmpService empService = new EmpServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer empId = Integer.parseInt(req.getParameter("id"));
        //调用业务层删除数据
        empService.deleteEmpById(empId);
        //重定向
        resp.sendRedirect("/emplist");
    }
}
