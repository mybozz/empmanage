package com.edu.servlet;

import com.edu.entity.User;
import com.edu.service.UserService;
import com.edu.service.impl.UserServiceImpl;
import com.edu.vo.LoginVo;
import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.jsp.JspFactory;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //设置响应格式
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        //1.获取表单输入的用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String checked = req.getParameter("checked");
        System.out.println(checked);
        //通过用户名查询数据库
        User user =  userService.getUserByUsername(username);
        if (user != null){
           if (user.getPassword().equals(password)){
               //登陆成功将信息存储到Httpsession中
               HttpSession session = req.getSession();
               session.setAttribute("user",user);
               if ("on".equals(checked)){
                   //添加cookie
                   Cookie cookie = new Cookie("username",user.getUsername());
                   cookie.setMaxAge(60 * 60 * 24);
                   resp.addCookie(cookie);
               }
               //resp.sendRedirect("emplist");
               LoginVo loginVo = LoginVo.success();
               //响应给前台
               String jsonStr = new Gson().toJson(loginVo);
               out.print(jsonStr);

           }else {
               //密码错误
               LoginVo loginVo = LoginVo.error(1,"密码错误");
               String jsonStr = new Gson().toJson(loginVo);
               out.print(jsonStr);

           }
        }else {
            //用户名错误
            LoginVo loginVo = LoginVo.error(2,"用户名错误");
            String jsonStr = new Gson().toJson(loginVo);
            out.print(jsonStr);
           // resp.sendRedirect("loginview");
        }
    }
}
