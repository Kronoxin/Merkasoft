/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracion.query.cliente;

import integracion.query.Query;
import integracion.transaction.transactionManager.TransactionManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Ruben
 */
public class QueryMediaClientes implements Query
{

    @Override
    public Object execute(Object datos) 
    {
        /*
        Connection connection = null;
        String query = null;        
        
      
            query = "INSERT INTO clientesnormales(id_cliente, QuiereVip) VALUES ("; 
     
        
        try
        {
            connection = (Connection) TransactionManager.obtenerInstanacia().getTransaccion().getResource();
            query = connection.createStatement();
        }
        catch (SQLException e)
        {
            throw new SQLException("No se ha podido realizar la conexión con la base de datos. \nEs posible que haya olvidado crear o iniciar la transacción\nError: " + e.getMessage());
        }
                */
        return null;
    }
        
    
}
