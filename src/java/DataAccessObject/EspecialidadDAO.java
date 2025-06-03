/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import BusinessEntity.EspecialidadBE;
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
public class EspecialidadDAO extends Conexion implements IBaseDAO<EspecialidadBE> {

    @Override
    public boolean Crear(EspecialidadBE input) {
        boolean result = false;
        try {
            String sql = "INSERT INTO especialidad VALUES (?, ?, ?)";
            PreparedStatement pst = getConexion().prepareStatement(sql);
            pst.setString(1, UUID.randomUUID().toString());
            pst.setString(2, input.getNombre());
            pst.setString(3, input.getDescripcion());
            pst.executeUpdate();
        } catch (SQLException e) {
             System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public EspecialidadBE obtenerPorId(String input) {
         EspecialidadBE especialidad = new EspecialidadBE();
        try {
             PreparedStatement pst = getConexion().prepareStatement("SELECT * FROM especialidad WHERE id_especialidad = ?");
             pst.setString(1, input);
             ResultSet rs = pst.executeQuery();
             while (rs.next()) {
                
                especialidad.setId_especialidad(rs.getString("id_especialidad"));
                especialidad.setNombre(rs.getString("nombre"));
                especialidad.setDescripcion(rs.getString("descripcion"));       
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return especialidad;
    }

    @Override
    public ArrayList<EspecialidadBE> obtenerTodos() {
       ArrayList<EspecialidadBE> lstEspecialidad = null;//NULA
        try {
            Statement stm = getConexion().createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM especialidad");
            lstEspecialidad = new ArrayList<>();//VACIA
            while (rs.next()) {
                EspecialidadBE especialidad = new EspecialidadBE();
        
                especialidad.setId_especialidad(rs.getString("id_especialidad"));
                especialidad.setNombre(rs.getString("nombre"));
                especialidad.setDescripcion(rs.getString("descripcion"));
                lstEspecialidad.add(especialidad);
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lstEspecialidad;
    }

    @Override
    public boolean Actualizar(EspecialidadBE input) {
        boolean result = false;
        try {
            String SQL = "UPDATE especialidad SET nombre=?, descripcion=? WHERE id_especialidad=?";
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            pst.setString(1, input.getNombre());
            pst.setString(2, input.getDescripcion());
            pst.setString(3, input.getId_especialidad());        
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
                    getConexion().prepareStatement("DELETE FROM especialidad WHERE id_especialidad=?");
            pst.setString(1, input);
            result = pst.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    
    
}
