/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import BusinessEntity.ComprobantePagoBE;
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
public class ComprobantePagoDAO extends Conexion implements IBaseDAO<ComprobantePagoBE> {

    @Override
    public boolean Crear(ComprobantePagoBE input) {
         boolean result = false;
        try {
            String sql = "INSERT INTO comprobante_pago VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = getConexion().prepareStatement(sql);
            pst.setString(1, input.getIdComprobante());
            pst.setString(2, input.getIdPago());
            pst.setString(3, input.getIdTipoComprobante());
            pst.setString(4, input.getSerie());
            pst.setString(5, input.getNumero());
            pst.setString(6, input.getRucEmisor());
            pst.setString(7, input.getRazonSocialEmisor());
            pst.setString(8, input.getDireccionEmisor());
            pst.setTimestamp(9,input.getFechaEmision());
            pst.setString(10, input.getUrlPdf());
            pst.setString(11, input.getUrlXml());
           
            pst.executeUpdate();
        } catch (SQLException e) {
             System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public ComprobantePagoBE obtenerPorId(String input) {
        ComprobantePagoBE compago = new ComprobantePagoBE();
        try {
            PreparedStatement pst = getConexion().prepareStatement("SELECT * FROM comprobante_pago WHERE id_comprobante = ?");
            pst.setString(1, input);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                compago.setIdComprobante(rs.getString("id_comprobante"));
                compago.setIdPago(rs.getString("id_pago"));
                compago.setIdTipoComprobante(rs.getString("id_tipo_comprobante"));
                compago.setSerie(rs.getString("serie"));
                compago.setNumero(rs.getString("numero"));
                compago.setRucEmisor(rs.getString("ruc_emisor"));
                compago.setRazonSocialEmisor(rs.getString("razon_social_emisor"));
                compago.setDireccionEmisor(rs.getString("direccion_emisor"));
                compago.setFechaEmision(rs.getTimestamp("fecha_emision"));
                compago.setUrlPdf(rs.getString("url_pdf"));
                compago.setUrlXml(rs.getString("url_xml"));
                
            }
        } catch (SQLException e) {
             System.out.println(e.getMessage());
        }
        return compago;
    }

    @Override
    public ArrayList<ComprobantePagoBE> obtenerTodos() {
       ArrayList<ComprobantePagoBE> lstComprobantePago = null;//NULA
        try {
            Statement stm = getConexion().createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM comprobante_pago");
            lstComprobantePago = new ArrayList<>();//VACIA
            while (rs.next()) {
                ComprobantePagoBE comprobantePago = new ComprobantePagoBE();
        
                ComprobantePagoBE cp = new ComprobantePagoBE();
                cp.setIdComprobante(rs.getString("id_comprobante"));
                cp.setIdPago(rs.getString("id_pago"));
                cp.setIdTipoComprobante(rs.getString("id_tipo_comprobante"));
                cp.setSerie(rs.getString("serie"));
                cp.setNumero(rs.getString("numero"));
                cp.setRucEmisor(rs.getString("ruc_emisor"));
                cp.setRazonSocialEmisor(rs.getString("razon_social_emisor"));
                cp.setDireccionEmisor(rs.getString("direccion_emisor"));
                cp.setFechaEmision(rs.getTimestamp("fecha_emision"));
                cp.setUrlPdf(rs.getString("url_pdf"));
                cp.setUrlXml(rs.getString("url_xml"));
                
               lstComprobantePago.add(comprobantePago);
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lstComprobantePago;
    }

    @Override
    public boolean Actualizar(ComprobantePagoBE input) {
         boolean result = false;
        try {
            String SQL = "UPDATE comprobante_pago SET id_pago=?, id_tipo_comprobante=?, serie=?, numero=?, ruc_emisor=?, razon_social_emisor=?, direccion_emisor=?, fecha_emision=?, url_pdf=?, url_xml=? WHERE id_comprobante=?";
            PreparedStatement pst = getConexion().prepareStatement(SQL);
             pst.setString(1, input.getIdPago());
            pst.setString(2, input.getIdTipoComprobante());
            pst.setString(3, input.getSerie());
            pst.setString(4, input.getNumero());
            pst.setString(5, input.getRucEmisor());
            pst.setString(6, input.getRazonSocialEmisor());
            pst.setString(7, input.getDireccionEmisor());
            pst.setTimestamp(8, input.getFechaEmision());
            pst.setString(9, input.getUrlPdf());
            pst.setString(10, input.getUrlXml());
            pst.setString(11, input.getIdComprobante());           
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
                    getConexion().prepareStatement("DELETE FROM comprobante_pago WHERE id_comprobante=?");
            pst.setString(1, input);
            result = pst.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
}
