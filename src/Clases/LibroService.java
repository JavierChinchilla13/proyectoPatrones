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

/*
 * Esta clase es exclusiva para agregar, eliminar y actualizar las tablas de
 * SQL con los datos de los libros, además que trabaja de la mano con la clase "LibroTO"
 */

public class LibroService extends Connector implements Crud<LibroTO> {
    
    // Este Insert, permite agregar a la base de datos los libros que se desean
    // Con su respectívo codigo ID, titulo, editorial y año.
    public void insert(LibroTO libro) throws Exception {

        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO BIBLIOTECA.LIBRO VALUES(?,?,?,?)");
        ps.setInt(1, 0);
        ps.setString(2, libro.getTitulo());
        ps.setString(3, libro.getEditorial());
        ps.setInt(4, libro.getAnio());
        

        ps.executeUpdate();
        close(ps);
        close(conn);
    }

    // Este Delete, elimina los librós por medio del codigo ID
    public void delete(int id) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = null;

        ps = getConn().prepareStatement("DELETE FROM BIBLIOTECA.LIBRO WHERE ID_LIBRO=?");
        ps.setInt(1, id);

        ps.executeUpdate();

        super.close(ps);
        super.close(conn);

    }
    
    @Override
    public void delete(LibroTO libro) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = null;

        ps = getConn().prepareStatement("DELETE FROM BIBLIOTECA.LIBRO WHERE ID_LIBRO=?");
        ps.setInt(1, libro.getId());

        ps.executeUpdate();

        super.close(ps);
        super.close(conn);
        
        
    }

    // Este Update, actualiza el los libros en el sistema.
    public void update(int id, String titulo, int anio, String editorial) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE BIBLIOTECA.LIBRO SET TITULO = ?, EDITORIAL = ?, ANIO = ? WHERE ID_LIBRO = ?");
        ps.setString(1, titulo); 
        ps.setString(2, editorial);
        ps.setInt(3, anio);
        ps.setInt(4, id);
        ps.executeUpdate();
        close(ps);
        close(conn);
        close(conn);
    }

    
    // Este getLibros Busca en la base de datos los libros y los muestra en la
    // tabla respectiva.
    
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
            
            String editorial = rs.getString("editorial");
            int anio = rs.getInt("anio");

            libroTO = new LibroTO(id, titulo, editorial, anio);
            //String tblData[] = {titulo, anio, editorial};

            retorno.add(libroTO);

        }

        super.close(rs);
        super.close(ps);
        super.close(conn);

        return retorno;
    }

       // Este RellenarTabla, ingresa los datos de los libros buscados anterior_
       // mente en la base de datos y los coloca en la tabla del programa
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
