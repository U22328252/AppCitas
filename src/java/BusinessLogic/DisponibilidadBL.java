/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessEntity.DisponibilidadBE;
import DataAccessObject.DisponibilidadDAO;
import java.util.ArrayList;

/**
 *
 * @author solan
 */
public class DisponibilidadBL implements IBaseBL<DisponibilidadBE> {

    @Override
    public boolean Crear(DisponibilidadBE input) {
        DisponibilidadDAO disponibilidadDAO = new DisponibilidadDAO();
        disponibilidadDAO.Crear(input);
        return true;
    }

    @Override
    public DisponibilidadBE obtenerPorId(String input) {
       DisponibilidadDAO disponibilidadDAO = new DisponibilidadDAO();
       return disponibilidadDAO.obtenerPorId(input);
    }

    @Override
    public ArrayList<DisponibilidadBE> obtenerTodos() {
       DisponibilidadDAO disponibilidadDAO = new DisponibilidadDAO();
       return disponibilidadDAO.obtenerTodos();
      
    }

    @Override
    public boolean Actualizar(DisponibilidadBE input) {
         DisponibilidadDAO disponibilidadDAO = new DisponibilidadDAO();
         disponibilidadDAO.Actualizar(input);
         return true;
    }

    @Override
    public boolean Eliminar(String input) {
        DisponibilidadDAO disponibilidadDAO = new DisponibilidadDAO();
        disponibilidadDAO.Eliminar(input);
        return true;
    }
    
}
