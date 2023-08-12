/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;
import java.sql.Date;

/**
 * Esta clase es exclusiva para los Getters, Setters y constructores
 * de la salida de los libros prestados a los usuarios que se ingresan.
 */

public class SalidaTO implements Serializable{
    
    private int id;
    private String fechaSalida;
    private String fechaRegreso;
    private String observacion;
    private int idLibro;
    private int idUsuario;

    public SalidaTO() {
    }

    public SalidaTO(int id, String fechaSalida, String fechaRegreso, String observacion, int idLibro, int idUsuario) {
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

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFechaRegreso() {
        return fechaRegreso;
    }

    public void setFechaRegreso(String fechaRegreso) {
        this.fechaRegreso = fechaRegreso;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

   
    
}










