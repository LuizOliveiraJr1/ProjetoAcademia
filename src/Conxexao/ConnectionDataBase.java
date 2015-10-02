/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conxexao;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Luiz Carlos
 */
public class ConnectionDataBase {
    
    private static final String URL_MYSQL = "jdbc:mysql://localhost/academia";
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    
    private static final String USUARIO = "root";
    
    private static final String SENHA = "root";
    
    public static ConnectionDataBase getConnection(){
        System.out.println("Conectando com o banco de dados...");
        try{
            Class.forName(DRIVER);
            return (ConnectionDataBase) DriverManager.getConnection(URL_MYSQL, USUARIO, SENHA);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }
}
