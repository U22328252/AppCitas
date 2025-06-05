/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessEntity.PacienteBE;
import DataAccessObject.PacienteDAO;
import java.util.ArrayList;

/**
 *
 * @author solan
 */
public class PacienteBL implements IBaseBL<PacienteBE> {

    @Override
    public boolean Crear(PacienteBE input) {
        PacienteDAO pacienteDAO = new PacienteDAO();
        pacienteDAO.Crear(input);
        return true;
    }

    @Override
    public PacienteBE obtenerPorId(String input) {
        PacienteDAO pacienteDAO = new PacienteDAO();
        return pacienteDAO.obtenerPorId(input);
    }

    @Override
    public ArrayList<PacienteBE> obtenerTodos() {
       PacienteDAO pacienteDAO = new PacienteDAO();
       return pacienteDAO.obtenerTodos();
    }

    @Override
    public boolean Actualizar(PacienteBE input) {
        PacienteDAO pacienteDAO = new PacienteDAO();
        pacienteDAO.Actualizar(input);
        return true;
    }

    @Override
    public boolean Eliminar(String input) {
        PacienteDAO pacienteDAO = new PacienteDAO();
        pacienteDAO.Eliminar(input);
        return true;
    }
    
}
