
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
public class UsuarioService extends Connector implements Crud<UsuariosTO>{

    public void insert(UsuariosTO usuario) throws Exception {

        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO BIBLIOTECA.USUARIO VALUES(?,?,?,?,?,?)");
        ps.setInt(1, 0);
        ps.setString(2, usuario.getNombre());
        ps.setString(3, usuario.getDireccion());
        ps.setInt(4, usuario.getTelefono());
        ps.setString(4, usuario.getCiudad());
        ps.setString(4, usuario.getCorreo());

        ps.executeUpdate();
        close(ps);
        close(conn);
    }


    public void delete(int id) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = null;

        ps = getConn().prepareStatement("DELETE FROM BIBLIOTECA.USUARIO WHERE ID_USUARIO=?");
        ps.setInt(1, id);

        ps.executeUpdate();

        super.close(ps);
        super.close(conn);

    }
    
     @Override
    public void delete(UsuariosTO usuarios) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = null;

        ps = getConn().prepareStatement("DELETE FROM BIBLIOTECA.USUARIO WHERE ID_USUARIO=?");
        ps.setInt(1, usuarios.getId());

        ps.executeUpdate();

        super.close(ps);
        super.close(conn);
    }

    public void update(int id, String nombre, String direccion, int telefono, String ciudad, String correo) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE BIBLIOTECA.USUARIO SET NOMBRE = ?, DIRECCION = ?, TELEFONO = ?, CIUDAD = ?, CORREO = ? WHERE ID_USUARIO = ?");
        ps.setString(1, nombre);
        ps.setString(2, direccion);
        ps.setInt(3, telefono);
        ps.setString(4, ciudad);
        ps.setString(5, correo);
        ps.setInt(6, id);
        ps.executeUpdate();
        close(ps);
        close(conn);
        close(conn);
    }

    

    public List<UsuariosTO> getUsuario() throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = getConnection();
        List<UsuariosTO> retorno = new ArrayList<UsuariosTO>();

        ps = getConn().prepareStatement("SELECT * FROM BIBLIOTECA.USUARIO");
        rs = ps.executeQuery();
        while (rs.next()) {
            UsuariosTO usuariosTO;
            int id = rs.getInt("id_usuario");
            String nombre = rs.getString("nombre");
            String direccion = rs.getString("direccion");
            int telefono = rs.getInt("telefono");
            String ciudad = rs.getString("ciudad");
            String correo = rs.getString("correo");

            usuariosTO = new UsuariosTO(id, nombre, direccion, telefono, ciudad, correo);
            //String tblData[] = {titulo, anio, editorial};

            retorno.add(usuariosTO);

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
            model.addColumn("Nombre");
            model.addColumn("Direccion");
            model.addColumn("Telefono");
            model.addColumn("Ciudad");
            model.addColumn("Correo");

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