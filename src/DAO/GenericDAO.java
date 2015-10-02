/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conxexao.ConnectionDataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Luiz Carlos
 */
public abstract class GenericDAO {
    private Connection connection;
    
    protected GenericDAO(){
        this.connection = (Connection) ConnectionDataBase.getConnection();
    }
    
    protected Connection getConnection(){
        return connection;
    }
    
    protected void salvar(String inserirSQL, Object... parametro) throws SQLException{
        PreparedStatement statement = getConnection().prepareStatement(inserirSQL);
        
        for(int i = 0; i < parametro.length; i++){
            statement.setObject(i + 1, parametro[i]);
        }
        
        statement.execute();
        statement.close();
    }
    
    protected void atualizar(String updateSQL, Object id, Object... parametro) throws SQLException{
        PreparedStatement statement = getConnection().prepareStatement(updateSQL);
        
        for(int i = 0; i < parametro.length; i++){
            statement.setObject(i + 1, parametro[i]);
        }
        
        statement.setObject(parametro.length + 1, id);
        statement.execute();
        statement.close();;
        
    }
    
    protected void delete(String deleteSQL, Object... parametro) throws SQLException{
        PreparedStatement statement = getConnection().prepareStatement(deleteSQL);
        
        for(int i = 0; i < parametro.length; i++){
            statement.setObject(i + 1, parametro[i]);
        }
        
        statement.execute();
        statement.close();
    }
    
    
}
