/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessEntity;

import java.security.Timestamp;

/**
 *
 * @author SISTEMAS
 */
public class AtencionBE {
     private String idAtencion;
    private String idCita;
    private Timestamp fechaInicio;
    private Timestamp fechaFin;
    private String observaciones;

    public AtencionBE() {
    }

    public AtencionBE(String idAtencion, String idCita, Timestamp fechaInicio, Timestamp fechaFin, String observaciones) {
        this.idAtencion = idAtencion;
        this.idCita = idCita;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.observaciones = observaciones;
    }

    public String getIdAtencion() {
        return idAtencion;
    }

    public void setIdAtencion(String idAtencion) {
        this.idAtencion = idAtencion;
    }

    public String getIdCita() {
        return idCita;
    }

    public void setIdCita(String idCita) {
        this.idCita = idCita;
    }

    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Timestamp getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Timestamp fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
}
