/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessEntity.PagoBE;
import DataAccessObject.PagoDAO;
import java.util.ArrayList;

/**
 *
 * @author solan
 */
public class PagoBL implements IBaseBL<PagoBE> {

    @Override
    public boolean Crear(PagoBE input) {
        PagoDAO pagoDAO = new PagoDAO();
        pagoDAO.Crear(input);
        return true;
    }

    @Override
    public PagoBE obtenerPorId(String input) {
       PagoDAO pagoDAO = new PagoDAO();
       return pagoDAO.obtenerPorId(input);
    }

    @Override
    public ArrayList<PagoBE> obtenerTodos() {
        PagoDAO pagoDAO = new PagoDAO();
        return pagoDAO.obtenerTodos();
    }

    @Override
    public boolean Actualizar(PagoBE input) {
       PagoDAO pagoDAO = new PagoDAO();
        pagoDAO.Actualizar(input);
        return true;
    }

    @Override
    public boolean Eliminar(String input) {
       PagoDAO pagoDAO = new PagoDAO();
        pagoDAO.Eliminar(input);
        return true;
    }
    
}
