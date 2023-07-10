package com.mycompany.edu.ulatina.hth_db_connetion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DocumentService extends Service implements ICrud < DocumentTO > {

    public DocumentService() {
        super();
    }

    @Override
    public void insert(DocumentTO doc) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO HTH.DOCUMENT VALUES(?,?,?,?)");
        ps.setInt(1, 0);
        ps.setInt(2, doc.getIdEmployee());
        ps.setString(3, doc.getName());
        ps.setString(4, doc.getPath());
        ps.executeUpdate();
        close(ps);
        close(conn);
    }
    
    public void insert(int idEmployeeDoc, String name, String path) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO HTH.DOCUMENT VALUES(?,?,?,?)");
        ps.setInt(1, 0);
        ps.setInt(2, idEmployeeDoc);
        ps.setString(3, name);
        ps.setString(4, path);
        ps.executeUpdate();
        close(ps);
        close(conn);
    }

    @Override
    public void delete(DocumentTO doc) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = null;

        ps = getConn().prepareStatement("DELETE FROM HTH.DOCUMENT WHERE ID = ?");
        ps.setInt(1, doc.getId());

        ps.executeUpdate();

        close(ps);
        close(conn);
    }
    
    public void delete(int id) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = null;

        ps = getConn().prepareStatement("DELETE FROM HTH.DOCUMENT WHERE ID = ?");
        ps.setInt(1, id);

        ps.executeUpdate();

        close(ps);
        close(conn);
    }
    
    public void update(DocumentTO doc, int idEmployee, String name, String path) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE HTH.DOCUMENT SET ID_EMPLOYEE = ?, NAME =?, PATH = ? WHERE ID = ?");
        ps.setInt(1, idEmployee);
        ps.setString(2, name);
        ps.setString(3, path);
        ps.setInt(4, doc.getId());
        ps.executeUpdate();
        close(ps);
        close(conn);
    }
    
    public void update(int PK, int idEmployee, String name, String path) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE HTH.DOCUMENT SET ID_EMPLOYEE = ?, NAME =?, PATH = ? WHERE ID = ?");
        ps.setInt(1, idEmployee);
        ps.setString(2, name);
        ps.setString(3, path);
        ps.setInt(4, PK);
        ps.executeUpdate();
        close(ps);
        close(conn);
    }
    
    public DocumentTO searchByPK(int PK) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT ID, ID_EMPLOYEE, NAME, PATH FROM HTH.DOCUMET WHERE ID = ?");
        ps.setInt(1, PK);
        ResultSet rs = ps.executeQuery();
        DocumentTO doc = null;
        if (rs.next()) {
            int id = rs.getInt("ID");
            int idEmployee = rs.getInt("ID_EMPLOYEE");
            String name = rs.getString("NAME");
            String path = rs.getString("PATH");
            doc = new DocumentTO(id, idEmployee, name, path);
        }
        close(rs);
        close(ps);
        close(conn);
        return doc;
    }
    
    public List<DocumentTO> getDocuments() throws Exception {
        Connection conn = getConnection();
        List<DocumentTO> listaRetorno = new ArrayList<>();
        PreparedStatement ps = conn.prepareStatement("SELECT ID, ID_EMPLOYEE, NAME, PATH FROM HTH.DOCUMENT");
        ResultSet rs = ps.executeQuery();
        DocumentTO doc;
        while (rs.next()) {
            int id = rs.getInt("ID");
            int idEmployee = rs.getInt("ID_EMPLOYEE");
            String name = rs.getString("NAME");
            String path = rs.getString("PATH");
            doc = new DocumentTO(id, idEmployee, name, path);
            listaRetorno.add(doc);
        }
        close(rs);
        close(ps);
        close(conn);
        return listaRetorno;
    }
    
     public List<DocumentTO> getDocumentsOfEmployee(int PK) throws Exception {
        Connection conn = getConnection();
        List<DocumentTO> listaRetorno = new ArrayList<>();
        PreparedStatement ps = conn.prepareStatement("SELECT ID, ID_EMPLOYEE, NAME, PATH FROM HTH.DOCUMENT WHERE ID_EMPLOYEE = ?");
        ps.setInt(1, PK);
        ResultSet rs = ps.executeQuery();
        DocumentTO doc;
        while (rs.next()) {
            int id = rs.getInt("ID");
            int idEmployee = rs.getInt("ID_EMPLOYEE");
            String name = rs.getString("NAME");
            String path = rs.getString("PATH");
            doc = new DocumentTO(id, idEmployee, name, path);
            listaRetorno.add(doc);
        }
        close(rs);
        close(ps);
        close(conn);
        return listaRetorno;
     }
}
