/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import BusinessEntity.EstadoPagoBE;
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
public class EstadoPagoDAO extends Conexion implements IBaseDAO<EstadoPagoBE> {

    @Override
    public boolean Crear(EstadoPagoBE input) {
        boolean result = false;
        try {
            String sql = "INSERT INTO estado_pago VALUES (?, ?)";
            PreparedStatement pst = getConexion().prepareStatement(sql);
            pst.setString(1, UUID.randomUUID().toString());
            pst.setString(2, input.getDescripcion());
            pst.executeUpdate();
        } catch (SQLException e) {
             System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public EstadoPagoBE obtenerPorId(String input) {
        EstadoPagoBE estadoPago = new EstadoPagoBE();
        try {
             PreparedStatement pst = getConexion().prepareStatement("SELECT * FROM estado_pago WHERE id_estado_pago = ?");
             pst.setString(1, input);
             ResultSet rs = pst.executeQuery();
             while (rs.next()) {
                
                estadoPago.setIdEstadoPago(rs.getString("id_estado_pago"));
                estadoPago.setDescripcion(rs.getString("descripcion"));       
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return estadoPago;
    }

    @Override
    public ArrayList<EstadoPagoBE> obtenerTodos() {
         ArrayList<EstadoPagoBE> lstEstadoPago = null;//NULA
        try {
            Statement stm = getConexion().createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM estado_pago");
            lstEstadoPago = new ArrayList<>();//VACIA
            while (rs.next()) {
                EstadoPagoBE estadoPago = new EstadoPagoBE();
        
                estadoPago.setIdEstadoPago(rs.getString("id_estado_pago"));
                estadoPago.setDescripcion(rs.getString("descripcion"));
                lstEstadoPago.add(estadoPago);
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return  lstEstadoPago;
    }

    @Override
    public boolean Actualizar(EstadoPagoBE input) {
         boolean result = false;
        try {
            String SQL = "UPDATE estado_pago SET descripcion=? WHERE id_estado_pago=?";
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            pst.setString(1, input.getDescripcion());
            pst.setString(2, input.getIdEstadoPago());         
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
                    getConexion().prepareStatement("DELETE FROM estado_pago WHERE id_estado_pago=?");
            pst.setString(1, input);
            result = pst.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

   
    
}
