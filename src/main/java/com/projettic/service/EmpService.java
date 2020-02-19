package com.projettic.service;

import java.sql.SQLException;

public interface EmpService {
    String getHisRes(String hisReq) throws SQLException, ClassNotFoundException;
    String getCorrection();
}
