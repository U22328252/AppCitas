/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import BusinessEntity.MedicoBE;
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
public class MedicoDAO extends Conexion implements IBaseDAO<MedicoBE> {

    @Override
    public boolean Crear(MedicoBE input) {
         boolean result = false;
        try {
            String sql = "INSERT INTO medico VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = getConexion().prepareStatement(sql);
            pst.setString(1, UUID.randomUUID().toString());
            pst.setString(2, input.getNombre());
            pst.setString(3, input.getApellido());
            pst.setString(4, input.getNumero_colegiatura());
            pst.setString(5, input.getEspecialidad_id());
            pst.setString(6, input.getTelefono());
            pst.setString(7, input.getCorreo());
            pst.executeUpdate();
        } catch (SQLException e) {
             System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public MedicoBE obtenerPorId(String input) {
        MedicoBE medico = new MedicoBE();
        try {
             PreparedStatement pst = getConexion().prepareStatement("SELECT * FROM medico WHERE id_medico = ?");
             pst.setString(1, input);
             ResultSet rs = pst.executeQuery();
             while (rs.next()) {
                
                medico.setId_medico(rs.getString("id_medico"));
                medico.setNombre(rs.getString("nombre"));
                medico.setApellido(rs.getString("apellido"));
                medico.setNumero_colegiatura(rs.getString("numero_colegiatura"));
                medico.setEspecialidad_id(rs.getString("especialidad_id"));
                medico.setTelefono(rs.getString("telefono"));
                medico.setCorreo(rs.getString("correo"));       
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return medico;
    }

    @Override
    public ArrayList<MedicoBE> obtenerTodos() {
        ArrayList<MedicoBE> lstMedico = null;//NULA
        try {
            Statement stm = getConexion().createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM medico");
            lstMedico = new ArrayList<>();//VACIA
            while (rs.next()) {
                MedicoBE medico = new MedicoBE();
        
                medico.setId_medico(rs.getString("id_medico"));
                medico.setNombre(rs.getString("nombre"));
                medico.setApellido(rs.getString("apellido"));
                medico.setNumero_colegiatura(rs.getString("numero_colegiatura"));
                medico.setEspecialidad_id(rs.getString("especialidad_id"));
                medico.setTelefono(rs.getString("telefono"));
                medico.setCorreo(rs.getString("correo"));
                lstMedico.add(medico);
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lstMedico;
    }

    @Override
    public boolean Actualizar(MedicoBE input) {
        boolean result = false;
        try {
            String SQL = "UPDATE medico SET nombre=?, apellido=?, numero_colegiatura=?, especialidad_id=?, telefono=?, correo=? WHERE id_medico=?";
            PreparedStatement pst = getConexion().prepareStatement(SQL);
             pst.setString(1, input.getNombre());
            pst.setString(2, input.getApellido());
            pst.setString(3, input.getNumero_colegiatura());
            pst.setString(4, input.getEspecialidad_id());
            pst.setString(5, input.getTelefono());
            pst.setString(6, input.getCorreo());
            pst.setString(7, input.getId_medico());       
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
                    getConexion().prepareStatement("DELETE FROM medico WHERE id_medico=?");
            pst.setString(1, input);
            result = pst.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

   
    
}
