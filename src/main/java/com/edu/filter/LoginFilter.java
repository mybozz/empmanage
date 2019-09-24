package com.edu.filter;

import com.edu.entity.User;
import com.edu.service.UserService;
import com.edu.service.impl.UserServiceImpl;
import com.edu.util.CookieUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebFilter(urlPatterns = {"/*"})
public class LoginFilter implements Filter {

    private UserService userService = new UserServiceImpl();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();
        if (uri.equals("/loginview") || uri.equals("/login") ||uri.endsWith(".js") ||uri.endsWith(".css")){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            //判断是否为空
            if (user == null){
                Cookie[] cookies = request.getCookies();
                Map<String,String> map = CookieUtils.cookiesToMap(cookies);
                String value = map.get("username");
                if (value == null) {
                    response.sendRedirect("loginview");
                }else {
                    User userCookie = userService.getUserByUsername(value);
                    session.setAttribute("user",userCookie);
                    filterChain.doFilter(servletRequest,servletResponse);
                }
            }else {
                filterChain.doFilter(servletRequest,servletResponse);
            }
        }
    }
    @Override
    public void destroy() {

    }
}
