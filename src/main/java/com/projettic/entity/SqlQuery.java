package com.projettic.entity;


import org.springframework.beans.factory.annotation.Autowired;

public class SqlQuery {
    private String sqlquery;


    public void setSqlquery(String sqlquery) {
        this.sqlquery = sqlquery;
    }

    @Override
    public String toString() {
        return this.sqlquery;
    }
}
