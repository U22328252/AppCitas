/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessEntity;

/**
 *
 * @author SISTEMAS
 */
public class MedicoLocalBE {
    private String idMedicoLocal;
    private String idMedico;
    private String idLocal;
    private String rol;
    private boolean activo;

    public MedicoLocalBE() {
    }

    public MedicoLocalBE(String idMedicoLocal, String idMedico, String idLocal, String rol, boolean activo) {
        this.idMedicoLocal = idMedicoLocal;
        this.idMedico = idMedico;
        this.idLocal = idLocal;
        this.rol = rol;
        this.activo = activo;
    }

    public String getIdMedicoLocal() {
        return idMedicoLocal;
    }

    public void setIdMedicoLocal(String idMedicoLocal) {
        this.idMedicoLocal = idMedicoLocal;
    }

    public String getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(String idMedico) {
        this.idMedico = idMedico;
    }

    public String getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(String idLocal) {
        this.idLocal = idLocal;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
}
