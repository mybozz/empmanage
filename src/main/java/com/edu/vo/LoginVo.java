package com.edu.vo;

import lombok.Data;

@Data
public class LoginVo {

    private Integer status;
    private String message;


    public static LoginVo success(){
        LoginVo loginVo = new LoginVo();
        loginVo.setStatus(0);
        loginVo.setMessage("成功");
        return loginVo;
    }
    public static LoginVo error(Integer status, String message){
        LoginVo loginVo = new LoginVo();
        loginVo.setStatus(status);
        loginVo.setMessage(message);
        return loginVo;

    }
}
