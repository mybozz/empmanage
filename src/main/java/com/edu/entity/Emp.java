package com.edu.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Emp {
    private Integer empId;
    private String name;
    private Integer age;
    private String sex;
    private BigDecimal salary;
    private Integer deptId;

    private Dept dept;
}
