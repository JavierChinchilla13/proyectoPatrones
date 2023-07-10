package com.mycompany.edu.ulatina.hth_db_connetion;

import java.io.Serializable;

public class DocumentTO implements Serializable {
    private int id;
    private int idEmployee;
    private String path;

    public DocumentTO() {
    }

    public DocumentTO(int id, int idEmployee, String path) {
        this.id = id;
        this.idEmployee = idEmployee;
        this.path = path;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
}
