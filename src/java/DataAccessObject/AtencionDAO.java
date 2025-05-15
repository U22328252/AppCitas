/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import BusinessEntity.AtencionBE;
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
public class AtencionDAO extends Conexion implements IBaseDAO<AtencionBE> {

    @Override
    public boolean Crear(AtencionBE input) {
        boolean result = false;
        try {
            String sql = "INSERT INTO atencion VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = getConexion().prepareStatement(sql);
            pst.setString(1, UUID.randomUUID().toString());
            pst.setString(2, input.getIdCita());
            pst.setTimestamp(3, input.getFechaInicio());
            pst.setTimestamp(4, input.getFechaFin());
            pst.setString(5, input.getObservaciones());
            pst.executeUpdate();
        } catch (SQLException e) {
             System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public AtencionBE obtenerPorId(String input) {
        AtencionBE atencion = new AtencionBE();
        try {
             PreparedStatement pst = getConexion().prepareStatement("SELECT * FROM atencion WHERE id_atencion = ?");
             pst.setString(1, input);
             ResultSet rs = pst.executeQuery();
             while (rs.next()) {
                
                atencion.setIdAtencion(rs.getString("id_atencion"));
                atencion.setIdCita(rs.getString("id_cita"));
                atencion.setFechaInicio(rs.getTimestamp("fecha_inicio"));
                atencion.setFechaFin(rs.getTimestamp("fecha_fin"));
                atencion.setObservaciones(rs.getString("observaciones"));           
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return atencion;
    }

    @Override
    public ArrayList<AtencionBE> obtenerTodos() {
         ArrayList<AtencionBE> lstAtencion = null;//NULA
        try {
            Statement stm = getConexion().createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM atencion");
            lstAtencion = new ArrayList<>();//VACIA
            while (rs.next()) {
                AtencionBE atencion = new AtencionBE();
        
                atencion.setIdAtencion(rs.getString("id_atencion"));
                atencion.setIdCita(rs.getString("id_cita"));
                atencion.setFechaInicio(rs.getTimestamp("fecha_inicio"));
                atencion.setFechaFin(rs.getTimestamp("fecha_fin"));
                atencion.setObservaciones(rs.getString("observaciones"));
                lstAtencion.add(atencion);
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lstAtencion;
    }

    @Override
    public boolean Actualizar(AtencionBE input) {
         boolean result = false;
        try {
            String SQL = "UPDATE atencion SET id_cita=?, fecha_inicio=?, fecha_fin=?, observaciones=? WHERE id_atencion=?";
            PreparedStatement pst = getConexion().prepareStatement(SQL);
             pst.setString(1, input.getIdCita());
             pst.setTimestamp(2, input.getFechaInicio());
             pst.setTimestamp(3, input.getFechaFin());
             pst.setString(4, input.getObservaciones());
             pst.setString(5, input.getIdAtencion());            
            pst.executeUpdate();
            result = pst.execute();
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
                    getConexion().prepareStatement("DELETE FROM atencion WHERE id_atencion=?");
            pst.setString(1, input);
            result = pst.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

}
