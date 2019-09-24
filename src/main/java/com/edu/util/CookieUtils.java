package com.edu.util;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.Map;

public class CookieUtils {

    public static Map<String,String> cookiesToMap(Cookie[] cookies){
        Map<String,String> cookieMap = new HashMap<>();
        for (Cookie cookie : cookies) {
            if (cookie != null){
                cookieMap.put(cookie.getName(),cookie.getValue());
            }
        }
        return cookieMap;
    }
}
