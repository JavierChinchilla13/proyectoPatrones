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


/* 
    Esta clase hace que el programa pueda conectar a la BD
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
        //Aquí se hace uso del driver para que la conexión de MySQL pueda conectar a Java
        Class.forName("com.mysql.jdbc.Driver");
        //Este es el Url de la base de datos
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca?serverTimezone=UTC", "root", "root");
        System.out.println("CONEXION: " + conn);
        return conn;
    }

    /*
        Las siguientes líneas de código permiten que cuando se cierre el
        programa, también se desconecte de la base de datos.
    
    */
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
