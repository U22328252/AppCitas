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
            pst.setString(1, input.getIdAtencion());
            pst.setString(2, input.getIdCita());
            pst.setTimestamp(3, input.getFechaInicio());
            pst.setTimestamp(4, input.getFechaFin());
            pst.setString(5, input.getObservaciones());
            pst.executeUpdate();
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public AtencionBE obtenerPorId(String input) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<AtencionBE> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Actualizar(AtencionBE input) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Eliminar(String input) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
