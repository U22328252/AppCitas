/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessEntity.MetodoPagoBE;
import DataAccessObject.MetodoPagoDAO;
import java.util.ArrayList;

/**
 *
 * @author solan
 */
public class MetodoPagoBL implements IBaseBL<MetodoPagoBE> {

    @Override
    public boolean Crear(MetodoPagoBE input) {
        MetodoPagoDAO metodoPagoDAO = new MetodoPagoDAO();
        metodoPagoDAO.Crear(input);
        return true;
    }

    @Override
    public MetodoPagoBE obtenerPorId(String input) {
        MetodoPagoDAO metodoPagoDAO = new MetodoPagoDAO();
        return metodoPagoDAO.obtenerPorId(input);
    }

    @Override
    public ArrayList<MetodoPagoBE> obtenerTodos() {
       MetodoPagoDAO metodoPagoDAO = new MetodoPagoDAO();
       return metodoPagoDAO.obtenerTodos();
    }

    @Override
    public boolean Actualizar(MetodoPagoBE input) {
        MetodoPagoDAO metodoPagoDAO = new MetodoPagoDAO();
        metodoPagoDAO.Actualizar(input);
        return true;
    }

    @Override
    public boolean Eliminar(String input) {
       MetodoPagoDAO metodoPagoDAO = new MetodoPagoDAO();
        metodoPagoDAO.Eliminar(input);
       return true;
    }
    
}
