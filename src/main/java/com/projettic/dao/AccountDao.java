package com.projettic.dao;

import com.projettic.entity.SqlQuery;
import com.projettic.entity.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.LinkedHashMap;
import java.util.List;

public interface AccountDao {

    @Select("select * from t_user")
    public List<Account> findAllUser();

    @Select("${sqlQuery}")
    public List<LinkedHashMap<String, Object>> testQuery(SqlQuery sqlQuery);

    @Insert("insert into t_user(username, password, email, groupid) " +
            "values(#{username},#{password},#{email},#{groupid})")
    public void saveUserAccount(Account user);
}