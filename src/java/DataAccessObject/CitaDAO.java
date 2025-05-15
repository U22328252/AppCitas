/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import BusinessEntity.CitaBE;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author SISTEMAS
 */
public class CitaDAO extends Conexion implements IBaseDAO<CitaBE> {

    @Override
    public boolean Crear(CitaBE input) {
         boolean result = false;
        try {
            String sql = "INSERT INTO cita VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
             PreparedStatement stmt = getConexion().prepareStatement(sql);
            stmt.setString(1, input.getId_cita());
            stmt.setString(2, input.getId_paciente());
            stmt.setString(3, input.getId_medico());
            stmt.setString(4, input.getId_local());
            stmt.setDate(5, (Date)input.getFecha());
            stmt.setDate(6, (Date)input.gethora_inicio());
            stmt.setDate(7, (Date)input.getHora_fin());
            stmt.setString(8, input.getEstado());
            stmt.setString(9, input.getMotivo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public CitaBE obtenerPorId(String input) {
        CitaBE cita = new CitaBE();
        try {
             PreparedStatement pst = getConexion().prepareStatement("SELECT * FROM cita WHERE id_cita = ?");
             pst.setString(1, input);
             ResultSet rs = pst.executeQuery();
             while (rs.next()) {
                cita.setId_cita(rs.getString("id_cita"));
                cita.setId_paciente(rs.getString("id_paciente"));
                cita.setId_medico(rs.getString("id_medico"));
                cita.setId_local(rs.getString("id_local"));
                cita.setFecha(rs.getDate("fecha"));
                cita.sethora_inicio(rs.getTime("hora_inicio"));
                cita.setHora_fin(rs.getTime("hora_fin"));
                cita.setEstado(rs.getString("estado"));
                cita.setMotivo(rs.getString("motivo"));
              
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cita;
    }

    @Override
    public ArrayList<CitaBE> obtenerTodos() {
        ArrayList<CitaBE> lstCita = null;//NULA
        try {
            Statement stm = getConexion().createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM cita");
            lstCita = new ArrayList<>();//VACIA
            while (rs.next()) {
                CitaBE cita = new CitaBE();
        
                cita.setId_cita(rs.getString("id_cita"));
                cita.setId_paciente(rs.getString("id_paciente"));
                cita.setId_medico(rs.getString("id_medico"));
                cita.setId_local(rs.getString("id_local"));
                cita.setFecha(rs.getDate("fecha"));
                cita.sethora_inicio(rs.getTime("hora_inicio"));
                cita.setHora_fin(rs.getTime("hora_fin"));
                cita.setEstado(rs.getString("estado"));
                cita.setMotivo(rs.getString("motivo"));
                lstCita.add(cita);
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lstCita;
    }

    @Override
    public boolean Actualizar(CitaBE input) {
        boolean result = false;
        try {
            String SQL = "UPDATE cita SET id_paciente=?, id_medico=?, id_local=?, fecha=?, hora_inicio=?, hora_fin=?, estado=?, motivo=? WHERE id_cita=?";
            PreparedStatement stmt = getConexion().prepareStatement(SQL);
            stmt.setString(1, input.getId_paciente());
            stmt.setString(2, input.getId_medico());
            stmt.setString(3, input.getId_local());
            stmt.setDate(4, (Date)input.getFecha());
            stmt.setDate(5, (Date)input.gethora_inicio());
            stmt.setDate(6, (Date)input.getHora_fin());
            stmt.setString(7, input.getEstado());
            stmt.setString(8, input.getMotivo());
            stmt.setString(9, input.getId_cita());
            stmt.executeUpdate();
            result = stmt.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public boolean Eliminar(String input) {
        boolean result = false;
        try {
            PreparedStatement pst = 
                    getConexion().prepareStatement("DELETE FROM cita WHERE id_cita=?");
            pst.setString(1, input);
            result = pst.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

   
   
    
}
