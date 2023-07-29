/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author javi
 */
public class Connector {
    protected Connection conn = null;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
    protected Connection getConnection() throws Exception {
        //Paso 1
        Class.forName("com.mysql.jdbc.Driver");
        //Paso 2
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca?serverTimezone=UTC", "root", "root");
        System.out.println("CONEXION: " + conn);
        return conn;
    }

    protected void close(Connection conn) throws SQLException {

        if (conn != null && !conn.isClosed()) {

            conn.close();
            conn = null;
        }
    }

    protected void close(ResultSet rs) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
            rs = null;
        }
    }
    
    protected void close(PreparedStatement ps) throws SQLException {
        if (ps != null && !ps.isClosed()) {

            ps.close();
            ps = null;
        }
    }
    
}
