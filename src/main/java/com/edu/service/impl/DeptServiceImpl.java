package com.edu.service.impl;

import com.edu.entity.Dept;
import com.edu.mapper.DeptMapper;
import com.edu.service.DeptService;
import com.edu.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

public class DeptServiceImpl implements DeptService {
    @Override
    public List<Dept> listDept() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        DeptMapper  deptMapper = sqlSession.getMapper(DeptMapper.class);
        List<Dept> deptList = deptMapper.listDept();
        sqlSession.close();
        return deptList;
    }
}
