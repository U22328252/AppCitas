/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import BusinessEntity.MetodoPagoBE;
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
public class MetodoPagoDAO extends Conexion implements IBaseDAO< MetodoPagoBE> {

    @Override
    public boolean Crear(MetodoPagoBE input) {
        boolean result = false;
        try {
            String sql = "INSERT INTO metodo_pago VALUES (?, ?, ?, ?)";
            PreparedStatement pst = getConexion().prepareStatement(sql);
            pst.setString(1, UUID.randomUUID().toString());
           pst.setString(2, input.getNombre());
            pst.setString(3, input.getTipo());
            pst.setString(4, input.getProveedor());
            pst.executeUpdate();
        } catch (SQLException e) {
             System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public MetodoPagoBE obtenerPorId(String input) {
        MetodoPagoBE metodoPago = new MetodoPagoBE();
        try {
             PreparedStatement pst = getConexion().prepareStatement("SELECT * FROM metodo_pago WHERE id_metodo_pago = ?");
             pst.setString(1, input);
             ResultSet rs = pst.executeQuery();
             while (rs.next()) {
                
                metodoPago.setIdMetodoPago(rs.getString("id_metodo_pago"));
                metodoPago.setNombre(rs.getString("nombre"));
                metodoPago.setTipo(rs.getString("tipo"));
                metodoPago.setProveedor(rs.getString("proveedor"));        
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return metodoPago;
    }

    @Override
    public ArrayList<MetodoPagoBE> obtenerTodos() {
         ArrayList<MetodoPagoBE> lstMetodoPago = null;//NULA
        try {
            Statement stm = getConexion().createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM metodo_pago");
            lstMetodoPago = new ArrayList<>();//VACIA
            while (rs.next()) {
                MetodoPagoBE metodoPago = new MetodoPagoBE();
        
                 metodoPago.setIdMetodoPago(rs.getString("id_metodo_pago"));
                metodoPago.setNombre(rs.getString("nombre"));
                metodoPago.setTipo(rs.getString("tipo"));
                metodoPago.setProveedor(rs.getString("proveedor"));
                lstMetodoPago.add(metodoPago);
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lstMetodoPago;
    }

    @Override
    public boolean Actualizar(MetodoPagoBE input) {
        boolean result = false;
        try {
            String SQL = "UPDATE metodo_pago SET nombre=?, tipo=?, proveedor=? WHERE id_metodo_pago=?";
            PreparedStatement pst = getConexion().prepareStatement(SQL);
             pst.setString(1, input.getNombre());
            pst.setString(2, input.getTipo());
            pst.setString(3, input.getProveedor());
            pst.setString(4, input.getIdMetodoPago());         
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
                    getConexion().prepareStatement("DELETE FROM metodo_pago WHERE id_metodo_pago=?");
            pst.setString(1, input);
            result = pst.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }


    
}
