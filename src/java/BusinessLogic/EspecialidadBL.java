/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessEntity.EspecialidadBE;
import DataAccessObject.EspecialidadDAO;
import java.util.ArrayList;

/**
 *
 * @author solan
 */
public class EspecialidadBL implements IBaseBL<EspecialidadBE> {

    @Override
    public boolean Crear(EspecialidadBE input) {
        EspecialidadDAO especialidadDAO = new EspecialidadDAO();
        especialidadDAO.Crear(input);
        return true;
        
    }

    @Override
    public EspecialidadBE obtenerPorId(String input) {
       EspecialidadDAO especialidadDAO = new EspecialidadDAO();
       return especialidadDAO.obtenerPorId(input);
    }

    @Override
    public ArrayList<EspecialidadBE> obtenerTodos() {
        EspecialidadDAO especialidadDAO = new EspecialidadDAO();
        return especialidadDAO.obtenerTodos();
    }

    @Override
    public boolean Actualizar(EspecialidadBE input) {
        EspecialidadDAO especialidadDAO = new EspecialidadDAO();
        especialidadDAO.Actualizar(input);
        return true;
    }

    @Override
    public boolean Eliminar(String input) {
       EspecialidadDAO especialidadDAO = new EspecialidadDAO();
       especialidadDAO.Eliminar(input);
       return true;
    }
    
}
