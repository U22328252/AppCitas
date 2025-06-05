/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessEntity.MedicoLocalBE;
import DataAccessObject.MedicoLocalDAO;
import java.util.ArrayList;

/**
 *
 * @author solan
 */
public class MedicoLocalBL implements IBaseBL<MedicoLocalBE> {

    @Override
    public boolean Crear(MedicoLocalBE input) {
        MedicoLocalDAO medicoLocalDAO = new MedicoLocalDAO();
        medicoLocalDAO.Crear(input);
        return true;
    }

    @Override
    public MedicoLocalBE obtenerPorId(String input) {
       MedicoLocalDAO medicoLocalDAO = new MedicoLocalDAO();
       return medicoLocalDAO.obtenerPorId(input);
    } 

    @Override
    public ArrayList<MedicoLocalBE> obtenerTodos() {
       MedicoLocalDAO medicoLocalDAO = new MedicoLocalDAO();
       return medicoLocalDAO.obtenerTodos();
    }

    @Override
    public boolean Actualizar(MedicoLocalBE input) {
        MedicoLocalDAO medicoLocalDAO = new MedicoLocalDAO();
        medicoLocalDAO.Actualizar(input);
        return true;
    }

    @Override
    public boolean Eliminar(String input) {
        MedicoLocalDAO medicoLocalDAO = new MedicoLocalDAO();
        medicoLocalDAO.Eliminar(input);
        return true;
    }
    
}
