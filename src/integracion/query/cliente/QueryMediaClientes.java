/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracion.query.cliente;

import integracion.query.Query;
import integracion.transaction.transactionManager.TransactionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import negocio.cliente.TCliente;


public class QueryMediaClientes implements Query
{

    @Override
    public Object execute(Object datos) 
    {
        
        Connection connection = null;
        String query = null;        
        ArrayList<TCliente> listaClientes = new ArrayList<>();
        Statement queryEjecucion;
      
            query = "SELECT id_cliente,dni,nombre,apellidos,fecha_nacimiento,disponible,tipo\n" +
"FROM(\n" +
"SELECT id_cliente,dni,nombre,apellidos,fecha_nacimiento,disponible,tipo,sumaCol,AVG(sumaCol) AS media\n" +
"FROM clientes\n" +
"LEFT JOIN(\n" +
"SELECT * FROM ventas\n" +
"LEFT JOIN(\n" +
"SELECT id_venta,SUM(precio_actual*cantidad)AS sumaCol\n" +
"FROM venta_producto\n" +
"GROUP BY id_venta)AS suma\n" +
"ON ventas.id_ventas = suma.id_venta) AS relacionClienteVentas\n" +
"ON clientes.id_cliente = relacionClienteVentas.cliente) AS tablaFinal\n" +
"WHERE sumaCol >= media"; 
     
        
        try
        {
            connection = (Connection) TransactionManager.obtenerInstanacia().getTransaccion().getResource();
            queryEjecucion = connection.createStatement();
            queryEjecucion.executeQuery(query);
            ResultSet rs = queryEjecucion.getResultSet();
            
            while(rs.next())
            {
                TCliente temp = new TCliente();
                
                temp.setId(rs.getInt(0));
                temp.setDNI(rs.getString(1));
                temp.setNombre(rs.getString(2));
                temp.setApellidos(rs.getString(3));
                temp.setFechaNacimiento(rs.getString(4));
                temp.setActivo(rs.getBoolean(5));
                
                listaClientes.add(temp);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
              
        return listaClientes;
    }
        
    
}
