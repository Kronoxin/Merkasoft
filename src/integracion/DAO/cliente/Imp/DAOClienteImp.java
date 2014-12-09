/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracion.DAO.cliente.Imp;

import Negocio.cliente.TCliente;
import integracion.DAO.cliente.DAOCliente;
import integracion.transaction.transactionManager.TransactionManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Ruben
 */
public class DAOClienteImp implements DAOCliente 
{

    @Override
    public int altaCliente(TCliente cliente) throws Exception
    {
        Integer ret = -1;
        Statement query = null;
        Connection connection = null;
        String campos_para_query = cliente.getDNI() + ", " + cliente.getNombre() + ", " + cliente.getApellidos() + ", " + cliente.getFechaNacimiento() + ", " + cliente.getTipo();
        String query_especializada = ""
        if (cliente.getTipo().equalsIgnoreCase("normal"))
        
        try
        {
            connection = (Connection) TransactionManager.obtenerInstanacia().getTransaccion().getResource();
            query = connection.createStatement();
        }
        catch (SQLException e)
        {
            throw new SQLException("No se ha podido realizar la conexión con la base de datos. \nEs posible que haya olvidado crear o iniciar la transacción\nError: " + e.getMessage());
        }
        try
        {
            query.executeUpdate("INSERT INTO Clientes(DNI, Nombre, Apellidos, Fecha_nacimiento, Tipo) VALUES ('" + ret + "')");
        }
        
        
        return ret;
    }

    @Override
    public Boolean bajaCliente(int ID) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList listarClientes() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TCliente mostrarCliente(int ID) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean modificarCliente(TCliente cliente) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
