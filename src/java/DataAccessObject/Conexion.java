/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author SISTEMAS
 */
public class Conexion {
//    private String StrConxMySQL="jdbc:mysql://vmi2086478.contaboserver.net:3306/sistema_citas";
//    private String StrUserMySQL="usuarioapp";
//    private String StrPassMySQL="FMde13N4X3Lpr";
//    private Connection conexion; //Null
    private String StrConxMySQL="jdbc:mysql://localhost/sistema_citas";
    private String StrUserMySQL="root";
    private String StrPassMySQL="123546";
    private Connection conexion; //Null
    
    
    public static void main(String [] args){
        Conexion cn = new Conexion();
    }
    
    public Conexion() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            DriverManager.setLoginTimeout(300);
            //Creacion 
            conexion = DriverManager
                    .getConnection(StrConxMySQL, StrUserMySQL, StrPassMySQL);
            if(conexion != null){
                DatabaseMetaData dm = conexion.getMetaData();
                System.out.println("Product Name:" + dm.getDatabaseProductName());
                System.out.println("Product version:" + dm.getDatabaseProductVersion());
            }
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public Connection getConexion() {
        return conexion;
    }
}
