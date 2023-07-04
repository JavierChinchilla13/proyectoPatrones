/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edu.ulatina.hth_db_connetion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author javi
 */
public class MeetingService extends Service
        implements ICrud<MeetingTO>{

    @Override
    public void insert(MeetingTO meeting) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO HTH.MEETING VALUES(?,?,?,?,?)");
        ps.setInt(1, 0);
        ps.setInt(2, meeting.getStatus());
        ps.setDate(4, (java.sql.Date) (java.sql.Date) meeting.getMeetingDate());
        ps.setDate(5,(java.sql.Date) (java.sql.Date) meeting.getObjectiveDate());
        ps.setInt(3, meeting.getIdManager());
        if(!meeting.getEmployees().isEmpty()){
            for(EmployeeTO emp: meeting.getEmployees()){
                agregarColaborador(meeting, emp);
            }
        }
        ps.executeUpdate();
        close(ps);
        close(conn);
    }
    public void agregarColaborador(MeetingTO meeting, EmployeeTO emp) throws Exception{
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO HTH.MEETING_X_EMPLOYEE (ID_MEETING, ID_EMPLOYEE) VALUES(?,?)");
        
        //ps.setInt(1, id);
        ps.setInt(1, meeting.getId());
        ps.setInt(2, emp.getId());
        ps.executeUpdate();
        close(ps);
        close(conn);
    }

    @Override
    public void delete(MeetingTO meetingTO) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = null;

        ps = getConn().prepareStatement("DELETE FROM HTH.MEETING WHERE id=?");
        ps.setInt(1, meetingTO.getId());

        ps.executeUpdate();

        super.close(ps);
        super.close(conn);
        
    }
    
    public void delete(int pk) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = null;

        ps = getConn().prepareStatement("DELETE FROM HTH.MEETING WHERE id=?");
        ps.setInt(1, pk);

        ps.executeUpdate();

        super.close(ps);
        super.close(conn);
        
    }
    
    public void update(MeetingTO meetingTO) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE HTH.MEETING SET ID_STATUS_DETAIL = ?, ID_MANAGER = ?, MEETING_DATE = ?, OBJECTIVE_DATE = ? WHERE ID = ?");
        
        ps.setInt(1, meetingTO.getStatus());
        ps.setInt(2, meetingTO.getIdManager());
        
        ps.setDate(3, (java.sql.Date) (java.sql.Date) meetingTO.getMeetingDate());
        ps.setDate(4,(java.sql.Date) (java.sql.Date) meetingTO.getObjectiveDate());
        ps.setInt(5, meetingTO.getId());
        
        ps.executeUpdate();
        
        close(ps);
        close(conn);
    }
    public List<MeetingTO> getMeetings() throws Exception {
        Connection conn = getConnection();
        List<MeetingTO> listaRetorno = new ArrayList<>();
        PreparedStatement ps = conn.prepareStatement("SELECT ID, ID_STATUS_DETAIL, MEETING_DATE, OBJECTIVE_DATE, ID_MANAGER FROM HTH.MEETING");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            int status = rs.getInt("id_status_detail");
            Date meetingDate = rs.getDate("MEETING_DATE");
            Date objectiveDate = rs.getDate("OBJECTIVE_DATE");
            int manager = rs.getInt("ID_MANAGER");
            MeetingTO meeting = new MeetingTO(id, status, meetingDate, objectiveDate, manager);
            listaRetorno.add(meeting);
        }
        close(rs);
        close(ps);
        close(conn);
        return listaRetorno;
    }
    
    public EmployeeTO searchByPK1(int idToSearch) throws Exception {
        Connection conn = getConnection();
        EmployeeTO employee = null;
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM HTH.EMPLOYEE WHERE ID = ?");
        ps.setInt(1, idToSearch);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("id");
            String firstname = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String identification = rs.getString("identification");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            int type = rs.getInt("type");
            int status = rs.getInt("status");
            String password = rs.getString("password");
            employee = new EmployeeTO(id, firstname, lastName, identification, email, phone,type, status, password);
        }
        close(rs);
        close(ps);
        close(conn);
        return employee;
    }
    
    public MeetingTO searchByPK(int pK) throws Exception {
        Connection conn = getConnection();
        MeetingTO meetingTO = null;
        PreparedStatement ps = conn.prepareStatement("SELECT ID,ID_STATUS_DETAIL,MEETING_DATE,OBJECTIVE_DATE,ID_MANAGER FROM HTH.MEETING WHERE ID = ?");
        ps.setInt(1, pK);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("id");
            int status = rs.getInt("id_status_detail");
            //EmployeeTO manager = searchEmployeeByPK(idManager);
            Date meetingDate = (java.sql.Date) (Date)rs.getDate("meeting_date");
            Date objectiveDate = (java.sql.Date) (Date)rs.getDate("objective_date");
            int manager = rs.getInt("id_manager");
            meetingTO = new MeetingTO(id, status, meetingDate, objectiveDate, manager);
        }
        close(rs);
        close(ps);
        close(conn);
        return meetingTO;
    }
    
    
    
}
