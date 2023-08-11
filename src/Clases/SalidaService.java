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
public class SalidaService extends Connector implements Crud<SalidaTO> {

    public void insert(SalidaTO salida) throws Exception {

        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO BIBLIOTECA.SALIDA VALUES(?,?,?,?,?,?)");
        ps.setInt(1, 0);
        ps.setDate(2, salida.getFechaSalida());
        ps.setDate(3, salida.getFechaRegreso());
        ps.setString(4, salida.getObservacion());
        ps.setInt(5, salida.getIdLibro());
        ps.setInt(6, salida.getIdUsuario());

        ps.executeUpdate();
        close(ps);
        close(conn);
    }


    public void delete(int id) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = null;

        ps = getConn().prepareStatement("DELETE FROM BIBLIOTECA.SALIDA WHERE ID_SALIDA=?");
        ps.setInt(1, id);

        ps.executeUpdate();

        super.close(ps);
        super.close(conn);

    }
    
    @Override
    public void delete(SalidaTO salida) throws Exception {
        
        Connection conn = getConnection();
        PreparedStatement ps = null;

        ps = getConn().prepareStatement("DELETE FROM BIBLIOTECA.SALIDA WHERE ID_SALIDA=?");
        ps.setInt(1, salida.getId());

        ps.executeUpdate();

        super.close(ps);
        super.close(conn);
    }

    public void update(int id, Date fechaSal,Date fechaEnt, String observacion) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE BIBLIOTECA.SALIDA SET fecha_salida = ?, fecha_regreso = ?, observarcion = ? WHERE ID_LIBRO = ?");
        ps.setDate(1, fechaSal);
        ps.setDate(2, fechaEnt);
        ps.setString(3, observacion);
        ps.setInt(4, id);
        ps.executeUpdate();
        close(ps);
        close(conn);
        close(conn);
    }

    

    public List<SalidaTO> getSalidas() throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = getConnection();
        List<SalidaTO> retorno = new ArrayList<SalidaTO>();

        ps = getConn().prepareStatement("SELECT * FROM BIBLIOTECA.SALIDA");
        rs = ps.executeQuery();
        while (rs.next()) {
            SalidaTO salidaTO;
            int id = rs.getInt("id_salida");
            Date fechaSalida = rs.getDate("fecha_salida");
            Date fechaRegreso = rs.getDate("fecha_regreso");
            String observacion = rs.getString("observarcion");
            int libroID = rs.getInt("fk_libro");
            int usuarioID = rs.getInt("fk_usuario");

            salidaTO = new SalidaTO(id, fechaSalida, fechaRegreso, observacion, libroID,usuarioID);

            retorno.add(salidaTO);

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
            model.addColumn("ID Salida");
            model.addColumn("Fecha Salida");
            model.addColumn("Fecha Entrada");
            model.addColumn("Observacion");
            model.addColumn("ID Libro");
            model.addColumn("ID Usuario");

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
                    dato[4] = rs.getString(5);
                    dato[5] = rs.getString(6);
                    model.addRow(dato);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }

    }

    


    
    
}