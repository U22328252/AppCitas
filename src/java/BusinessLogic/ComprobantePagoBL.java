/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessEntity.ComprobantePagoBE;
import DataAccessObject.ComprobantePagoDAO;
import java.util.ArrayList;

/**
 *
 * @author solan
 */
public class ComprobantePagoBL implements IBaseBL<ComprobantePagoBE> {

    @Override
    public boolean Crear(ComprobantePagoBE input) {
        ComprobantePagoDAO comprobantePagoDAO = new ComprobantePagoDAO();
        comprobantePagoDAO.Crear(input);
        return true;
    }

    @Override
    public ComprobantePagoBE obtenerPorId(String input) {
        ComprobantePagoDAO comprobantePagoDAO = new ComprobantePagoDAO();
        return comprobantePagoDAO.obtenerPorId(input);
    }

    @Override
    public ArrayList<ComprobantePagoBE> obtenerTodos() {
        ComprobantePagoDAO comprobantePagoDAO = new ComprobantePagoDAO();
        return comprobantePagoDAO.obtenerTodos();   
    }

    @Override
    public boolean Actualizar(ComprobantePagoBE input) {
        ComprobantePagoDAO comprobantePagoDAO = new ComprobantePagoDAO();
        comprobantePagoDAO.Actualizar(input);
        return true;
    }

    @Override
    public boolean Eliminar(String input) {
       ComprobantePagoDAO comprobantePagoDAO = new ComprobantePagoDAO();
        comprobantePagoDAO.Eliminar(input);
        return true;
    }
    
}
