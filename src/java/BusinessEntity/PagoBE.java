/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessEntity;

import java.sql.Timestamp;;

/**
 *
 * @author SISTEMAS
 */
public class PagoBE {
    private String idPago;
    private String idCita;
    private String idMetodoPago;
    private String idEstadoPago;
    private double monto;
    private String moneda;
    private Timestamp fechaPago;
    private String transaccionId;

    public PagoBE() {
    }

    public PagoBE(String idPago, String idCita, String idMetodoPago, String idEstadoPago, double monto, String moneda, Timestamp fechaPago, String transaccionId) {
        this.idPago = idPago;
        this.idCita = idCita;
        this.idMetodoPago = idMetodoPago;
        this.idEstadoPago = idEstadoPago;
        this.monto = monto;
        this.moneda = moneda;
        this.fechaPago = fechaPago;
        this.transaccionId = transaccionId;
    }

    public String getIdPago() {
        return idPago;
    }

    public void setIdPago(String idPago) {
        this.idPago = idPago;
    }

    public String getIdCita() {
        return idCita;
    }

    public void setIdCita(String idCita) {
        this.idCita = idCita;
    }

    public String getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(String idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public String getIdEstadoPago() {
        return idEstadoPago;
    }

    public void setIdEstadoPago(String idEstadoPago) {
        this.idEstadoPago = idEstadoPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Timestamp getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Timestamp fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getTransaccionId() {
        return transaccionId;
    }

    public void setTransaccionId(String transaccionId) {
        this.transaccionId = transaccionId;
    }
    
    
}
