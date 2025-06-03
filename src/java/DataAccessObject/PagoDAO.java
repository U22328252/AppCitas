/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import BusinessEntity.PagoBE;
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
public class PagoDAO extends Conexion implements IBaseDAO<PagoBE> {

    @Override
    public boolean Crear(PagoBE input) {
         boolean result = false;
        try {
            String sql = "INSERT INTO pago VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = getConexion().prepareStatement(sql);
            pst.setString(1, input.getIdPago());
            pst.setString(2, input.getIdCita());
            pst.setString(3, input.getIdMetodoPago());
            pst.setString(4, input.getIdEstadoPago());
            pst.setDouble(5, input.getMonto());
            pst.setString(6, input.getMoneda());
            pst.setTimestamp(7, input.getFechaPago());
            pst.setString(8, input.getTransaccionId());
            pst.executeUpdate();
        } catch (SQLException e) {
             System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public PagoBE obtenerPorId(String input) {
        PagoBE pago = new PagoBE();
        try {
             PreparedStatement pst = getConexion().prepareStatement("SELECT * FROM pago WHERE id_pago = ?");
             pst.setString(1, input);
             ResultSet rs = pst.executeQuery();
             while (rs.next()) {                
                pago.setIdPago(rs.getString("id_pago"));
                pago.setIdCita(rs.getString("id_cita"));
                pago.setIdMetodoPago(rs.getString("id_metodo_pago"));
                pago.setIdEstadoPago(rs.getString("id_estado_pago"));
                pago.setMonto(rs.getDouble("monto"));
                pago.setMoneda(rs.getString("moneda"));
                pago.setFechaPago(rs.getTimestamp("fecha_pago"));
                pago.setTransaccionId(rs.getString("transaccion_id"));      
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return pago;
    }

    @Override
    public ArrayList<PagoBE> obtenerTodos() {
        ArrayList<PagoBE> lstPago = null;//NULA
        try {
            Statement stm = getConexion().createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM pago");
            lstPago = new ArrayList<>();//VACIA
            while (rs.next()) {
                PagoBE pago = new PagoBE();
        
                pago.setIdPago(rs.getString("id_pago"));
                pago.setIdCita(rs.getString("id_cita"));
                pago.setIdMetodoPago(rs.getString("id_metodo_pago"));
                pago.setIdEstadoPago(rs.getString("id_estado_pago"));
                pago.setMonto(rs.getDouble("monto"));
                pago.setMoneda(rs.getString("moneda"));
                pago.setFechaPago(rs.getTimestamp("fecha_pago"));
                pago.setTransaccionId(rs.getString("transaccion_id"));
                lstPago.add(pago);
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lstPago;
    }

    @Override
    public boolean Actualizar(PagoBE input) {
         boolean result = false;
        try {
            String SQL = "UPDATE pago SET id_cita=?, id_metodo_pago=?, id_estado_pago=?, monto=?, moneda=?, fecha_pago=?, transaccion_id=? WHERE id_pago=?";
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            pst.setString(1, input.getIdCita());
            pst.setString(2, input.getIdMetodoPago());
            pst.setString(3, input.getIdEstadoPago());
            pst.setDouble(4, input.getMonto());
            pst.setString(5, input.getMoneda());
            pst.setTimestamp(6, input.getFechaPago());
            pst.setString(7, input.getTransaccionId());
            pst.setString(8, input.getIdPago());         
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
                    getConexion().prepareStatement("DELETE FROM pago WHERE id_pago=?");
            pst.setString(1, input);
            result = pst.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

   
}
