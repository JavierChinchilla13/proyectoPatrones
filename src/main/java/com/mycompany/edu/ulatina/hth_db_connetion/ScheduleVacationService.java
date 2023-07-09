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
 * @author Ale
 */
public class ScheduleVacationService extends Service implements ICrud<ScheduleVacationTO> {

    public int getVacationIdByEmployeeId(int employeeId) throws Exception {
        Connection conn = getConnection();
        int vacationId = 0;

        PreparedStatement ps = conn.prepareStatement("SELECT ID FROM HTH.VACATION WHERE ID_EMPLOYEE = ?");
        ps.setInt(1, employeeId);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            vacationId = rs.getInt("id");
        }

        close(rs);
        close(ps);
        close(conn);

        return vacationId;
    }

    @Override
    public void insert(ScheduleVacationTO schedueleVacationTO) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO HTH.SCHEDULE_VACATION VALUES(?,?,?)");
        ps.setInt(1, schedueleVacationTO.getIdVacation());
        ps.setDate(2, schedueleVacationTO.getStartDate());
        ps.setDate(3, schedueleVacationTO.getEndDate());
        ps.executeUpdate();
        close(ps);
        close(conn);
    }

    public void insert(int idVacation, Date startDate, Date endDate) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO HTH.SCHEDULE_VACATION VALUES(?,?,?)");
        ps.setInt(1, idVacation);
        ps.setDate(2, startDate);
        ps.setDate(3, endDate);
        ps.executeUpdate();
        close(ps);
        close(conn);
    }

    @Override
    public void delete(ScheduleVacationTO schedueleVacationTO) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("DELETE FROM HTH.SCHEDULE_VACATION WHERE ID = ?");
        ps.setInt(1, schedueleVacationTO.getId());
        ps.executeUpdate();
        close(ps);
        close(conn);
    }

    public void delete(int pK) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("DELETE FROM HTH.SCHEDULE_VACATION WHERE ID = ?");
        ps.setInt(1, pK);
        ps.executeUpdate();
        close(ps);
        close(conn);
    }

    public void update(ScheduleVacationTO schedueleVacationTO) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE HTH.SCHEDULE_VACATION SET ID_VACATION = ?, STAR_DATE = ?, END_DATE = ? WHERE ID = ?");
        ps.setInt(1, schedueleVacationTO.getIdVacation());
        ps.setDate(2, schedueleVacationTO.getStartDate());
        ps.setDate(3, schedueleVacationTO.getEndDate());
        ps.setInt(4, schedueleVacationTO.getId());
        ps.executeUpdate();
        close(ps);
        close(conn);
    }

    public void update(ScheduleVacationTO schedueleVacationTO, int newIdVacation, Date newStarDate, Date newEndDate) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE HTH.SCHEDULE_VACATION SET ID_VACATION = ?, STAR_DATE = ?, END_DATE = ? WHERE ID = ?");
        ps.setInt(1, newIdVacation);
        ps.setDate(2, newStarDate);
        ps.setDate(3, newEndDate);
        ps.setInt(4, schedueleVacationTO.getId());
        ps.executeUpdate();
        close(ps);
        close(conn);
    }

    public List<ScheduleVacationTO> getSchedueleVacation() throws Exception {
        Connection conn = getConnection();
        List<ScheduleVacationTO> scheduleVacationList = new ArrayList<>();
        PreparedStatement ps = conn.prepareStatement("SELECT ID,ID_VACATION,START_DATE,END_DATE FROM HTH.SCHEDULE_VACATION");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            int idVacation = rs.getInt("id_vacation");
            Date startDate = rs.getDate("start_date");
            Date endDate = rs.getDate("end_date");
            ScheduleVacationTO scheduleVacationTO = new ScheduleVacationTO(id, idVacation, startDate, endDate);
            scheduleVacationList.add(scheduleVacationTO);
        }
        close(rs);
        close(ps);
        close(conn);
        return scheduleVacationList;
    }

    public ScheduleVacationTO searchByPK(int pK) throws Exception {
        Connection conn = getConnection();
        ScheduleVacationTO scheduleVacationTO = null;
        PreparedStatement ps = conn.prepareStatement("SELECT ID, ID_VACATION, START_DATE, END_DATE FROM HTH.SCHEDULE_VACATION WHERE ID = ?");
        ps.setInt(1, pK);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("id");
            int idVacation = rs.getInt("id_vacation");
            Date startDate = rs.getDate("start_date");
            Date endDate = rs.getDate("end_date");
            scheduleVacationTO = new ScheduleVacationTO(id, idVacation, startDate, endDate);
        }
        close(rs);
        close(ps);
        close(conn);
        return scheduleVacationTO;
    }
}
