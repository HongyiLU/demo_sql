package com.projettic.service;

import com.projettic.entity.SqlQuery;

import java.sql.SQLException;

public interface EmpService {
    String getHisRes(SqlQuery sqlQuery);
    String getCorrection();
}
