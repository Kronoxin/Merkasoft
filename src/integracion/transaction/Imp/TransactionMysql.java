/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracion.transaction.Imp;

import integracion.DAO.factoriaDAO.Imp.FactoriaDAOImp;
import integracion.transaction.Transaction;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * 
 */
public class TransactionMysql implements Transaction
{
    
    private Connection _connection;
    
    @Override
    public void start() 
    {
        Properties props = new Properties();
        try 
        {
            InputStream fichero = FactoriaDAOImp.class.getClassLoader().getResourceAsStream("database.properties");
            props.load(fichero);
	}
	catch(IOException ioe) 
        {
            throw new RuntimeException("No se ha podido leer el fichero de configuración");
        }
        try 
        {
            _connection = DriverManager.getConnection(props.getProperty("jdbc.url"), props.getProperty("jdbc.username"), props.getProperty("jdbc.password"));
	}
	
        catch (SQLException e) 
        {

            throw new RuntimeException("No se ha podido establecer la conexón con la base de datos.");
	}
		
	try 
        {
            _connection.setAutoCommit(false);
	} 
        catch (SQLException e) 
        {
            e.printStackTrace();
	}
    }

    @Override
    public void commit() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void rollback() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Connection getResource() 
    {
        return _connection;
    }

    @Override
    public void lock() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
