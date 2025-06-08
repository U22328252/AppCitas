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
public class ComprobantePagoBE {
    private String idComprobante;
    private String idPago;
    private String idTipoComprobante;
    private String serie;
    private String numero;
    private String rucEmisor;
    private String razonSocialEmisor;
    private String direccionEmisor;
    private Timestamp fechaEmision;
    private String urlPdf;
    private String urlXml;

    public ComprobantePagoBE() {
    }

    public ComprobantePagoBE(String idComprobante, String idPago, String idTipoComprobante, String serie, String numero, String rucEmisor, String razonSocialEmisor, String direccionEmisor, Timestamp fechaEmision, String urlPdf, String urlXml) {
        this.idComprobante = idComprobante;
        this.idPago = idPago;
        this.idTipoComprobante = idTipoComprobante;
        this.serie = serie;
        this.numero = numero;
        this.rucEmisor = rucEmisor;
        this.razonSocialEmisor = razonSocialEmisor;
        this.direccionEmisor = direccionEmisor;
        this.fechaEmision = fechaEmision;
        this.urlPdf = urlPdf;
        this.urlXml = urlXml;
    }

    public String getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(String idComprobante) {
        this.idComprobante = idComprobante;
    }

    public String getIdPago() {
        return idPago;
    }

    public void setIdPago(String idPago) {
        this.idPago = idPago;
    }

    public String getIdTipoComprobante() {
        return idTipoComprobante;
    }

    public void setIdTipoComprobante(String idTipoComprobante) {
        this.idTipoComprobante = idTipoComprobante;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRucEmisor() {
        return rucEmisor;
    }

    public void setRucEmisor(String rucEmisor) {
        this.rucEmisor = rucEmisor;
    }

    public String getRazonSocialEmisor() {
        return razonSocialEmisor;
    }

    public void setRazonSocialEmisor(String razonSocialEmisor) {
        this.razonSocialEmisor = razonSocialEmisor;
    }

    public String getDireccionEmisor() {
        return direccionEmisor;
    }

    public void setDireccionEmisor(String direccionEmisor) {
        this.direccionEmisor = direccionEmisor;
    }

    public Timestamp getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Timestamp fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getUrlPdf() {
        return urlPdf;
    }

    public void setUrlPdf(String urlPdf) {
        this.urlPdf = urlPdf;
    }

    public String getUrlXml() {
        return urlXml;
    }

    public void setUrlXml(String urlXml) {
        this.urlXml = urlXml;
    }
    
}
