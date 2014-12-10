/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracion.DAO.venta.Imp;

import Negocio.venta.TCompraArticulo;
import Negocio.venta.TVenta;
import integracion.DAO.venta.DAOVenta;
import integracion.transaction.transactionManager.TransactionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Ruben
 */
public class DAOVentaImp implements DAOVenta
{

    @Override
    public int altaVenta(TVenta venta, int idCliente) throws Exception 
    {
        Statement query = null;
        Connection connection = null;
        //insercion venta generico        
        String contenido_query = "INSERT INTO Ventas(Fecha, Cliente)VALUES (STR_TO_DATE('" + venta.getFecha()+ "', '%d/%m/%Y'), '" + venta.getCliente()+ "');";
        String contenido_query_2 = "INSERT INTO Venta_producto(id_venta, id_producto, Fecha, precio_actual, Cantidad VALUES (";
        
                
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
            ArrayList<TCompraArticulo> lista = venta.getListaproductos();            
            Iterator i = lista.iterator();
            while(i.hasNext())
            {
                TCompraArticulo temp = (TCompraArticulo) i.next();
                query.execute(contenido_query_2.concat(venta.getId() + " , " + temp.getIdArticulo() + " , STR_TO_DATE('" + venta.getFecha()+ "', '%d/%m/%Y'), ") + temp.getPrecio() + " , " + temp.getCantidad() + ");");
            }
        }
        catch (SQLException e)
        {
            throw new SQLException("No se ha podido dar de alta la venta. Posiblemente ya exista\nError: " + e.getMessage());
        }
         
         //Si no ha saltado excepción en este punto es porque se ha dado el alta correctamente
         query.executeUpdate("SELECT MAX(id_ventas) FROM Ventas;");
         ResultSet rs = query.getResultSet();
         rs.next();
         return rs.getInt(1);
    }

    @Override
    public Boolean bajaVenta(int ID) throws Exception 
    {
        Statement query = null;
        Connection connection = null;        
        String contenido_query = "UPDATE Productos SET Disponible = FALSE WHERE id_venta = " + ID + ";";                
                
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
            throw new SQLException("No se ha podido dar de baja el venta. \nError: " + e.getMessage());
        }
         return false;
    }

    @Override
    public ArrayList listarVentas() throws Exception 
    {
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
                    Integer id = Integer.parseInt(rs.getString("id_venta"));
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
            throw new SQLException("No se ha podido dar de baja el venta. \nError: " + e.getMessage());
        }
        return ret;
    }

    @Override
    public TVenta mostrarVenta(int ID) throws Exception 
    {
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
                    Integer id = Integer.parseInt(rs.getString("id_venta"));
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
                    throw new Exception("Ese venta está dado de baja");
            }
        }
        catch (SQLException e)
        {
            throw new SQLException("No se ha podido mostrar el venta. \nError: " + e.getMessage());
        }
        return ret;
    }

    @Override
    public Boolean devolucionProducto(TCompraArticulo articulo, int idVenta) throws Exception 
    {
        Statement query = null;
        Connection connection = null;        
        String contenido_query = "UPDATE Productos SET Nombre='" + venta.getNombre()+ "', Precio='" + venta.getPrecio()
                + "', Descripcion='" + venta.getDescripcion()+ "', Cod_barras='" + venta.getCodigoDeBarras()+ "', Stock='" + venta.getStock() + "';"; 
        
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
            query.executeQuery(contenido_query);
        }
        catch (SQLException ex)
        {            
            throw new Exception("Error al actualizar en la tabla de ventas \nError: " + ex.getMessage());            
        }                                    
        return false;
    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracion.DAO.venta.Imp;

import Negocio.venta.TCompraArticulo;
import Negocio.venta.TVenta;
import integracion.DAO.venta.DAOVenta;
import java.util.ArrayList;

/**
 *
 * @author Ruben
 */
public class DAOVentaImp implements DAOVenta
{

    @Override
    public int altaVenta(TVenta venta, int idCliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean bajaVenta(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList listarVentas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TVenta mostrarVenta(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean devolucionProducto(TCompraArticulo articulo, int idVenta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
