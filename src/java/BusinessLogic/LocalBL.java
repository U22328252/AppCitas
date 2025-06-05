/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessEntity.LocalBE;
import DataAccessObject.LocalDAO;
import java.util.ArrayList;

/**
 *
 * @author solan
 */
public class LocalBL implements IBaseBL<LocalBE> {

    @Override
    public boolean Crear(LocalBE input) {
        LocalDAO localDAO = new LocalDAO();
        localDAO.Crear(input);
        return true;
    }

    @Override
    public LocalBE obtenerPorId(String input) {
       LocalDAO localDAO = new  LocalDAO();
       return localDAO.obtenerPorId(input);
    }

    @Override
    public ArrayList<LocalBE> obtenerTodos() {
       LocalDAO localDAO = new LocalDAO();
       return localDAO.obtenerTodos();
    }

    @Override
    public boolean Actualizar(LocalBE input) {
        LocalDAO localDAO = new LocalDAO();
        localDAO.Actualizar(input);
        return  true;
    }

    @Override
    public boolean Eliminar(String input) {
        LocalDAO localDAO = new LocalDAO();
        localDAO.Eliminar(input);
        return true;
    }
    
}
