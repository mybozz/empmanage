package com.edu.service.impl;

import com.edu.entity.User;
import com.edu.mapper.UserMapper;
import com.edu.service.UserService;
import com.edu.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements UserService {
    @Override
    public User getUserByUsername(String username) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserByUsername(username);
        sqlSession.close();
        return user;
    }
}
