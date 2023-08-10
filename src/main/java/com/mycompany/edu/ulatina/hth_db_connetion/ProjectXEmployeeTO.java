
package com.mycompany.edu.ulatina.hth_db_connetion;

import java.io.Serializable;

public class ProjectXEmployeeTO implements Serializable {

    private int id;
    private int idProject;
    private int idEmployee;

    public ProjectXEmployeeTO() {
    }

    public ProjectXEmployeeTO(int id, int idProject, int idEmployee) {
        this.id = id;
        this.idProject = idProject;
        this.idEmployee = idEmployee;
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

}
