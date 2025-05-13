


package BusinessEntity;

import java.util.Date;

public class CitaBE {
   private String id_cita;
   private String id_paciente;
   private String id_medico;
   private String id_local;
   private Date fecha;
   private Date TIME;
   private Date hora_fin;
   private String estado;
   private String motivo;  

    public CitaBE() {
    }

    public CitaBE(String id_cita, String id_paciente, String id_medico, String id_local, Date fecha, Date TIME, Date hora_fin, String estado, String motivo) {
        this.id_cita = id_cita;
        this.id_paciente = id_paciente;
        this.id_medico = id_medico;
        this.id_local = id_local;
        this.fecha = fecha;
        this.TIME = TIME;
        this.hora_fin = hora_fin;
        this.estado = estado;
        this.motivo = motivo;
    }

    public String getId_cita() {
        return id_cita;
    }

    public void setId_cita(String id_cita) {
        this.id_cita = id_cita;
    }

    public String getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(String id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getId_medico() {
        return id_medico;
    }

    public void setId_medico(String id_medico) {
        this.id_medico = id_medico;
    }

    public String getId_local() {
        return id_local;
    }

    public void setId_local(String id_local) {
        this.id_local = id_local;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getTIME() {
        return TIME;
    }

    public void setTIME(Date TIME) {
        this.TIME = TIME;
    }

    public Date getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(Date hora_fin) {
        this.hora_fin = hora_fin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    
   
}
