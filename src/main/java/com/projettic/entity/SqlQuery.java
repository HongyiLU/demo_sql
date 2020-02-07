package com.projettic.entity;

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
