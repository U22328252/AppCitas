/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessEntity.MedicoBE;
import DataAccessObject.MedicoDAO;
import java.util.ArrayList;

/**
 *
 * @author solan
 */
public class MedicoBL implements IBaseBL<MedicoBE> {

    @Override
    public boolean Crear(MedicoBE input) {
        MedicoDAO medicoDAO = new MedicoDAO();
        medicoDAO.Crear(input);
        return true;
    }

    @Override
    public MedicoBE obtenerPorId(String input) {
       MedicoDAO medicoDAO = new MedicoDAO();
       return medicoDAO.obtenerPorId(input);
    }

    @Override
    public ArrayList<MedicoBE> obtenerTodos() {
       MedicoDAO medicoDAO = new MedicoDAO();
       return medicoDAO.obtenerTodos();
    }

    @Override
    public boolean Actualizar(MedicoBE input) {
        MedicoDAO medicoDAO = new MedicoDAO();
        medicoDAO.Actualizar(input);
       return true;
    }

    @Override
    public boolean Eliminar(String input) {
       MedicoDAO medicoDAO = new MedicoDAO();
       medicoDAO.Eliminar(input);
       return true;
    }
    
}
