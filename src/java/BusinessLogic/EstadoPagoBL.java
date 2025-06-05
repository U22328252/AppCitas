/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessEntity.EstadoPagoBE;
import DataAccessObject.EstadoPagoDAO;
import java.util.ArrayList;

/**
 *
 * @author solan
 */
public class EstadoPagoBL implements IBaseBL<EstadoPagoBE> {

    @Override
    public boolean Crear(EstadoPagoBE input) {
        EstadoPagoDAO estadoPagoDAO = new EstadoPagoDAO();
        estadoPagoDAO.Crear(input);
        return true;
    }

    @Override
    public EstadoPagoBE obtenerPorId(String input) {
        EstadoPagoDAO estadoPagoDAO = new EstadoPagoDAO();
        return estadoPagoDAO.obtenerPorId(input);
    }

    @Override
    public ArrayList<EstadoPagoBE> obtenerTodos() {
        EstadoPagoDAO estadoPagoDAO = new EstadoPagoDAO();
        return estadoPagoDAO.obtenerTodos();
    }

    @Override
    public boolean Actualizar(EstadoPagoBE input) {
        EstadoPagoDAO estadoPagoDAO = new EstadoPagoDAO();
        estadoPagoDAO.Actualizar(input);
        return true;
    }

    @Override
    public boolean Eliminar(String input) {
       EstadoPagoDAO estadoPagoDAO = new EstadoPagoDAO();
       estadoPagoDAO.Eliminar(input);
       return true;
    }
    
}
