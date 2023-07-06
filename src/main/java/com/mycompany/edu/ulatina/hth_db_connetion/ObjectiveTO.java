package com.mycompany.edu.ulatina.hth_db_connetion;

import java.io.Serializable;

public class ObjectiveTO implements Serializable{
    
    
    private int id;
    private String name;
    private int idMeeting;
    private String description;

    public ObjectiveTO() {
    }

    public ObjectiveTO(int id, String name, int idMeeting, String description) {
        this.id = id;
        this.name = name;
        this.idMeeting = idMeeting;
        this.description = description;
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

    public int getIdMeeting() {
        return idMeeting;
    }

    public void setIdMeeting(int idMeeting) {
        this.idMeeting = idMeeting;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    
            
    
}
