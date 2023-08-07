/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author julio
 */
public class SalidaTO implements Serializable{
    
    private int id;
    private Date fechaSalida;
    private Date fechaRegreso;
    private String observacion;
    private int idLibro;
    private int idUsuario;

    public SalidaTO() {
    }

    public SalidaTO(int id, Date fechaSalida, Date fechaRegreso, String observacion, int idLibro, int idUsuario) {
        this.id = id;
        this.fechaSalida = fechaSalida;
        this.fechaRegreso = fechaRegreso;
        this.observacion = observacion;
        this.idLibro = idLibro;
        this.idUsuario = idUsuario;
    }

    public int getId() {
        return id;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public Date getFechaRegreso() {
        return fechaRegreso;
    }

    public String getObservacion() {
        return observacion;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void setFechaRegreso(Date fechaRegreso) {
        this.fechaRegreso = fechaRegreso;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
    
    
    
}










