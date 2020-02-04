package com.projettic.dao.impl;

import java.sql.*;

public class EmpDaoImpl implements com.projettic.dao.EmpDao {

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    String strUrl;
    String strUsername;
    String strPW;
    Connection connection;

	public EmpDaoImpl() throws SQLException {
		this.connection = DriverManager.getConnection(strUrl, strUsername, strPW);
	}

    public void setStrUrl(String strUrl) {
        this.strUrl = strUrl;
    }

    public void setStrUsername(String strUsername) {
        this.strUsername = strUsername;
    }

    public void setStrPW(String strPW) {
        this.strPW = strPW;
    }

    public ResultSet getResult(String SqlQuery) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(SqlQuery);
        return result;
    }

//	public String getHisReq(String hisReq) {
//        try {
//
//            Statement statement = connection.createStatement();
//            ResultSet resultat = statement.executeQuery(hisReq);
//            while (resultat.next()) {
//                String empNom = resultat.getString("nom_emp");
//                hisRes += empNom + " ";
//            }
//        } catch (SQLException e) {
//            return e.toString();
//
//        }
//        if (res.length() < 3) {
//            return "error";
//        } else {
//            return hisRes;
//        }
//    }
//
//    public String getCorrection() {
//        try {
//
//            Statement statement = connection.createStatement();
//            ResultSet resultat = statement.executeQuery("SELECT nom_emp FROM emp;");
//            while (resultat.next()) {
//                String empNom = resultat.getString("nom_emp");
//                res += empNom + " ";
//            }
//        } catch (SQLException e) {
//
//        }
//        if (res.length() < 3) {
//            return "error";
//        } else {
//            return res;
//        }
//    }

//    public void close() {
////        if (result != null) {
////            try {
////                /* On commence par fermer le ResultSet */
////                result.close();
////            } catch (SQLException ignore) {
////            }
////        }
////        if (statement != null) {
////            try {
////                /* Puis on ferme le Statement */
////                statement.close();
////            } catch (SQLException ignore) {
////            }
////        }
////        if (connection != null) {
////            try {
////                /* Fermeture de la connexion */
////                connection.close();
////            } catch (SQLException ignore) {
////                /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
////            }
////        }
////    }
}