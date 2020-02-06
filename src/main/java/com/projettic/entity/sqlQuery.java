package com.projettic.entity;

public class sqlQuery {
    private String sqlquery;

    public void setSqlquery(String sqlquery) {
        this.sqlquery = sqlquery;
    }

    @Override
    public String toString() {
        return this.sqlquery;
    }
}
