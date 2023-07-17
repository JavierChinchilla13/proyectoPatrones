/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edu.ulatina.hth_db_connetion;

import java.io.Serializable;

/**
 *
 * @author Ale
 */
public class ProjectXEmployeeTO implements Serializable {

    private int id;
    private int idProject;
    private int idEmployee;
    private int hoursInvested;
    private String feedBack;

    public ProjectXEmployeeTO() {
    }

    public ProjectXEmployeeTO(int id, int idProject, int idEmployee, int hoursInvested, String feedBack) {
        this.id = id;
        this.idProject = idProject;
        this.idEmployee = idEmployee;
        this.hoursInvested = hoursInvested;
        this.feedBack = feedBack;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getHoursInvested() {
        return hoursInvested;
    }

    public void setHoursInvested(int hoursInvested) {
        this.hoursInvested = hoursInvested;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

}
