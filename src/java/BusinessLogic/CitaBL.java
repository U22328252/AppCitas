/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessEntity.CitaBE;
import DataAccessObject.CitaDAO;
import java.util.ArrayList;

/**
 *
 * @author solan
 */
public class CitaBL implements IBaseBL<CitaBE> {

    @Override
    public boolean Crear(CitaBE input) {
        CitaDAO citaDAO = new CitaDAO();
        citaDAO.Crear(input);
        return true;
    }

    @Override
    public CitaBE obtenerPorId(String input) {
         CitaDAO citaDAO = new CitaDAO();
         return  citaDAO.obtenerPorId(input);
    }

    @Override
    public ArrayList<CitaBE> obtenerTodos() {
        CitaDAO citaDAO = new CitaDAO();
         return  citaDAO.obtenerTodos();
    }

    @Override
    public boolean Actualizar(CitaBE input) {
         CitaDAO citaDAO = new CitaDAO();
        citaDAO.Crear(input);
        return true;
    }

    @Override
    public boolean Eliminar(String input) {
         CitaDAO citaDAO = new CitaDAO();
         citaDAO.Eliminar(input);
        return true;
    }
    
}
