/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author javi
 */
public class LibroService extends Connector {

    public void insert(LibroTO libro) throws Exception {

        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO BIBLIOTECA.LIBRO VALUES(?,?,?,?)");
        ps.setInt(1, 0);
        ps.setString(2, libro.getTitulo());
        ps.setInt(3, libro.getAnio());
        ps.setString(4, libro.getEditorial());

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

    public void update(int id, String titulo, int anio, String editorial) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE BIBLIOTECA.LIBRO SET TITULO = ?, ANIO = ?, EDITORIAL = ? WHERE ID_LIBRO = ?");
        ps.setString(1, titulo);
        ps.setInt(2, anio);
        ps.setString(3, editorial);
        ps.setInt(4, id);
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
            int anio = rs.getInt("anio");
            String editorial = rs.getString("editorial");

            libroTO = new LibroTO(id, titulo, anio, editorial);
            //String tblData[] = {titulo, anio, editorial};

            retorno.add(libroTO);

        }

        super.close(rs);
        super.close(ps);
        super.close(conn);

        return retorno;
    }

    public void RellenaLaTablaConDatosMySQL(String tabla, JTable visor) {
        try {
            String sql = "Select * from " + tabla;
            Statement st;
            Connection conn = getConnection();
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Libro");
            model.addColumn("Título");
            model.addColumn("Editorial");
            model.addColumn("Año");

            visor.setModel(model);
            String[] dato = new String[7];
            try {
                st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    dato[0] = rs.getString(1);
                    dato[1] = rs.getString(2);
                    dato[2] = rs.getString(3);
                    dato[3] = rs.getString(4);
                    model.addRow(dato);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }

    }


    
    
}
