
package com.mycompany.edu.ulatina.hth_db_connetion;

import java.io.Serializable;

public class ProjectXEmployeeTO implements Serializable {

    private int id;
    private int idProject;
    private int idEmployee;
    private int hoursInvested;
    private String feedBack;
    private String projectName;
    private String employeeName;

    public ProjectXEmployeeTO() {
    }

    public ProjectXEmployeeTO(int id, int idProject, int idEmployee, int hoursInvested, String feedBack) {
        this.id = id;
        this.idProject = idProject;
        this.idEmployee = idEmployee;
        this.hoursInvested = hoursInvested;
        this.feedBack = feedBack;
    }

    public ProjectXEmployeeTO(int id, int idProject, int idEmployee, int hoursInvested, String feedBack, String projectName) {
        this.id = id;
        this.idProject = idProject;
        this.idEmployee = idEmployee;
        this.hoursInvested = hoursInvested;
        this.feedBack = feedBack;
        this.projectName = projectName;
    }

    public ProjectXEmployeeTO(int id, int hoursInvested, String feedBack, String projectName, String employeeName) {
        this.id = id;
        this.hoursInvested = hoursInvested;
        this.feedBack = feedBack;
        this.projectName = projectName;
        this.employeeName = employeeName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
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
