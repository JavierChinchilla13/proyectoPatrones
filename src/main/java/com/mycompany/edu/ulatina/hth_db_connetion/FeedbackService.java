/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edu.ulatina.hth_db_connetion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 *
 * @author javi
 */
public class FeedbackService extends Service implements ICrud<FeedbackTO>{

    @Override
    public void insert(FeedbackTO feedback) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO HTH.FEEDBACK VALUES(?,?,?,?,?,?,?))");
        ps.setInt(1, 0);
        ps.setString(2, feedback.getName());
        ps.setString(3, feedback.getDescription());
        ps.setDate(4, feedback.getDateOfFeedback());
        ps.setInt(5, feedback.getIdStatus());
        ps.setInt(6, feedback.getIdType());
        ps.setInt(7, feedback.getIdCreator());
        
        

        ps.executeUpdate();
        close(ps);
        close(conn);
    }
    
    public void insert(String name, String description, Date dateOfFeedback, int idStatus, int idType, int idCreator) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO HTH.FEEDBACK VALUES(?,?,?,?,?,?,?))");
        ps.setInt(1, 0);
        ps.setString(2, name);
        ps.setString(3, description);
        ps.setDate(4, dateOfFeedback);
        ps.setInt(5, idStatus);
        ps.setInt(6, idType);
        ps.setInt(7, idCreator);
         
        ps.executeUpdate();
        close(ps);
        close(conn);
    }

    @Override
    public void delete(FeedbackTO feedback) throws Exception {
        
        Connection conn = getConnection();
        PreparedStatement ps = null;

        ps = getConn().prepareStatement("DELETE FROM HTH.FEEDBACK WHERE ID = ?");
        ps.setInt(1, feedback.getId());

        ps.executeUpdate();

        close(ps);
        close(conn);
    }
    
    public void delete(int id) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = null;

        ps = getConn().prepareStatement("DELETE FROM HTH.FEEDBACK WHERE ID = ?");
        ps.setInt(1, id);

        ps.executeUpdate();

        super.close(ps);
        super.close(conn);

    }
    
    public void update(FeedbackTO feedback, String name, String description, Date dateOfFeedback, int idStatus, int idType, int idCreator) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE HTH.FEEDBACK SET name=?, description = ?, date_of_feedback = ?, id_status = ?, id_Type=?, id_creator=? WHERE id = ?");
       
        ps.setString(1, name);
        ps.setString(2, description);
        ps.setDate(3, dateOfFeedback);
        ps.setInt(4, idStatus);
        ps.setInt(5, idType);
        ps.setInt(6, idCreator);
        ps.setInt(7, feedback.getId());
        ps.executeUpdate();
        close(ps);
        close(conn);
        close(conn);
    }
    
    
    public void insertAct(int idEmployee, int idActivity, int idFeedback) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO hth.feedback_x_activity VALUES(?,?,?,?))");
        ps.setInt(1, 0);
        ps.setInt(2, idEmployee);
        ps.setInt(3, idActivity);
        ps.setInt(4, idFeedback);
         
        ps.executeUpdate();
        close(ps);
        close(conn);
    }
    
    public void insertEmp(int idEmployee, int idFeedback) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO hth.feedback_x_employee VALUES(?,?,?))");
        ps.setInt(1, 0);
        ps.setInt(2, idEmployee);
        ps.setInt(3, idFeedback);
         
        ps.executeUpdate();
        close(ps);
        close(conn);
    }
    
    public void insertPj(int idProject, int idFeedback) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO hth.feedback_x_project VALUES(?,?,?))");
        ps.setInt(1, 0);
        ps.setInt(2, idProject);
        ps.setInt(3, idFeedback);
         
        ps.executeUpdate();
        close(ps);
        close(conn);
    }
}
