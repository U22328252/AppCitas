/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessEntity.TipoComprobanteBE;
import DataAccessObject.TipoComprobanteDAO;
import java.util.ArrayList;

/**
 *
 * @author solan
 */
public class TipoComprobanteBL implements IBaseBL<TipoComprobanteBE> {

    @Override
    public boolean Crear(TipoComprobanteBE input) {
        TipoComprobanteDAO tipoComprobanteDAO = new TipoComprobanteDAO();
        tipoComprobanteDAO.Crear(input);
        return true;
    }

    @Override
    public TipoComprobanteBE obtenerPorId(String input) {
       TipoComprobanteDAO tipoComprobanteDAO = new TipoComprobanteDAO();
       return tipoComprobanteDAO.obtenerPorId(input);
    }

    @Override
    public ArrayList<TipoComprobanteBE> obtenerTodos() {
        TipoComprobanteDAO tipoComprobanteDAO = new TipoComprobanteDAO();
        return tipoComprobanteDAO.obtenerTodos();
    }

    @Override
    public boolean Actualizar(TipoComprobanteBE input) {
        TipoComprobanteDAO tipoComprobanteDAO = new TipoComprobanteDAO();
        tipoComprobanteDAO.Actualizar(input);
          return true;
    }

    @Override
    public boolean Eliminar(String input) {
       TipoComprobanteDAO tipoComprobanteDAO = new TipoComprobanteDAO();
        tipoComprobanteDAO.Eliminar(input);
          return true;
    }
    
}
