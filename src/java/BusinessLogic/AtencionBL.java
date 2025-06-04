/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic;

import BusinessEntity.AtencionBE;
import DataAccessObject.AtencionDAO;
import java.util.ArrayList;

/**
 *
 * @author solan
 */
public class AtencionBL implements IBaseBL<AtencionBE> {

    @Override
    public boolean Crear(AtencionBE input) {
       AtencionDAO atencionDAO = new AtencionDAO();
         atencionDAO.Crear(input);
         return true;
    }

    @Override
    public AtencionBE obtenerPorId(String input) {
         AtencionDAO atencionDAO = new AtencionDAO();
         return atencionDAO.obtenerPorId(input);         
    }

    @Override
    public ArrayList<AtencionBE> obtenerTodos() {
        AtencionDAO atencionDAO = new AtencionDAO();
        return atencionDAO.obtenerTodos(); 
    }

    @Override
    public boolean Actualizar(AtencionBE input) {
         AtencionDAO atencionDAO = new AtencionDAO();
         atencionDAO.Actualizar(input);
         return true;
    }

    @Override
    public boolean Eliminar(String input) {
        AtencionDAO atencionDAO = new AtencionDAO();
        atencionDAO.Eliminar(input);
        return true;
    }
    
}
