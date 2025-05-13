
package BusinessEntity;
import java.util.Date;

public class PacienteBE {
   private String id_paciente;
   private String identificador_externo;
   private String nombre;
   private String apellido;
   private Date fecha_nacimiento;
   private String sexo;
   private String direccion;
   private String telefono;
   private String correo;

    public PacienteBE() {
    }

    public PacienteBE(String id_paciente, String identificador_externo, String nombre, String apellido, Date fecha_nacimiento, String sexo, String direccion, String telefono, String correo) {
        this.id_paciente = id_paciente;
        this.identificador_externo = identificador_externo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.sexo = sexo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(String id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getIdentificador_externo() {
        return identificador_externo;
    }

    public void setIdentificador_externo(String identificador_externo) {
        this.identificador_externo = identificador_externo;
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

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
