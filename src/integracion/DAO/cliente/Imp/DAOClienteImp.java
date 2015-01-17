/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracion.DAO.cliente.Imp;

import negocio.cliente.TCliente;
import negocio.cliente.TClienteNormal;
import negocio.cliente.TClienteVip;
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
        int ret = -1;
        //insercion cliente generico
        String contenido_query = "INSERT INTO Clientes(DNI, Nombre, Apellidos, Fecha_nacimiento, Tipo) VALUES ('" + cliente.getDNI() + "', '" + cliente.getNombre() + "', '" + cliente.getApellidos() + "', STR_TO_DATE('" + cliente.getFechaNacimiento() + "', '%d/%m/%Y'), '";
        //insercion cliente especializado
        String contenido_query_especializada = null;        
                
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
            if (cliente.getClass().equals(TClienteNormal.class))
            {
                contenido_query += "normal');";                
            }
            else
            {
                contenido_query += "VIP');";                
            }
            System.out.println(contenido_query);
            query.executeUpdate(contenido_query);
        }
        catch (SQLException e)
        {
            throw new SQLException("No se ha podido dar de alta el cliente. Posiblemente ya exista\nError: " + e.getMessage() + "\n" + e.getSQLState() + "\n" + e.getErrorCode());
        }
         
         //Si no ha saltado excepción en este punto es porque se ha dado el alta correctamente 
         //Buscamos el id del nuevo usuario
         query.executeQuery("SELECT id_cliente FROM Clientes WHERE DNI = " + "\"" + cliente.getDNI() + "\"" + ";");
            
         ResultSet rs = query.getResultSet();
            rs.next();
            int id = rs.getInt(1);
            if (cliente.getClass().equals(TClienteNormal.class))
            {
                TClienteNormal temp = (TClienteNormal) cliente;                
                contenido_query_especializada = "INSERT INTO clientesnormales(id_cliente, QuiereVip) VALUES (" + id + ", " + temp.isQuierevip() + ");";
            }
            else
            {
                TClienteVip temp = (TClienteVip) cliente;                 
                contenido_query_especializada = "INSERT INTO ClientesVip(id_cliente, Financiacion) VALUES (" + id + ", " + temp.getFinanciacion() + ");";
            }
            System.out.println(contenido_query_especializada);
            query.execute(contenido_query_especializada);
         return id;
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
         return true;
    }

    @Override
    public ArrayList<TCliente> listarClientes() throws Exception {
        Statement query = null;
        Connection connection = null;
        TCliente temp = new TCliente();
        ArrayList<TCliente> ret = new ArrayList<TCliente>();        
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
            query.execute(contenido_query);
            ResultSet rs = query.getResultSet();
            while (rs.next())
            {
                if (rs.getString("Disponible").equalsIgnoreCase("1"))
                {
                    temp =new TCliente();
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
        TClienteNormal normal = new TClienteNormal();
        TClienteVip vip = new TClienteVip();
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
            query.execute(contenido_query);
            ResultSet rs = query.getResultSet();            
            if (rs.next())
            {       
                int id = rs.getInt("id_cliente");
                String dni = rs.getString("DNI");
                String nombre = rs.getString("Nombre");
                String apellidos = rs.getString("Apellidos");
                String nacimiento = rs.getString("Fecha_nacimiento");
                
                if (rs.getString("tipo").equalsIgnoreCase("normal"))
                {
                    
                    query.execute("SELECT QuiereVip FROM ClientesNormales WHERE id_cliente = " + ID + ";");
                    ResultSet rs2 = query.getResultSet();
                    if (rs2.next())
                    {
                        normal.setQuierevip(rs2.getString("QuiereVip").equalsIgnoreCase("1")); 
                        ret = normal;
                    }
                    else
                        throw new Exception("Inconsistencia en la base de datos. El cliente consta como normal, pero no esta guardado sus atributos como cliente normal");
                }
                else
                {
                    
                    query.execute("SELECT Financiacion FROM ClientesVip WHERE id_cliente = " + ID + ";");
                    ResultSet rs2 = query.getResultSet();
                    if (rs2.next())
                    {
                        Float dummy = Float.parseFloat(rs2.getString("Financiacion"));
                        vip.setFinanciacion(dummy); 
                        ret = vip;
                    }
                    else
                        throw new Exception("Inconsistencia en la base de datos. El cliente consta como VIP, pero no esta guardado sus atributos como cliente VIP"); 
                }
                ret.setId(id);
                ret.setDNI(dni);
                ret.setNombre(nombre);
                ret.setApellidos(apellidos);
                ret.setFechaNacimiento(nacimiento);
                
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
            TClienteNormal temp = (TClienteNormal) cliente;
            contenido_query += "normal' " + final_query;
            try
            {
                //por si acaso estuviera en la otra tabla, lo borro
                query.executeUpdate("DELETE FROM ClientesVip where id_cliente = '" + cliente.getId() + "';");
            }
            catch (SQLException ex)
            {
                throw new SQLException("No se ha podido modificar cliente \nError: " + ex.getMessage());
                   
            }
            try
            {
                //Si ha cambiado de VIP a Normal, hay que darlo de alta, en otro caso, saltará al cath
                query.executeUpdate("INSERT INTO ClientesNormales(id_cliente,QuiereVip) VALUES('" + temp.getId() + "', '" + temp.isQuierevip() + "');"  );
            }
            catch (SQLException ex)
            {
                try
                {
                    query.executeUpdate("UPDATE ClientesNormales SET QuiereVip='" + temp.isQuierevip() + "');");
                }
                catch (SQLException ex2)
                {
                    throw new Exception("Error al actualizar en la tabla de clientes normales\nError: " + ex2.getMessage());
                }
            }
                    
        }
        else
        {
            TClienteVip temp = (TClienteVip) cliente;            
            contenido_query += "VIP' " + final_query;
            try
            {
                //por si acaso estuviera en la otra tabla, lo borro
                query.executeUpdate("DELETE FROM ClientesNormales where id_cliente = '" + cliente.getId() + "';");
            }
            catch (SQLException ex)
            {
                throw new SQLException("No se ha podido modificar cliente \nError: " + ex.getMessage());
                   
            }
            try
            {
                //Si ha cambiado de VIP a Normal, hay que darlo de alta, en otro caso, saltará al cath
                query.executeUpdate("INSERT INTO ClientesVip(id_cliente,Financiacion) VALUES('" + temp.getId() + "', '" + temp.getFinanciacion()+ "');"  );
            }
            catch (SQLException ex)
            {
                try
                {
                    query.executeUpdate("UPDATE ClientesVip SET Financiacion=" + temp.getFinanciacion() + ";");
                }
                catch (SQLException ex2)
                {
                    throw new Exception("Error al actualizar en la tabla de clientes VIP\nError: " + ex2.getMessage());
                }
            }
        }
        System.out.println(contenido_query);
        query.executeUpdate(contenido_query);
        return false;
    }
    
    
}
