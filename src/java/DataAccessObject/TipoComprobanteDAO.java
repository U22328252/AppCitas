/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import BusinessEntity.TipoComprobanteBE;
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
public class TipoComprobanteDAO extends Conexion implements IBaseDAO<TipoComprobanteBE> {

    @Override
    public boolean Crear(TipoComprobanteBE input) {
        boolean result = false;
        try {
            String sql = "INSERT INTO tipo_comprobante VALUES (?, ?)";
            PreparedStatement pst = getConexion().prepareStatement(sql);
           pst.setString(1, input.getIdTipoComprobante());
            pst.setString(2, input.getDescripcion());
            pst.executeUpdate();
        } catch (SQLException e) {
             System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public TipoComprobanteBE obtenerPorId(String input) {
        TipoComprobanteBE tipoComprobante = new TipoComprobanteBE();
        try {
             PreparedStatement pst = getConexion().prepareStatement("SELECT * FROM tipo_comprobante WHERE id_tipo_comprobante = ?");
             pst.setString(1, input);
             ResultSet rs = pst.executeQuery();
             while (rs.next()) {
                
               tipoComprobante.setIdTipoComprobante(rs.getString("id_tipo_comprobante"));
                tipoComprobante.setDescripcion(rs.getString("descripcion"));         
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tipoComprobante;
    }

    @Override
    public ArrayList<TipoComprobanteBE> obtenerTodos() {
        ArrayList<TipoComprobanteBE> lstTipoComprobante = null;//NULA
        try {
            Statement stm = getConexion().createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM tipo_comprobante");
            lstTipoComprobante = new ArrayList<>();//VACIA
            while (rs.next()) {
                TipoComprobanteBE tipoComprobante = new TipoComprobanteBE();
        
               tipoComprobante.setIdTipoComprobante(rs.getString("id_tipo_comprobante"));
                tipoComprobante.setDescripcion(rs.getString("descripcion"));
                lstTipoComprobante.add(tipoComprobante);
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lstTipoComprobante;
    }

    @Override
    public boolean Actualizar(TipoComprobanteBE input) {
         boolean result = false;
        try {
            String SQL = "UPDATE tipo_comprobante SET descripcion=? WHERE id_tipo_comprobante=?";
            PreparedStatement pst = getConexion().prepareStatement(SQL);
            pst.setString(1, input.getDescripcion());
            pst.setString(2, input.getIdTipoComprobante());          
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
                    getConexion().prepareStatement("DELETE FROM tipo_comprobante WHERE id_tipo_comprobante=?");
            pst.setString(1, input);
            result = pst.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

   
}
