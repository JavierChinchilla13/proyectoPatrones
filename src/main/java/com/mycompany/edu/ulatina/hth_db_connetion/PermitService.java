/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edu.ulatina.hth_db_connetion;

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
public class PermitService extends Service
        implements ICrud<PermitTO>{
    
    public void insert(PermitTO permit) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO HTH.WORK_PERMIT VALUES(?,?,?,?,?)");
        ps.setInt(1, 0);
        ps.setInt(2, permit.getIdEmployee());
        ps.setDate(3, (java.sql.Date) (java.sql.Date) permit.getDate());
        ps.setString(4,permit.getDescription());
        ps.setInt(5, permit.getStatus());
        
        ps.executeUpdate();
        close(ps);
        close(conn);
    }
    
    public void insert(int idEmployee, Date date, String description, int status) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO HTH.WORK_PERMIT  (ID, id_employee, date, description, id_status_detail)VALUES(?,?,?,?,?)");
        
        int id = 0;
        ps.setInt(1, id);
        ps.setInt(2, idEmployee);
        ps.setDate(3,date);
        ps.setString(4, description);
        ps.setInt(5, status);
       
        ps.executeUpdate();
        close(ps);
    }
    public void insert(int idEmployee, Date date, String description) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO HTH.WORK_PERMIT  (ID, id_employee, date, description)VALUES(?,?,?,?)");
        
        int id = 0;
        ps.setInt(1, id);
        ps.setInt(2, idEmployee);
        ps.setDate(3,date);
        ps.setString(4, description);
        
       
        ps.executeUpdate();
        close(ps);
    }
     public void insert(int idEmployee, Date date) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO HTH.WORK_PERMIT  (ID, id_employee, date)VALUES(?,?,?)");
        
        int id = 0;
        ps.setInt(1, id);
        ps.setInt(2, idEmployee);
        ps.setDate(3,date);
        
        
       
        ps.executeUpdate();
        close(ps);
    }


    @Override
    public void delete(PermitTO permit) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = null;

        ps = getConn().prepareStatement("DELETE FROM HTH.WORK_PERMIT WHERE id=?");
        ps.setInt(1, permit.getId());

        ps.executeUpdate();

        super.close(ps);
        super.close(conn);
    }
    
    public void delete(int pk) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = null;

        ps = getConn().prepareStatement("DELETE FROM HTH.WORK_PERMIT WHERE id=?");
        ps.setInt(1, pk);

        ps.executeUpdate();

        super.close(ps);
        super.close(conn);
        
    }
    public void update(PermitTO permit) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE HTH.WORK_PERMIT SET ID_EMPLOYEE = ?, DATE = ?, DESCRIPTION = ?, ID_STATUS_DETAIL = ? WHERE ID = ?");
        
        ps.setInt(1, permit.getIdEmployee());
        ps.setDate(2, (java.sql.Date) (java.sql.Date)permit.getDate());
        
        ps.setString(3, permit.getDescription());
        ps.setInt(4,permit.getStatus());
        ps.setInt(5, permit.getId());
        
        ps.executeUpdate();
        
        close(ps);
        close(conn);
    }
    
    public List<PermitTO> getPermits() throws Exception {
        Connection conn = getConnection();
        List<PermitTO> listaRetorno = new ArrayList<>();
        PreparedStatement ps = conn.prepareStatement("SELECT ID, ID_EMPLOYEE, DATE, DESCRIPTION, ID_STATUS_DETAIL FROM HTH.WORK_PERMIT");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            int employee = rs.getInt("ID_EMPLOYEE");
            Date date = rs.getDate("DATE");
            String description = rs.getString("DESCRIPTION");
            int status = rs.getInt("id_status_detail");
            PermitTO permit = new PermitTO(id, employee, date, description, status);
            listaRetorno.add(permit);
        }
        close(rs);
        close(ps);
        close(conn);
        return listaRetorno;
    }
    public PermitTO searchByPK(int pK) throws Exception {
        Connection conn = getConnection();
        PermitTO permit = null;
        PreparedStatement ps = conn.prepareStatement("SELECT ID, ID_EMPLOYEE, DATE, DESCRIPTION, ID_STATUS_DETAIL FROM HTH.WORK_PERMIT WHERE ID = ?");
        ps.setInt(1, pK);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("id");
            int employee = rs.getInt("ID_EMPLOYEE");
            Date date = rs.getDate("DATE");
            String description = rs.getString("DESCRIPTION");
            int status = rs.getInt("id_status_detail");
            permit  = new PermitTO(id, employee, date, description, status);
        }
        close(rs);
        close(ps);
        close(conn);
        return permit;
    }
    
}
