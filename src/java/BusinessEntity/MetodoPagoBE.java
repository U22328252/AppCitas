/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessEntity;

/**
 *
 * @author SISTEMAS
 */
public class MetodoPagoBE {
     private String idMetodoPago;
    private String nombre;
    private String tipo;
    private String proveedor;

    public MetodoPagoBE(String idMetodoPago, String nombre, String tipo, String proveedor) {
        this.idMetodoPago = idMetodoPago;
        this.nombre = nombre;
        this.tipo = tipo;
        this.proveedor = proveedor;
    }

    public MetodoPagoBE() {
    }

    public String getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(String idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
    
    
}
