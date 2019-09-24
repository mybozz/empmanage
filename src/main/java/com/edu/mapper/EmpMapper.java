package com.edu.mapper;

import com.edu.entity.Emp;

import java.util.List;

public interface EmpMapper {

    List<Emp> listEmp();
    int saveEmp(Emp emmp);
    int updateEmpById(Emp emp);

    List<Emp> listEmpDept();
    int deleteEmpById(Integer id);

    Emp getEmpById(Integer id);


}
