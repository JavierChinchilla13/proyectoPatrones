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
public class VacationService extends Service implements ICrud<VacationTO> {

    @Override
    public void insert(VacationTO vacationTO) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO THT.VACATION VALUES(?,?)");
        ps.setInt(1, vacationTO.getIdEmployee());
        ps.setInt(2, vacationTO.getVacationDays());
        ps.executeUpdate();
        close(ps);
        close(conn);
    }

    public void insert(int idEmployee, int vacationDays) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO THT.VACATION VALUES(?,?)");
        ps.setInt(1, idEmployee);
        ps.setInt(2, vacationDays);
        ps.executeUpdate();
        close(ps);
        close(conn);
    }

    @Override
    public void delete(VacationTO vacationTO) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("DELETE FROM HTH.VACATION WHERE ID = ?");
        ps.setInt(1, vacationTO.getId());
        ps.executeUpdate();
        close(ps);
        close(conn);
    }
    
    public void delete(int pK) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("DELETE FROM HTH.VACATION WHERE ID = ?");
        ps.setInt(1, pK);
        ps.executeUpdate();
        close(ps);
        close(conn);
    }
    
    public void update(VacationTO vacationTO) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE HTH.VACATION SET ID_EMPLOYEE = ?, VACATION_DAYS = ?, WHERE ID = ?");
        ps.setInt(1, vacationTO.getIdEmployee());
        ps.setInt(2, vacationTO.getVacationDays());
        ps.setInt(3, vacationTO.getId());
        ps.executeUpdate();
        close(ps);
        close(conn);
    }

    public void update(VacationTO vacationTO, int newIdEmployee, int newVacationDays) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE HTH.VACATION SET ID_EMPLOYEE = ?, VACATION_DAYS = ?, WHERE ID = ?");
        ps.setInt(1, newIdEmployee);
        ps.setInt(2, newVacationDays);
        ps.setInt(3, vacationTO.getId());
        ps.executeUpdate();
        close(ps);
        close(conn);
    }

    public List<VacationTO> getVacations() throws Exception {
        Connection conn = getConnection();
        List<VacationTO> vacationTOList = new ArrayList<>();
        PreparedStatement ps = conn.prepareStatement("SELECT ID,ID_EMPLOYEE,VACATION_DAYS FROM HTH.VACATION");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            int idEmployee = rs.getInt("id_employee");
            int VacationDays = rs.getInt("vacation_days");
            VacationTO vacationTO = new VacationTO(id, idEmployee, VacationDays);
            vacationTOList.add(vacationTO);
        }
        close(rs);
        close(ps);
        close(conn);
        return vacationTOList;
    }

    public VacationTO searchByPK(int pK) throws Exception {
        Connection conn = getConnection();
        VacationTO vacationTO = null;
        PreparedStatement ps = conn.prepareStatement("SELECT ID,ID_EMPLOYEE,VACATION_DAYS FROM HTH.VACATION WHERE ID = ?");
        ps.setInt(1, pK);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("id");
            int idEmployee = rs.getInt("id_employee");
            int vacationDays = rs.getInt("vacation_days");
            vacationTO = new VacationTO(id, idEmployee, vacationDays);
        }
        close(rs);
        close(ps);
        close(conn);
        return vacationTO;
    }

}
