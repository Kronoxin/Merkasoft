/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracion.DAO.venta.Imp;

import negocio.cliente.TCliente;
import negocio.venta.TCompraArticulo;
import negocio.venta.TVenta;
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
        String contenido_query = "INSERT INTO Ventas(Fecha, Cliente)VALUES (STR_TO_DATE('02/03/1989', '%d/%m/%Y'), " + venta.getCliente().getId()+ ");";
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
         query.execute("SELECT MAX(id_ventas) FROM Ventas;");
         ResultSet rs = query.getResultSet();
         rs.next();
         return rs.getInt(1);
    }

    

    @Override
    public ArrayList<TVenta> listarVentas() throws Exception 
    {
        Statement query = null;
        Connection connection = null;
        TVenta temp = new TVenta();
        ArrayList<TVenta> ret = new ArrayList<TVenta>(); 
        ArrayList<TVenta> ret2 = new ArrayList<TVenta>();
        String contenido_query = "SELECT * FROM Ventas";           
                
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
                                
                    TCliente cliente = new TCliente();
                    Integer dummy = Integer.parseInt(rs.getString("id_ventas"));
                    temp.setId(dummy);
                    dummy = Integer.parseInt(rs.getString("Cliente"));
                    cliente.setId(dummy);
                    temp.setCliente(cliente);                    
                    temp.setFecha(rs.getDate("Fecha"));                    
                    temp.setListaproductos(new ArrayList<TCompraArticulo>());
                    ret.add(temp);                
            }
            for (int i = 0; i < ret.size(); i++)
            {
                
            
                query.execute("SELECT * FROM Venta_producto WHERE id_venta = " + ret.get(i).getId() + ";");
                ResultSet rs2 = query.getResultSet();
                ArrayList<TCompraArticulo> lista = new ArrayList<TCompraArticulo>();
                TCompraArticulo art_actual = new TCompraArticulo();
                while (rs2.next())
                {
                    art_actual.setIdArticulo(rs2.getInt("id_producto"));
                    art_actual.setCantidad(rs2.getInt("Cantidad"));
                    art_actual.setPrecio(rs2.getDouble("precio_actual"));
                    lista.add(art_actual);
                }
                TVenta dummy = ret.get(i);
                dummy.setListaproductos(lista);
                ret2.add(dummy);
            }
        }
        catch (SQLException e)
        {
            throw new SQLException("No se ha podido mostrar las ventas. \nError: " + e.getMessage());
        }
        return ret2;
    }

    @Override
    public TVenta mostrarVenta(int ID) throws Exception 
    {
        Statement query = null;
        Connection connection = null;
        TVenta ret = new TVenta();        
        String contenido_query = "SELECT * FROM Ventas WHERE id_ventas=" + ID + ";";           
                
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
                                
                    TCliente cliente = new TCliente();
                    Integer dummy = Integer.parseInt(rs.getString("id_ventas"));
                    ret.setId(dummy);
                    dummy = Integer.parseInt(rs.getString("Cliente"));
                    cliente.setId(dummy);
                    ret.setCliente(cliente);                    
                    ret.setFecha(rs.getDate("Fecha"));
                    query.execute("SELECT * FROM Venta_producto WHERE id_venta = " + rs.getInt("id_ventas") + ";");
                    ResultSet rs2 = query.getResultSet();
                    ArrayList<TCompraArticulo> lista = new ArrayList<TCompraArticulo>();
                    TCompraArticulo art_actual = new TCompraArticulo();
                    while (rs2.next())
                    {
                        art_actual.setIdArticulo(rs2.getInt("id_producto"));
                        art_actual.setCantidad(rs2.getInt("Cantidad"));
                        art_actual.setPrecio(rs2.getDouble("precio_actual"));
                        lista.add(art_actual);
                    }
                    ret.setListaproductos(lista);               
            }
            else
                throw new Exception("No se ha podido encontrar la venta");
        }
        catch (SQLException e)
        {
            throw new SQLException("No se ha podido mostrar la venta. \nError: " + e.getMessage());
        }
        return ret;
    }

    @Override
    public Boolean devolucionProducto(TCompraArticulo articulo, int idVenta) throws Exception 
    {
        Statement query = null;
        Connection connection = null;        
        String contenido_query = "UPDATE Venta_producto SET Cantidad=Cantidad - 1 WHERE id_venta = "  + idVenta + " AND id_producto = " + articulo.getIdArticulo() + ";";
        
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
            throw new Exception("Error al devolver el producto. \nError: " + ex.getMessage());            
        }                                    
        return false;
    }

}
