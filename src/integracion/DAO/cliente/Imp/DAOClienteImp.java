/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracion.DAO.cliente.Imp;

import Negocio.cliente.TCliente;
import Negocio.cliente.TClienteNormal;
import Negocio.cliente.TClienteVip;
import integracion.DAO.cliente.DAOCliente;
import integracion.transaction.transactionManager.TransactionManager;
import java.sql.Connection;
import java.sql.ResultSet;
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
        Statement query = null;
        Connection connection = null;
        //insercion cliente generico
        String contenido_query = "INSERT INTO Clientes(DNI, Nombre, Apellidos, Fecha_nacimiento, Tipo) VALUES ('" + cliente.getDNI() + "', '" + cliente.getNombre() + "', '" + cliente.getApellidos() + "', STR_TO_DATE('" + cliente.getFechaNacimiento() + "', '%d/%m/%Y'), '";
        //insercion cliente especializado
        String contenido_query_especializada = null;
        if (cliente.getClass().equals(TClienteNormal.class))
        {
            Negocio.cliente.TClienteNormal temp = (TClienteNormal) cliente;
            contenido_query += "normal');";
            contenido_query_especializada = "INSERT INTO clientesnormales(id_cliente, QuiereVip) VALUES ('" + cliente.getId() + ", " + temp.isQuierevip() + "');";
        }
        else
        {
            Negocio.cliente.TClienteVip temp = (TClienteVip) cliente; 
            contenido_query += "VIP');";
            contenido_query_especializada = "INSERT INTO clientesnormales(id_cliente, Financiacion) VALUES ('" + cliente.getId() + ", " + temp.getFinanciacion() + "');";
        }
                
        try
        {
            connection = (Connection) TransactionManager.obtenerInstanacia().getTransaccion().getResource();
            query = connection.createStatement();
        }
        catch (SQLException e)
        {
            throw new SQLException("No se ha podido realizar la conexión con la base de datos. \nEs posible que haya olvidado crear o iniciar la transacción"
                    + "\nError: " + e.getMessage());
        }
         try
        {
            System.out.println(contenido_query);
            query.executeUpdate(contenido_query);
            //query.execute(contenido_query_especializada);
        }
        catch (SQLException e)
        {
            throw new SQLException("No se ha podido dar de alta el cliente. Posiblemente ya exista\nError: " + e.getMessage());
        }
         
         //Si no ha saltado excepción en este punto es porque se ha dado el alta correctamente
         query.executeUpdate("SELECT DNI FROM Clientes WHERE DNI = " + cliente.getDNI() + ";");
         ResultSet rs = query.getResultSet();
         rs.next();
         return rs.getInt(1);
    }

    @Override
    public boolean bajaCliente(int ID) throws Exception 
    {
        Statement query = null;
        Connection connection = null;
        //baja lógica de cliente (solo en la tabla de los genéricos)
        String contenido_query = "UPDATE Clientes SET Disponible = FALSE WHERE id_cliente = " + ID + ";";                
                
        try
        {
            connection = (Connection) TransactionManager.obtenerInstanacia().getTransaccion().getResource();
            query = connection.createStatement();
        }
        catch (SQLException e)
        {
            throw new SQLException("No se ha podido realizar la conexión con la base de datos. \nEs posible que haya olvidado crear o iniciar la transacción"
                    + "\nError: " + e.getMessage());
        }
         try
        {
            System.out.println(contenido_query);
            query.executeUpdate(contenido_query);
        }
        catch (SQLException e)
        {
            throw new SQLException("No se ha podido dar de baja el cliente. \nError: " + e.getMessage());
        }
         return false;
    }

    @Override
    public ArrayList<TCliente> listarClientes() throws Exception {
        Statement query = null;
        Connection connection = null;
        ArrayList<TCliente> ret = new ArrayList<TCliente>();
        TCliente temp = new TCliente();
        //baja lógica de cliente (solo en la tabla de los genéricos)
        String contenido_query = "SELECT * FROM Clientes";                
                
        try
        {
            connection = (Connection) TransactionManager.obtenerInstanacia().getTransaccion().getResource();
            query = connection.createStatement();
        }
        catch (SQLException e)
        {
            throw new SQLException("No se ha podido realizar la conexión con la base de datos. \nEs posible que haya olvidado crear o iniciar la transacción"
                    + "\nError: " + e.getMessage());
        }
         try
        {
            System.out.println(contenido_query);
            query.executeUpdate(contenido_query);
            ResultSet rs = query.getResultSet();
            while (rs.next())
            {
                if (rs.getString("Disponible").equalsIgnoreCase("1"))
                {
                    Integer id = Integer.parseInt(rs.getString("id_cliente"));
                    temp.setId(id);
                    temp.setDNI(rs.getString("DNI"));
                    temp.setNombre(rs.getString("Nombre"));
                    temp.setApellidos(rs.getString("Apellidos"));
                    temp.setFechaNacimiento(rs.getString("Fecha_nacimiento"));
                    ret.add(temp);
                }
            }
        }
        catch (SQLException e)
        {
            throw new SQLException("No se ha podido mostrar la lista de clientes. \nError: " + e.getMessage());
        }
        return ret;
    }

    @Override
    public TCliente mostrarCliente(int ID) throws Exception {
        Statement query = null;
        Connection connection = null;
        TCliente ret = null;        
        //baja lógica de cliente (solo en la tabla de los genéricos)
        String contenido_query = "SELECT * FROM Clientes WHERE id_cliente = " + ID + ";";                
                
        try
        {
            connection = (Connection) TransactionManager.obtenerInstanacia().getTransaccion().getResource();
            query = connection.createStatement();
        }
        catch (SQLException e)
        {
            throw new SQLException("No se ha podido realizar la conexión con la base de datos. \nEs posible que haya olvidado crear o iniciar la transacción"
                    + "\nError: " + e.getMessage());
        }
         try
        {
            System.out.println(contenido_query);
            query.executeUpdate(contenido_query);
            ResultSet rs = query.getResultSet();
            if (rs.next())
            {
                if (rs.getString("tipo").equalsIgnoreCase("normal"))
                {
                    TClienteNormal temp = new TClienteNormal();
                    query.executeUpdate("SELECT QuiereVip FROM ClientesNormales WHERE id_cliente = " + ID + ";");
                    ResultSet rs2 = query.getResultSet();
                    if (rs2.next())
                    {
                        temp.setQuierevip(rs2.getString("QuiereVip").equalsIgnoreCase("1")); 
                        ret = temp;
                    }
                    else
                        throw new Exception("Inconsistencia en la base de datos. El cliente consta como normal, pero no esta guardado sus atributos como cliente normal");
                }
                else
                {
                    TClienteVip temp = new TClienteVip();
                    query.executeUpdate("SELECT QuiereVip FROM ClientesNormales WHERE id_cliente = " + ID + ";");
                    ResultSet rs2 = query.getResultSet();
                    if (rs2.next())
                    {
                        Float dummy = Float.parseFloat(rs2.getString("Financiacion"));
                        temp.setFinanciacion(dummy); 
                        ret = temp;
                    }
                    else
                        throw new Exception("Inconsistencia en la base de datos. El cliente consta como VIP, pero no esta guardado sus atributos como cliente VIP"); 
                }
                Integer id = Integer.parseInt(rs.getString("id_cliente"));
                ret.setId(id);
                ret.setDNI(rs.getString("DNI"));
                ret.setNombre(rs.getString("Nombre"));
                ret.setApellidos(rs.getString("Apellidos"));
                ret.setFechaNacimiento(rs.getString("Fecha_nacimiento"));
            }
        }
        catch (SQLException e)
        {
            throw new SQLException("No se ha podido consultar el cliente. \nError: " + e.getMessage());
        }
        return ret;
    }

    @Override
    public Boolean modificarCliente(TCliente cliente) throws Exception 
    {
        Statement query = null;
        Connection connection = null;        
        String contenido_query = "UPDATE Clientes SET DNI='" + cliente.getDNI() + "', Nombre='" + cliente.getNombre() 
                + "', Apellidos='" + cliente.getApellidos()+ "', Fecha_nacimiento=STR_TO_DATE('" + cliente.getFechaNacimiento() + "', '%d/%m/%Y'), Tipo='"; 
        String final_query = "WHERE id_cliente = " + cliente.getId() + ";";
        try
        {
            connection = (Connection) TransactionManager.obtenerInstanacia().getTransaccion().getResource();
            query = connection.createStatement();
        }
        catch (SQLException e)
        {
            throw new SQLException("No se ha podido realizar la conexión con la base de datos. \nEs posible que haya olvidado crear o iniciar la transacción"
                    + "\nError: " + e.getMessage());
        }
        
        //Diferenciar tipo de cliente
        if (cliente.getClass().equals(TClienteNormal.class))
        {            
            Negocio.cliente.TClienteNormal temp = (TClienteNormal) cliente;
            contenido_query += "normal' " + final_query;
            try
            {
                //por si acaso estuviera en la otra tabla, lo borro
                query.executeQuery("DELETE FROM ClientesVip where id_cliente = '" + cliente.getId() + "';");
            }
            catch (SQLException ex)
            {
                throw new SQLException("No se ha podido modificar cliente \nError: " + ex.getMessage());
                   
            }
            try
            {
                //Si ha cambiado de VIP a Normal, hay que darlo de alta, en otro caso, saltará al cath
                query.executeQuery("INSERT INTO ClientesNormales(id_cliente,QuiereVip) VALUES('" + temp.getId() + "', '" + temp.isQuierevip() + "');"  );
            }
            catch (SQLException ex)
            {
                try
                {
                    query.executeQuery("UPDATE ClientesNormales SET QuiereVip='" + temp.isQuierevip() + "');");
                }
                catch (SQLException ex2)
                {
                    throw new Exception("Error al actualizar en la tabla de clientes normales\nError: " + ex2.getMessage());
                }
            }
                    
        }
        else
        {
            Negocio.cliente.TClienteVip temp = (TClienteVip) cliente;
            contenido_query += "VIP' " + final_query;
            try
            {
                //por si acaso estuviera en la otra tabla, lo borro
                query.executeQuery("DELETE FROM ClientesNormales where id_cliente = '" + cliente.getId() + "';");
            }
            catch (SQLException ex)
            {
                throw new SQLException("No se ha podido modificar cliente \nError: " + ex.getMessage());
                   
            }
            try
            {
                //Si ha cambiado de VIP a Normal, hay que darlo de alta, en otro caso, saltará al cath
                query.executeQuery("INSERT INTO ClientesVip(id_cliente,Financiacion) VALUES('" + temp.getId() + "', '" + temp.getFinanciacion()+ "');"  );
            }
            catch (SQLException ex)
            {
                try
                {
                    query.executeQuery("UPDATE ClientesVip SET Financiacion='" + temp.getFinanciacion() + "');");
                }
                catch (SQLException ex2)
                {
                    throw new Exception("Error al actualizar en la tabla de clientes VIP\nError: " + ex2.getMessage());
                }
            }
        }
        return false;
    }
    
    
}
