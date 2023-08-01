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
public class ActivityService extends Service implements ICrud< ActivityTO> {

    public void insert(ActivityTO activity) throws Exception {

        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO HTH.CREATE_ACTIVITY VALUES(?,?,?,?,?))");
        ps.setInt(1, 0);
        ps.setInt(2, activity.getIdProject());
        ps.setString(3, activity.getName());
        ps.setString(4, activity.getDescription());
        ps.setDouble(5, activity.getHours());

        ps.executeUpdate();
        close(ps);
        close(conn);
    }

    public void insertActivyToEmployee(EmployeeTO employeeTO, ActivityTO activityTO) throws Exception {

        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO HTH.ACTIVITY VALUES(?,?,?))");
        ps.setInt(1, 0);
        ps.setInt(2, employeeTO.getId());
        ps.setInt(3, activityTO.getIdProject());

        ps.executeUpdate();
        close(ps);
        close(conn);
    }
    
    public void insertActivyToEmployee(int idEmployee, int idActivity) throws Exception {

        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO HTH.ACTIVITY VALUES(?,?,?))");
        ps.setInt(1, 0);
        ps.setInt(2, idEmployee);
        ps.setInt(3, idActivity);

        ps.executeUpdate();
        close(ps);
        close(conn);
    }

    public void delete(int id) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = null;

        ps = getConn().prepareStatement("DELETE FROM HTH.CREATE_ACTIVITY WHERE ID=?");
        ps.setInt(1, id);

        ps.executeUpdate();

        super.close(ps);
        super.close(conn);

    }

    public void update(ActivityTO act, int idProject, String name, String description, double hours) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE HTH.CREATE_ACTIVITY SET id_description=?, name = ?; description = ?, hours = ? WHERE id = ?");
        ps.setInt(1, idProject);
        ps.setString(2, name);
        ps.setString(3, description);
        ps.setDouble(4, hours);
        ps.setDouble(5, act.getId());
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
            int idProject = rs.getInt("id_project");
            String name = rs.getString("name");
            String description = rs.getString("description");
            Double hours = rs.getDouble("hours");

            activity = new ActivityTO(id, idProject, name, description, hours);

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

        ps = getConn().prepareStatement("DELETE FROM HTH.CREATE_ACTIVITY WHERE ID = ?");
        ps.setInt(1, activity.getId());

        ps.executeUpdate();

        close(ps);
        close(conn);
    }

}
