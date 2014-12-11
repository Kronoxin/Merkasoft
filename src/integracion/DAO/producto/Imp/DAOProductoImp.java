/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracion.DAO.producto.Imp;

import Negocio.producto.TProducto;
import integracion.DAO.producto.DAOProducto;
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
public class DAOProductoImp implements DAOProducto
{

    @Override
    public Integer altaProducto(TProducto producto) throws Exception {
        Statement query = null;
        Connection connection = null;
        //insercion producto generico
        String contenido_query = "INSERT INTO Productos(Nombre, Precio, Descripcion, Cod_barras, Stock ) VALUES ('" + producto.getNombre()+ "', " + producto.getPrecio()+ ", '" + producto.getDescripcion()+ "', '" + producto.getCodigoDeBarras()+ "', " + producto.getStock() + ");";
        
                
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
            throw new SQLException("No se ha podido dar de alta el producto. Posiblemente ya exista\nError: " + e.getMessage());
        }
         
         //Si no ha saltado excepción en este punto es porque se ha dado el alta correctamente
         query.execute("SELECT id_producto FROM Productos WHERE Cod_barras = " + producto.getCodigoDeBarras()+ ";");
         ResultSet rs = query.getResultSet();
         rs.next();
         return rs.getInt(1);
    }

    @Override
    public Boolean bajaProducto(int ID) throws Exception 
    {
        Statement query = null;
        Connection connection = null;        
        String contenido_query = "UPDATE Productos SET Disponible = FALSE WHERE id_producto = " + ID + ";";                
                
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
            throw new SQLException("No se ha podido dar de baja el producto. \nError: " + e.getMessage());
        }
         return false;
    }

    @Override
    public ArrayList listarProducto()throws Exception {
        Statement query = null;
        Connection connection = null;
        TProducto temp = new TProducto();
        ArrayList<TProducto> ret = new ArrayList<TProducto>();        
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
                    Integer id = Integer.parseInt(rs.getString("id_producto"));
                    temp.setId(id);                    
                    temp.setNombre(rs.getString("Nombre"));
                    Double dummy = Double.parseDouble(rs.getString("DNI"));
                    temp.setPrecio(dummy);
                    temp.setDescripcion(rs.getString("Descripcion"));
                    temp.setCodigoDeBarras(rs.getString("Cod_barras"));
                    Integer dummy2 = Integer.parseInt(rs.getString("Stock"));
                    temp.setStock(dummy2);
                    ret.add(temp);
                }
            }
        }
        catch (SQLException e)
        {
            throw new SQLException("No se ha podido dar de baja el producto. \nError: " + e.getMessage());
        }
        return ret;
    }

    @Override
    public TProducto mostrarProducto(int ID) throws Exception {
        Statement query = null;
        Connection connection = null;
        TProducto ret = new TProducto();        
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
            if (rs.next())
            {
                if (rs.getString("Disponible").equalsIgnoreCase("1"))
                {
                    Integer id = Integer.parseInt(rs.getString("id_producto"));
                    ret.setId(id);                    
                    ret.setNombre(rs.getString("Nombre"));
                    Double dummy = Double.parseDouble(rs.getString("DNI"));
                    ret.setPrecio(dummy);
                    ret.setDescripcion(rs.getString("Descripcion"));
                    ret.setCodigoDeBarras(rs.getString("Cod_barras"));
                    Integer dummy2 = Integer.parseInt(rs.getString("Stock"));
                    ret.setStock(dummy2);
                }
                else
                    throw new Exception("Ese producto está dado de baja");
            }
        }
        catch (SQLException e)
        {
            throw new SQLException("No se ha podido mostrar el producto. \nError: " + e.getMessage());
        }
        return ret;
    }

    @Override
    public Boolean modificarProducto(TProducto producto) throws Exception {
        Statement query = null;
        Connection connection = null;        
        String contenido_query = "UPDATE Productos SET Nombre='" + producto.getNombre()+ "', Precio='" + producto.getPrecio();
               contenido_query += "', Descripcion='" + producto.getDescripcion() + "', Cod_barras='" + producto.getCodigoDeBarras() + "', Stock=" + producto.getStock() + " WHERE id_producto = " + producto.getId() + ";";
        
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
            query.executeUpdate(contenido_query);
        }
        catch (SQLException ex)
        {            
            throw new Exception("Error al actualizar en la tabla de productos \nError: " + ex.getMessage());            
        }                                    
        return false;
    }
    
}
