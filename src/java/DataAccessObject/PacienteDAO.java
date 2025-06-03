/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import BusinessEntity.PacienteBE;
import java.sql.Date;
import java.util.UUID;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author SISTEMAS
 */
public class PacienteDAO extends Conexion implements IBaseDAO<PacienteBE>{

    @Override
    public boolean Crear(PacienteBE input) {
        boolean result = false;
        try {
            String sql = "INSERT INTO paciente VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
             PreparedStatement stmt = getConexion().prepareStatement(sql);
            stmt.setString(1,  UUID.randomUUID().toString());
            stmt.setString(2, input.getIdentificador_externo());
            stmt.setString(3, input.getNombre());
            stmt.setString(4, input.getApellido());
            stmt.setDate(5, (Date) input.getFecha_nacimiento());
            stmt.setString(6, input.getSexo());
            stmt.setString(7, input.getDireccion());
            stmt.setString(8, input.getTelefono());
            stmt.setString(9, input.getCorreo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public PacienteBE obtenerPorId(String input) {
       PacienteBE paciente = new PacienteBE();
        try {
             PreparedStatement pst = getConexion().prepareStatement("SELECT * FROM paciente WHERE Identificador_externo=?");
             pst.setString(2, input);
             ResultSet rs = pst.executeQuery();
             while (rs.next()) {
                paciente.setId_paciente(rs.getString("id_paciente"));
                paciente.setIdentificador_externo(rs.getString("identificador_externo"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setApellido(rs.getString("apellido"));
                paciente.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                paciente.setSexo(rs.getString("sexo"));
                paciente.setDireccion(rs.getString("direccion"));
                paciente.setTelefono(rs.getString("telefono"));
                paciente.setCorreo(rs.getString("correo"));
              
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return paciente;
    }

    @Override
    public ArrayList<PacienteBE> obtenerTodos() {
       ArrayList<PacienteBE> lstPaciente = null;//NULA
        try {
            Statement stm = getConexion().createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM paciente");
            lstPaciente = new ArrayList<>();//VACIA
            while (rs.next()) {
                PacienteBE paciente= new PacienteBE();
        
                paciente.setId_paciente(rs.getString("id_paciente"));
                paciente.setIdentificador_externo(rs.getString("identificador_externo"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setApellido(rs.getString("apellido"));
                paciente.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                paciente.setSexo(rs.getString("sexo"));
                paciente.setDireccion(rs.getString("direccion"));
                paciente.setTelefono(rs.getString("telefono"));
                paciente.setCorreo(rs.getString("correo"));
                lstPaciente.add(paciente);
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lstPaciente;
    }

    @Override
    public boolean Actualizar(PacienteBE input) {
         boolean result = false;
        try {
            String SQL = "UPDATE paciente SET identificador_externo=?, nombre=?, apellido=?, fecha_nacimiento=?, sexo=?, direccion=?, telefono=?, correo=? WHERE id_paciente=?";
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            pst.setString(1, input.getIdentificador_externo());
            pst.setString(2, input.getNombre());
            pst.setString(3, input.getApellido());
            pst.setDate(5, (Date) input.getFecha_nacimiento()/*.getTime()*/);
            pst.setString(5, input.getSexo());
            pst.setString(6, input.getDireccion());
            pst.setString(7, input.getTelefono());
            pst.setString(8, input.getCorreo());
            pst.setString(9, input.getId_paciente());
            pst.executeUpdate();
            result = pst.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public boolean Eliminar(String input) {
        boolean result = false;
        try {
            PreparedStatement pst = 
                    getConexion().prepareStatement("DELETE FROM paciente WHERE id_paciente=?");
            pst.setString(1, input);
            result = pst.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
}
