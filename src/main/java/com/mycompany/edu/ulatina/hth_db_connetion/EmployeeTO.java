package com.mycompany.edu.ulatina.hth_db_connetion;

import java.io.Serializable;
import java.sql.Date;

public class EmployeeTO implements Serializable {
    private int id;
    private String firstName;
    private String lastName;
    private String identification;
    private String email;
    private String phone;
    private int type;
    private int status;
    private String password;
    private Date layoffDate;
    private Date employmentDate;
    private int idSupervisor;

    public EmployeeTO() {
    }

    public EmployeeTO(int id, String firstName, String lastName, String identification, String email, String phone, int type, int status, String password, Date layoffDate, Date employmentDate, int idSupervisor) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identification = identification;
        this.email = email;
        this.phone = phone;
        this.type = type;
        this.status = status;
        this.password = password;
        this.layoffDate = layoffDate;
        this.employmentDate = employmentDate;
        this.idSupervisor = idSupervisor;
    }

    public EmployeeTO(int id, String firstName, String lastName, String identification, String email, String phone, int type, int status, String password, Date employmentDate, int idSupervisor) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identification = identification;
        this.email = email;
        this.phone = phone;
        this.type = type;
        this.status = status;
        this.password = password;
        this.employmentDate = employmentDate;
        this.idSupervisor = idSupervisor;
    }
    
    public EmployeeTO(int id, String firstName, String lastName, String identification, String email, String phone, int type, int status, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identification = identification;
        this.email = email;
        this.phone = phone;
        this.type = type;
        this.status = status;
        this.password = password;
        long millis=System.currentTimeMillis();  
        java.sql.Date date = new java.sql.Date(millis); 
        this.employmentDate = date;
    }

    public EmployeeTO(int id, String firstName, String lastName, String identification, String email, String phone, int type, int status, String password, Date employmentDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identification = identification;
        this.email = email;
        this.phone = phone;
        this.type = type;
        this.status = status;
        this.password = password;
        this.employmentDate = employmentDate;
    }

    public EmployeeTO(int id, String firstName, String lastName, String identification, String email, String phone, int type, int status, String password, Date layoffDate, Date employmentDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identification = identification;
        this.email = email;
        this.phone = phone;
        this.type = type;
        this.status = status;
        this.password = password;
        this.layoffDate = layoffDate;
        this.employmentDate = employmentDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLayoffDate() {
        return layoffDate;
    }

    public void setLayoffDate(Date layoffDate) {
        this.layoffDate = layoffDate;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }
    
    public String getFullName(){
        return firstName + " " + lastName;
    }

    public int getIdSupervisor() {
        return idSupervisor;
    }

    public void setIdSupervisor(int idSupervisor) {
        this.idSupervisor = idSupervisor;
    }
    
    
}
