/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import BusinessEntity.LocalBE;
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
public class LocalDAO extends Conexion implements IBaseDAO<LocalBE> {

    @Override
    public boolean Crear(LocalBE input) {
        boolean result = false;
        try {
            String sql = "INSERT INTO local VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = getConexion().prepareStatement(sql);
            pst.setString(1, UUID.randomUUID().toString());
            pst.setString(2, input.getNombre());
            pst.setString(3, input.getDireccion());
            pst.setString(4, input.getTelefono());
            pst.setString(5, input.getCorreo());
            pst.executeUpdate();
        } catch (SQLException e) {
             System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public LocalBE obtenerPorId(String input) {
         LocalBE local = new LocalBE();
        try {
             PreparedStatement pst = getConexion().prepareStatement("SELECT * FROM local WHERE id_local = ?");
             pst.setString(1, input);
             ResultSet rs = pst.executeQuery();
             while (rs.next()) {
                
                local.setId_local(rs.getString("id_local"));
                local.setNombre(rs.getString("nombre"));
                local.setDireccion(rs.getString("direccion"));
                local.setTelefono(rs.getString("telefono"));
                local.setCorreo(rs.getString("correo"));         
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return local;
    }

    @Override
    public ArrayList<LocalBE> obtenerTodos() {
         ArrayList<LocalBE> lstLocal = null;//NULA
        try {
            Statement stm = getConexion().createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM local");
            lstLocal = new ArrayList<>();//VACIA
            while (rs.next()) {
                LocalBE local = new LocalBE();
        
                local.setId_local(rs.getString("id_local"));
                local.setNombre(rs.getString("nombre"));
                local.setDireccion(rs.getString("direccion"));
                local.setTelefono(rs.getString("telefono"));
                local.setCorreo(rs.getString("correo"));
                lstLocal.add(local);
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lstLocal;
    }

    @Override
    public boolean Actualizar(LocalBE input) {
        boolean result = false;
        try {
            String SQL = "UPDATE local SET nombre=?, direccion=?, telefono=?, correo=? WHERE id_local=?";
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            pst.setString(1, input.getNombre());
            pst.setString(2, input.getDireccion());
            pst.setString(3, input.getTelefono());
            pst.setString(4, input.getCorreo());
            pst.setString(5, input.getId_local());          
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
                    getConexion().prepareStatement("DELETE FROM local WHERE id_local=?");
            pst.setString(1, input);
            result = pst.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    
}
