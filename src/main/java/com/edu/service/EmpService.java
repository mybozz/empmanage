package com.edu.service;

import com.edu.entity.Emp;

import java.util.List;

public interface EmpService {

    List<Emp> listEmp();

    int saveEmp(Emp emmp);

    List<Emp> listEmpDept();

    int deleteEmpById(Integer id);

    Emp getEmpById(Integer id);

    int updateEmpById(Emp emp);



}
