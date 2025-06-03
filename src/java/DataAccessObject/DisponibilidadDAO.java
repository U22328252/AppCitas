/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import BusinessEntity.DisponibilidadBE;
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
public class DisponibilidadDAO extends Conexion implements IBaseDAO<DisponibilidadBE> {

    @Override
    public boolean Crear(DisponibilidadBE input) {
         boolean result = false;
        try {
            String sql = "INSERT INTO disponibilidad VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = getConexion().prepareStatement(sql);
            pst.setString(1, UUID.randomUUID().toString());
            pst.setString(2, input.getIdMedicoLocal());
            pst.setString(3, input.getDiaSemana());
            pst.setTimestamp(4, input.getHoraInicio());
            pst.setTimestamp(5, input.getHoraFin());
            pst.setBoolean(6, input.isActivo());
            pst.executeUpdate();
        } catch (SQLException e) {
             System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public DisponibilidadBE obtenerPorId(String input) {
        DisponibilidadBE disponibilidad = new DisponibilidadBE();
        try {
             PreparedStatement pst = getConexion().prepareStatement("SELECT * FROM disponibilidad WHERE id_disponibilidad = ?");
             pst.setString(1, input);
             ResultSet rs = pst.executeQuery();
             while (rs.next()) {
                
               disponibilidad.setIdDisponibilidad(rs.getString("id_disponibilidad"));
               disponibilidad.setIdMedicoLocal(rs.getString("id_medico_local"));
               disponibilidad.setDiaSemana(rs.getString("dia_semana"));
               disponibilidad.setHoraInicio(rs.getTimestamp("hora_inicio"));
               disponibilidad.setHoraFin(rs.getTimestamp("hora_fin"));
               disponibilidad.setActivo(rs.getBoolean("activo"));       
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return disponibilidad;
    }

    @Override
    public ArrayList<DisponibilidadBE> obtenerTodos() {
        ArrayList<DisponibilidadBE> lsDisponibilidad = null;//NULA
        try {
            Statement stm = getConexion().createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM disponibilidad");
            lsDisponibilidad = new ArrayList<>();//VACIA
            while (rs.next()) {
                DisponibilidadBE disponibilidad = new DisponibilidadBE();
        
                disponibilidad.setIdDisponibilidad(rs.getString("id_disponibilidad"));
                disponibilidad.setIdMedicoLocal(rs.getString("id_medico_local"));
                disponibilidad.setDiaSemana(rs.getString("dia_semana"));
                disponibilidad.setHoraInicio(rs.getTimestamp("hora_inicio"));
                disponibilidad.setHoraFin(rs.getTimestamp("hora_fin"));
                disponibilidad.setActivo(rs.getBoolean("activo"));
                lsDisponibilidad.add(disponibilidad);
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lsDisponibilidad;
    }

    @Override
    public boolean Actualizar(DisponibilidadBE input) {
        boolean result = false;
        try {
            String SQL = "UPDATE disponibilidad SET id_medico_local=?, dia_semana=?, hora_inicio=?, hora_fin=?, activo=? WHERE id_disponibilidad=?";
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            pst.setString(1, input.getIdMedicoLocal());
            pst.setString(2, input.getDiaSemana());
            pst.setTimestamp(3, input.getHoraInicio());
            pst.setTimestamp(4, input.getHoraFin());
            pst.setBoolean(5, input.isActivo());
            pst.setString(6, input.getIdDisponibilidad());           
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
                    getConexion().prepareStatement("DELETE FROM disponibilidad WHERE id_disponibilidad=?");
            pst.setString(1, input);
            result = pst.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

  
    
}
