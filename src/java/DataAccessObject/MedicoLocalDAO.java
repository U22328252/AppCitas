/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import BusinessEntity.MedicoLocalBE;
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
public class MedicoLocalDAO extends Conexion implements IBaseDAO<MedicoLocalBE> {

    @Override
    public boolean Crear(MedicoLocalBE input) {
        boolean result = false;
        try {
            String sql = "INSERT INTO medico_local VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = getConexion().prepareStatement(sql);
            pst.setString(1, UUID.randomUUID().toString());
            pst.setString(2, input.getIdMedico());
            pst.setString(3, input.getIdLocal());
            pst.setString(4, input.getRol());
            pst.setBoolean(5, input.isActivo());
            pst.executeUpdate();
        } catch (SQLException e) {
             System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public MedicoLocalBE obtenerPorId(String input) {
        MedicoLocalBE medicoLocal = new MedicoLocalBE();
        try {
             PreparedStatement pst = getConexion().prepareStatement("SELECT * FROM medico_local WHERE id_medico_local = ?");
             pst.setString(1, input);
             ResultSet rs = pst.executeQuery();
             while (rs.next()) {
                
                medicoLocal.setIdMedicoLocal(rs.getString("id_medico_local"));
                medicoLocal.setIdMedico(rs.getString("id_medico"));
                medicoLocal.setIdLocal(rs.getString("id_local"));
                medicoLocal.setRol(rs.getString("rol"));
                medicoLocal.setActivo(rs.getBoolean("activo"));       
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return medicoLocal;
    }

    @Override
    public ArrayList<MedicoLocalBE> obtenerTodos() {
         ArrayList<MedicoLocalBE> lstMedicoLocal = null;//NULA
        try {
            Statement stm = getConexion().createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM medico_local");
            lstMedicoLocal = new ArrayList<>();//VACIA
            while (rs.next()) {
                MedicoLocalBE medicoLocal = new MedicoLocalBE();
        
                medicoLocal.setIdMedicoLocal(rs.getString("id_medico_local"));
                medicoLocal.setIdMedico(rs.getString("id_medico"));
                medicoLocal.setIdLocal(rs.getString("id_local"));
                medicoLocal.setRol(rs.getString("rol"));
                medicoLocal.setActivo(rs.getBoolean("activo"));
                lstMedicoLocal.add(medicoLocal);
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lstMedicoLocal;
    }

    @Override
    public boolean Actualizar(MedicoLocalBE input) {
        boolean result = false;
        try {
            String SQL = "UPDATE medico_local SET id_medico=?, id_local=?, rol=?, activo=? WHERE id_medico_local=?";
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            pst.setString(1, input.getIdMedico());
            pst.setString(2, input.getIdLocal());
            pst.setString(3, input.getRol());
            pst.setBoolean(4, input.isActivo());
            pst.setString(5, input.getIdMedicoLocal());      
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
                    getConexion().prepareStatement("DELETE FROM medico_local WHERE id_medico_local=?");
            pst.setString(1, input);
            result = pst.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    
}
