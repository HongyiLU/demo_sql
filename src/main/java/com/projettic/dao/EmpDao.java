package com.projettic.dao;

import com.projettic.entity.Account;
import com.projettic.entity.SqlQuery;
import org.apache.ibatis.annotations.Select;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;


public interface EmpDao {

    @Select("select * from t_user")
    public List<Account> findAllEmp() throws BadSqlGrammarException;

    @Select("${sqlQuery}")
    List<LinkedHashMap<String, Object>> getHisResult(SqlQuery sqlQuery) throws BadSqlGrammarException;
}
