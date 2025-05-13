/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessEntity;

/**
 *
 * @author SISTEMAS
 */
public class MedicoBE {
    private String id_medico;
    private String nombre;
    private String apellido;
    private String numero_colegiatura;
    private String especialidad_id;
    private String telefono;
    private String correo;

    public MedicoBE() {
    }

    public MedicoBE(String id_medico, String nombre, String apellido, String numero_colegiatura, String especialidad_id, String telefono, String correo) {
        this.id_medico = id_medico;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numero_colegiatura = numero_colegiatura;
        this.especialidad_id = especialidad_id;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getId_medico() {
        return id_medico;
    }

    public void setId_medico(String id_medico) {
        this.id_medico = id_medico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumero_colegiatura() {
        return numero_colegiatura;
    }

    public void setNumero_colegiatura(String numero_colegiatura) {
        this.numero_colegiatura = numero_colegiatura;
    }

    public String getEspecialidad_id() {
        return especialidad_id;
    }

    public void setEspecialidad_id(String especialidad_id) {
        this.especialidad_id = especialidad_id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


}
