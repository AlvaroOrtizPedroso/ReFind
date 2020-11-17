package com.example.refind;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConectorMySql {
    static final String DB_URL="jdbc:mysql://localhost/pruebarefind";
    static final String USER = "root";
    static final String PASS = "";

    static Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    public static Connection establecerConexion(){
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Se ha producido una SQLException:" + e.getMessage());
            Logger.getLogger(ConectorMySql.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException e) {
            System.out.println("Se ha producido una ClassNotFoundException:" + e.getMessage());
            Logger.getLogger(ConectorMySql.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            return conn;
        }
    }

    public static void cerrarConexion() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(ConectorMySql.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
