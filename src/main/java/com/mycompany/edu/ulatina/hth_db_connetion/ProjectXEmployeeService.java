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
 * @author Ale
 */
public class ProjectXEmployeeService extends Service implements ICrud<ProjectXEmployeeTO> {

    @Override
    public void insert(ProjectXEmployeeTO projectXEmployeeTO) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO HTH.PROJECT_X_EMPLOYEE VALUES(?,?,?,?,?)");
        ps.setInt(1, 0);
        ps.setInt(2, projectXEmployeeTO.getIdProject());
        ps.setInt(3, projectXEmployeeTO.getIdEmployee());
        ps.setInt(4, projectXEmployeeTO.getHoursInvested());
        ps.setString(5, projectXEmployeeTO.getFeedBack());
        ps.executeUpdate();
        close(ps);
        close(conn);
    }

    public void insert(int idProject, int idEmployee, int hoursInvested, String feedBack) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO HTH.PROJECT_X_EMPLOYEE VALUES(?,?,?,?,?)");
        ps.setInt(1, 0);
        ps.setInt(2, idProject);
        ps.setInt(3, idEmployee);
        ps.setInt(4, hoursInvested);
        ps.setString(5, feedBack);
        ps.executeUpdate();
        close(ps);
        close(conn);
    }

    @Override
    public void delete(ProjectXEmployeeTO projectXEmployeeTO) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("DELETE FROM HTH.PROJECT_X_EMPLOYEE WHERE ID = ?");
        ps.setInt(1, projectXEmployeeTO.getId());
        ps.executeUpdate();
        close(ps);
        close(conn);
    }

    public void delete(int pK) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("DELETE FROM HTH.PROJECT_X_EMPLOYEE WHERE ID = ?");
        ps.setInt(1, pK);
        ps.executeUpdate();
        close(ps);
        close(conn);
    }

    public void update(ProjectXEmployeeTO projectXEmployeeTO) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE HTH.PROJECT_X_EMPLOYEE SET ID_PROJECT = ?, ID_EMPLOYEE = ?, HOURS_INVESTED = ?, FEEDBACK = ? WHERE ID = ?");
        ps.setInt(1, projectXEmployeeTO.getIdProject());
        ps.setInt(2, projectXEmployeeTO.getIdEmployee());
        ps.setInt(3, projectXEmployeeTO.getHoursInvested());
        ps.setString(4, projectXEmployeeTO.getFeedBack());
        ps.setInt(5, projectXEmployeeTO.getId());
        ps.executeUpdate();
        close(ps);
        close(conn);
    }

    public void update(ProjectXEmployeeTO projectXEmployeeTO, int newIdProject, int newIdEmployee, int newHoursInvested, String newFeedback) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE HTH.PROJECT_X_EMPLOYEE SET ID_PROJECT = ?, ID_EMPLOYEE = ?, HOURS_INVESTED = ?, FEEDBACK = ? WHERE ID = ?");
        ps.setInt(1, newIdProject);
        ps.setInt(2, newIdEmployee);
        ps.setInt(3, newHoursInvested);
        ps.setString(4, newFeedback);
        ps.setInt(5, projectXEmployeeTO.getId());
        ps.executeUpdate();
        close(ps);
        close(conn);
    }

    public List<ProjectXEmployeeTO> getProjectXEmployeeInfo() throws Exception {
        Connection conn = getConnection();
        List<ProjectXEmployeeTO> projectXEmployeeList = new ArrayList<>();
        PreparedStatement ps = conn.prepareStatement("SELECT ID,ID_PROJECT,ID_EMPLOYEE,HOURS_INVESTED,FEEDBACK FROM HTH.PROJECT_X_EMPLOYEE");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            int idProject = rs.getInt("ID_PROJECT");
            int idEmployee = rs.getInt("ID_EMPLOYEE");
            int hoursInvested = rs.getInt("HOURS_INVESTED");
            String feedBack = rs.getString("FEEDBACK");
            ProjectXEmployeeTO projectXEmployeeTO = new ProjectXEmployeeTO(id, idProject, idEmployee, hoursInvested, feedBack);
            projectXEmployeeList.add(projectXEmployeeTO);
        }
        close(rs);
        close(ps);
        close(conn);
        return projectXEmployeeList;
    }

    public List<ProjectXEmployeeTO> getPXEInfoFrom(int pk) throws Exception {
        Connection conn = getConnection();
        List<ProjectXEmployeeTO> projectXEmployeeList = new ArrayList<>();
        PreparedStatement ps = conn.prepareStatement("SELECT ID,ID_PROJECT,ID_EMPLOYEE,HOURS_INVESTED,FEEDBACK FROM HTH.PROJECT_X_EMPLOYEE WHERE ID = ?");
        ps.setInt(1, pk);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("ID");
            int idProject = rs.getInt("ID_PROJECT");
            int idEmployee = rs.getInt("ID_EMPLOYEE");
            int hoursInvested = rs.getInt("HOURS_INVESTED");
            String feedBack = rs.getString("FEEDBACK");

            ProjectXEmployeeTO projectEmployeeTO = new ProjectXEmployeeTO(id, idProject, idEmployee, hoursInvested, feedBack);
            projectXEmployeeList.add(projectEmployeeTO);
        }

        close(rs);
        close(ps);
        close(conn);

        return projectXEmployeeList;
    }

    public void addFeedbackToEmployee(int idProject, int idEmployee, String feedBack) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE PROJECT_X_EMPLOYEE SET FEEDBACK = ? WHERE ID_PROJECT = ? AND ID_EMPLOYEE = ?");
        ps.setString(1, feedBack);
        ps.setInt(2, idProject);
        ps.setInt(3, idEmployee);
        ps.executeUpdate();
        close(ps);
        close(conn);
    }

}
