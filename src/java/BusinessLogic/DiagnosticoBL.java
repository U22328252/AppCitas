/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessEntity.DiagnosticoBE;
import DataAccessObject.DiagnosticoDAO;
import java.util.ArrayList;

/**
 *
 * @author solan
 */
public class DiagnosticoBL implements IBaseBL<DiagnosticoBE> {

    @Override
    public boolean Crear(DiagnosticoBE input) {
        DiagnosticoDAO diagnosticoDAO = new DiagnosticoDAO();
        diagnosticoDAO.Crear(input);
        return true;
    }

    @Override
    public DiagnosticoBE obtenerPorId(String input) {
       DiagnosticoDAO diagnosticoDAO = new DiagnosticoDAO();
       return diagnosticoDAO.obtenerPorId(input);
    }

    @Override
    public ArrayList<DiagnosticoBE> obtenerTodos() {
       DiagnosticoDAO diagnosticoDAO = new DiagnosticoDAO();
       return diagnosticoDAO.obtenerTodos();
    }

    @Override
    public boolean Actualizar(DiagnosticoBE input) {
        DiagnosticoDAO diagnosticoDAO = new DiagnosticoDAO();
        diagnosticoDAO.Actualizar(input);
        return true;
    }

    @Override
    public boolean Eliminar(String input) {
        DiagnosticoDAO diagnosticoDAO = new DiagnosticoDAO();
        diagnosticoDAO.Eliminar(input);
        return true;
    }
    
}
