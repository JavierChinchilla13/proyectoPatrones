/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author javi
 */
public class LibroService extends Connector{
    
    public void insert(LibroTO libro) throws Exception {
        
        
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO BIBLIOTECA.LIBRO VALUES(?,?,?,?)");
        ps.setInt(1, 0);
        ps.setString(2, libro.getTitulo());
        ps.setInt(3, libro.getAnio());
        ps.setString(4,libro.getEditorial());
        
        ps.executeUpdate();
        close(ps);
        close(conn);
    }
    
    public void delete(int id) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = null;

        ps = getConn().prepareStatement("DELETE FROM BIBLIOTECA.LIBRO WHERE ID_LIBRO=?");
        ps.setInt(1, id);

        ps.executeUpdate();

        super.close(ps);
        super.close(conn);

    }
    
    public void update(LibroTO lib, String titulo, int anio, String editorial) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE BIBLIOTECA.LIBRO SET TITULO = ?, EDITORIAL = ?; ANIO = ? WHERE ID_LIBRO = ?");
        ps.setString(1, titulo);
        ps.setInt(6,anio);
        ps.setString(8, editorial);
        ps.setInt(4, lib.getId());
        ps.executeUpdate();
        close(ps);
        close(conn);
        close(conn);
    }
    
    public List<LibroTO> getLibros() throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = getConnection();
        List<LibroTO> retorno = new ArrayList<LibroTO>();

        ps = getConn().prepareStatement("SELECT * FROM BIBLIOTECA.LIBRO");
        rs = ps.executeQuery();
        while (rs.next()) {
            LibroTO libroTO;
            int id = rs.getInt("id_libro");
            String titulo = rs.getString("titulo");
            int anio= rs.getInt("anio");
            String editorial = rs.getString("editorial");
            
            libroTO = new LibroTO(id, titulo, anio, editorial);

            
            retorno.add(libroTO);

        }

        super.close(rs);
        super.close(ps);
        super.close(conn);

        return retorno;
    }
    
    
    
    
}
