/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edu.ulatina.hth_db_connetion;

import java.io.Serializable;

/**
 *
 * @author javi
 */
public class ActivityTO implements Serializable{
    
    private int id;
    private int idEmployee;
    private int idProject;
    private String Name;
    private String Description;
    private double hours;

    public ActivityTO() {
    }

    public ActivityTO(int id, int idEmployee, int idProject, String Name, String Description, double hours) {
        this.id = id;
        this.idEmployee = idEmployee;
        this.idProject = idProject;
        this.Name = Name;
        this.Description = Description;
        this.hours = hours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    
    
}
