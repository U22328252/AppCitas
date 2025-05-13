/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessEntity;

/**
 *
 * @author SISTEMAS
 */
public class DiagnosticoBE {
    private String idDiagnostico;
    private String idAtencion;
    private String descripcion;
    private String cie10Codigo;  

    public DiagnosticoBE() {
    }

    public DiagnosticoBE(String idDiagnostico, String idAtencion, String descripcion, String cie10Codigo) {
        this.idDiagnostico = idDiagnostico;
        this.idAtencion = idAtencion;
        this.descripcion = descripcion;
        this.cie10Codigo = cie10Codigo;
    }

    public String getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(String idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public String getIdAtencion() {
        return idAtencion;
    }

    public void setIdAtencion(String idAtencion) {
        this.idAtencion = idAtencion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCie10Codigo() {
        return cie10Codigo;
    }

    public void setCie10Codigo(String cie10Codigo) {
        this.cie10Codigo = cie10Codigo;
    }
    
    
}
