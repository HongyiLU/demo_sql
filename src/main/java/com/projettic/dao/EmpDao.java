package com.projettic.dao;

import com.projettic.entity.Account;
import com.projettic.entity.SqlQuery;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;


public interface EmpDao {

    @Select("select * from t_user")
    public List<Account> findAllEmp() throws SQLException;

    @Select("${sqlQuery}")
    List<LinkedHashMap<String, Object>> getHisResult(SqlQuery sqlQuery) throws SQLException;
}
