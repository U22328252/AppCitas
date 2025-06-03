/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import BusinessEntity.DiagnosticoBE;
import java.util.UUID;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class DiagnosticoDAO extends Conexion implements IBaseDAO<DiagnosticoBE> {

    @Override
    public boolean Crear(DiagnosticoBE input) {
       Boolean result = false;
        try {          
            String sql = "INSERT INTO diagnostico VALUES (?, ?, ?, ?)";
            PreparedStatement pst = getConexion().prepareStatement(sql);
            pst.setString(1, UUID.randomUUID().toString());
            pst.setString(2, input.getIdAtencion());
            pst.setString(3, input.getDescripcion());
            pst.setString(4, input.getCie10Codigo());
            pst.executeQuery();
            
        } catch (SQLException e) {
             System.out.println(e.getMessage());
        }
        
        return result;
    }

    @Override
    public DiagnosticoBE obtenerPorId(String input) {
       DiagnosticoBE diagnostico = new DiagnosticoBE();
        try {
            PreparedStatement pst = getConexion().prepareStatement("SELECT * FROM diagnostico WHERE id_diagnostico = ?");
            pst.setString(1, input);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                diagnostico.setIdDiagnostico(rs.getString("id_diagnostico"));
                diagnostico.setIdAtencion(rs.getString("id_atencion"));
                diagnostico.setDescripcion(rs.getString("descripcion"));
                diagnostico.setCie10Codigo(rs.getString("cie10_codigo"));
                
            }
            
        } catch (SQLException e) {
             System.out.println(e.getMessage());
        }
        return diagnostico;
       
    }

    @Override
    public ArrayList<DiagnosticoBE> obtenerTodos() {
        ArrayList<DiagnosticoBE> lstDiagnostico = null;
        try {
            Statement stm = getConexion().createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM diagnostico");
            lstDiagnostico = new ArrayList<>();
            while (rs.next()) {
                DiagnosticoBE diagnostico = new DiagnosticoBE();
                diagnostico.setIdDiagnostico(rs.getString("id_diagnostico"));
                diagnostico.setIdAtencion(rs.getString("id_atencion"));
                diagnostico.setDescripcion(rs.getString("descripcion"));
                diagnostico.setCie10Codigo(rs.getString("cie10_codigo"));
                lstDiagnostico.add(diagnostico);
            }
        } catch (SQLException e) {
        }
        return lstDiagnostico;
    }

    @Override
    public boolean Actualizar(DiagnosticoBE input) {
        boolean result = false;
        try {
            String SQL = "UPDATE diagnostico SET id_atencion=?, descripcion=?, cie10_codigo=? WHERE id_diagnostico=?";
            PreparedStatement pst = getConexion().prepareStatement(SQL);
             pst.setString(1, input.getIdAtencion());
            pst.setString(2, input.getDescripcion());
            pst.setString(3, input.getCie10Codigo());
            pst.setString(4, input.getIdDiagnostico());          
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
                    getConexion().prepareStatement("DELETE FROM diagnostico WHERE id_diagnostico=?");
            pst.setString(1, input);
            result = pst.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
