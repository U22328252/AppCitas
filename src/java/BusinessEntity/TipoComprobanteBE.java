/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessEntity;

/**
 *
 * @author SISTEMAS
 */
public class TipoComprobanteBE {
    private String idTipoComprobante;
    private String descripcion;

    public TipoComprobanteBE() {
    }

    public TipoComprobanteBE(String idTipoComprobante, String descripcion) {
        this.idTipoComprobante = idTipoComprobante;
        this.descripcion = descripcion;
    }

    public String getIdTipoComprobante() {
        return idTipoComprobante;
    }

    public void setIdTipoComprobante(String idTipoComprobante) {
        this.idTipoComprobante = idTipoComprobante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
