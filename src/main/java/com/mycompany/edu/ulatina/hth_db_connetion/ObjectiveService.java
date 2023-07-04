/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edu.ulatina.hth_db_connetion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author javi
 */
public class ObjectiveService extends Service
        implements ICrud<ObjectiveTO>{

    @Override
    public void insert(ObjectiveTO obj) throws Exception {
       Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO THT.OBJECTIVE VALUES(?,?,?)");
        ps.setString(1, obj.getName());
        ps.setInt(2, obj.getIdMeeting());
        ps.setString(3, obj.getDescription());
        ps.executeUpdate();
        close(ps);
        close(conn); 
    }

    public void insert(String name, int idMeeting, String description) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO THT.OBJECTIVE VALUES(?,?,?)");
        ps.setString(1, name);
        ps.setInt(2, idMeeting);
        ps.setString(3, description);
        ps.executeUpdate();
        close(ps);
        close(conn);
    }
    
    public ObjectiveTO searchByPK(int pK) throws Exception {
        Connection conn = getConnection();
        ObjectiveTO objectiveTO = null;
        PreparedStatement ps = conn.prepareStatement("SELECT ID, NAME, IDMEETING, DESCRIPTION FROM HTH.OBJECTIVE WHERE ID = ?");
        ps.setInt(1, pK);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int idMeeting = rs.getInt("idmeeting");
            String description = rs.getString("description");
            objectiveTO = new ObjectiveTO(id, name, idMeeting,   description);
        }
        close(rs);
        close(ps);
        close(conn);
        return objectiveTO;
    }
    
    @Override
    public void delete(ObjectiveTO objective) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("DELETE FROM HTH.OBJECTIVE WHERE ID = ?");
        ps.setInt(1, objective.getId());
        ps.executeUpdate();
        close(ps);
        close(conn);
    }
    
    public void delete(int pK) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("DELETE FROM HTH.OBJECTIVE WHERE ID = ?");
        ps.setInt(1, pK);
        ps.executeUpdate();
        close(ps);
        close(conn);
    }
    
    public void update(ObjectiveTO objective) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE HTH.OBJECTIVE SET NAME = ?, IDMEETING = ?, DESCRIPTION = ? WHERE ID = ?");
        ps.setString(1, objective.getName());
        ps.setInt(2, objective.getIdMeeting());
        ps.setString(3, objective.getDescription());
        ps.setInt(4, objective.getId());
        ps.executeUpdate();
        close(ps);
        close(conn);
    }
    public void update(ObjectiveTO objective, String newName, int newIdMeeting, String newDescription) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE HTH.OBJECTIVE SET NAME = ?, IDMEETING = ?, DESCRIPTION = ? WHERE ID = ?");
        ps.setString(1, newName);
        ps.setInt(2, newIdMeeting);
        ps.setString(3, newDescription);
        ps.setInt(4, objective.getId());
        ps.executeUpdate();
        close(ps);
        close(conn);
    }
    
    public List<ObjectiveTO> getObjectives() throws Exception {
        Connection conn = getConnection();
        List<ObjectiveTO> objectiveList = new ArrayList<>();
        PreparedStatement ps = conn.prepareStatement("SELECT ID,NAME,IDMEETING,DESCRIPTION FROM HTH.OBJECTIVE");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int idMeeting = rs.getInt("idmeeting");
            String description = rs.getString("description");
            ObjectiveTO objectiveTO = new ObjectiveTO(id, name, idMeeting,   description);
            objectiveList.add(objectiveTO);
        }
        close(rs);
        close(ps);
        close(conn);
        return objectiveList;
    }

    

    
    
    
    
}
