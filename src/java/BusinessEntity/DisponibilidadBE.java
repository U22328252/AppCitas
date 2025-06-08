/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessEntity;

import java.sql.Timestamp;

/**
 *
 * @author SISTEMAS
 */
public class DisponibilidadBE {
    private String idDisponibilidad;
    private String idMedicoLocal;
    private String diaSemana;
    private Timestamp horaInicio;
    private Timestamp horaFin;
    private boolean activo;

    public DisponibilidadBE() {
    }

    public DisponibilidadBE(String idDisponibilidad, String idMedicoLocal, String diaSemana, Timestamp horaInicio, Timestamp horaFin, boolean activo) {
        this.idDisponibilidad = idDisponibilidad;
        this.idMedicoLocal = idMedicoLocal;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.activo = activo;
    }

    public String getIdDisponibilidad() {
        return idDisponibilidad;
    }

    public void setIdDisponibilidad(String idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }

    public String getIdMedicoLocal() {
        return idMedicoLocal;
    }

    public void setIdMedicoLocal(String idMedicoLocal) {
        this.idMedicoLocal = idMedicoLocal;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Timestamp getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Timestamp horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Timestamp getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Timestamp horaFin) {
        this.horaFin = horaFin;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
}
