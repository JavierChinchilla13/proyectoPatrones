/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edu.ulatina.hth_db_connetion;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author javi
 */
public class MeetingTO implements Serializable {
    private int id;
    private int status;
    private Date meetingDate;
    private Date objectiveDate;
    private int idManager;
    private List<EmployeeTO> Employees = new ArrayList<>();
    private List<ObjectiveTO> Objectives = new ArrayList<>();
    
    
    private void addEmployee(EmployeeTO emp){
        
        Employees.add(emp);
        
    }
    private void addObjective(ObjectiveTO obj){
        
        Objectives.add(obj);
        
    }

    
    
    public MeetingTO() {
    }

    public MeetingTO(int id, int status, Date meetingDate, Date objectiveDate, int idManager) {
        this.id = id;
        this.status = status;
        this.meetingDate = meetingDate;
        this.objectiveDate = objectiveDate;
        this.idManager = idManager;
    }
    

    public MeetingTO(int id, int status, Date meetingDate, Date objectiveDate, int idManager, List<EmployeeTO> Employees, List<ObjectiveTO> Objectives) {
        this.id = id;
        this.status = status;
        this.meetingDate = meetingDate;
        this.objectiveDate = objectiveDate;
        this.idManager = idManager;
        this.Employees = Employees;
        this.Objectives = Objectives;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(Date meetingDate) {
        this.meetingDate = meetingDate;
    }

    public Date getObjectiveDate() {
        return objectiveDate;
    }

    public void setObjectiveDate(Date objectiveDate) {
        this.objectiveDate = objectiveDate;
    }

    public int getIdManager() {
        return idManager;
    }

    public void setIdManager(int idManager) {
        this.idManager = idManager;
    }

    public List<EmployeeTO> getEmployees() {
        return Employees;
    }

    public void setEmployees(List<EmployeeTO> Employees) {
        this.Employees = Employees;
    }

    public List<ObjectiveTO> getObjectives() {
        return Objectives;
    }

    public void setObjectives(List<ObjectiveTO> Objectives) {
        this.Objectives = Objectives;
    }

    
    

    
}
