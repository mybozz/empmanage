package com.edu.service.impl;

import com.edu.entity.Emp;
import com.edu.mapper.EmpMapper;
import com.edu.service.EmpService;
import com.edu.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class EmpServiceImpl implements EmpService {

    @Override
    public List<Emp> listEmp() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper( EmpMapper.class);
        List<Emp> empList = empMapper.listEmp();
        sqlSession.close();
        return empList;
    }

    @Override
    public int saveEmp(Emp emp) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper( EmpMapper.class);
        int row = empMapper.saveEmp(emp);
        sqlSession.close();
        return row;
    }

    @Override
    public int updateEmpById(Emp emp) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper( EmpMapper.class);
        int row = empMapper.updateEmpById(emp);
        sqlSession.close();
        return row;
    }

    @Override
    public List<Emp> listEmpDept() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper( EmpMapper.class);
        List<Emp> empList = empMapper.listEmpDept();
        sqlSession.close();
        return empList;
    }

    @Override
    public int deleteEmpById(Integer id) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper( EmpMapper.class);
        int row = empMapper.deleteEmpById(id);
        sqlSession.close();
        return row;
    }

    @Override
    public Emp getEmpById(Integer id) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper( EmpMapper.class);
        Emp emp = empMapper.getEmpById(id);
        sqlSession.close();
        return emp;
    }


}
