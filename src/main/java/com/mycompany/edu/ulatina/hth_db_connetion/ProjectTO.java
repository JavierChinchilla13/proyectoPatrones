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
public class ProjectTO implements Serializable{
    private int id;
    private String name;
    private int status;
    private Date startingDate;
    private Date endingDate;
    private List<EmployeeTO> Employees = new ArrayList<>();

    public ProjectTO() {
    }

    public ProjectTO(int id, String name, int status, Date startingDate, Date endingDate) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
    }

    public ProjectTO(int id, String name, int status, Date startingDate, Date endingDate, List<EmployeeTO> Employees) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.Employees = Employees;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public List<EmployeeTO> getEmployees() {
        return Employees;
    }

    public void setEmployees(List<EmployeeTO> Employees) {
        this.Employees = Employees;
    }
    
}
