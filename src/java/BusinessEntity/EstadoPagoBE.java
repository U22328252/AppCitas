/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessEntity;

/**
 *
 * @author SISTEMAS
 */
public class EstadoPagoBE {
    private String idEstadoPago;
    private String descripcion;

    public EstadoPagoBE() {
    }

    public EstadoPagoBE(String idEstadoPago, String descripcion) {
        this.idEstadoPago = idEstadoPago;
        this.descripcion = descripcion;
    }

    public String getIdEstadoPago() {
        return idEstadoPago;
    }

    public void setIdEstadoPago(String idEstadoPago) {
        this.idEstadoPago = idEstadoPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
