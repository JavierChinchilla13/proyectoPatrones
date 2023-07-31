/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edu.ulatina.hth_db_connetion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author javi
 */
public class ActivityService extends Service implements ICrud < ActivityTO > {
    
    public void insert(ActivityTO activity) throws Exception {
        
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO HTH.ACTIVITY VALUES(?,?,?,?;?,?))");
        ps.setInt(1, 0);
        ps.setInt(2, activity.getIdEmployee());
        ps.setInt(3, activity.getIdProject());
        ps.setString(4, activity.getName());
        ps.setString(5, activity.getDescription());
        ps.setDouble(6,activity.getHours());
        
        ps.executeUpdate();
        close(ps);
        close(conn);
    }
    
    public void delete(int id) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = null;

        ps = getConn().prepareStatement("DELETE FROM HTH.ACTIVITY WHERE ID=?");
        ps.setInt(1, id);

        ps.executeUpdate();

        super.close(ps);
        super.close(conn);

    }
    
    public void update(ActivityTO act, int idEmployee, int idProject, String name, String description, double hours) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE HTH.ACTIVITY SET id_employee = ?, id_description=?, name = ?; description = ?, hours = ? WHERE id = ?");
        ps.setInt(1, idEmployee);
        ps.setInt(2, idProject);
        ps.setString(3,name);
        ps.setString(4,description);
        ps.setDouble(5, hours);
        ps.setDouble(6, act.getId());
        ps.executeUpdate();
        close(ps);
        close(conn);
        close(conn);
    }
    
    public List<ActivityTO> getActividad() throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = getConnection();
        List<ActivityTO> retorno = new ArrayList<ActivityTO>();

        ps = getConn().prepareStatement("SELECT * FROM hth.activity;");
        rs = ps.executeQuery();
        while (rs.next()) {
            ActivityTO activity;
            int id = rs.getInt("id");
            int idEmployee = rs.getInt("id_employee");
            int idProject = rs.getInt("id_project");
            String name= rs.getString("name");
            String description= rs.getString("description");
            Double hours = rs.getDouble("hours");
            
            activity = new ActivityTO(id, idEmployee, idProject, name, description, hours);

            
            retorno.add(activity);

        }

        super.close(rs);
        super.close(ps);
        super.close(conn);

        return retorno;
    }

    @Override
    public void delete(ActivityTO activity) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = null;

        ps = getConn().prepareStatement("DELETE FROM HTH.ACTIVITY WHERE ID = ?");
        ps.setInt(1, activity.getId());

        ps.executeUpdate();

        close(ps);
        close(conn);
    }
    
}
