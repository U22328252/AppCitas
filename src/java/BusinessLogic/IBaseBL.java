/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BusinessLogic;

import java.util.ArrayList;

/**
 *
 * @author solan
 */
public interface IBaseBL<T> {
     public boolean Crear(T input);
   public T obtenerPorId(String input);
   public ArrayList<T> obtenerTodos();
   public boolean Actualizar(T input);
   public boolean Eliminar(String input);
}
