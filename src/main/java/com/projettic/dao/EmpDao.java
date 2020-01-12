package com.projettic.dao;

import com.projettic.entity.Emp;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EmpDao {
    @Select("select * from emp")
    List<Emp> findAll();
}
