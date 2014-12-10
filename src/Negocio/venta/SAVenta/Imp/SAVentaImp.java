/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.venta.SAVenta.Imp;

import Negocio.venta.SAVenta.SAVenta;
import Negocio.venta.TCompraArticulo;
import Negocio.venta.TVenta;
import integracion.DAO.factoriaDAO.FactoriaDAO;
import integracion.transaction.Imp.TransactionMysql;
import integracion.transaction.transactionManager.TransactionManager;
import java.util.ArrayList;

/**
 *
 * @author borja
 */
public class SAVentaImp implements SAVenta{

    @Override
    public int altaventa(TVenta venta) {

        int idVenta;
        
        TransactionManager.obtenerInstanacia().nuevaTransaccion();
        try
        {
            TransactionManager.obtenerInstanacia().getTransaccion().start();
            TransactionManager.obtenerInstanacia().getTransaccion().lock("Ventas");   
            //Si el producto no existe lo insertamos
            TVenta tVenta=FactoriaDAO.obtenerInstancia().getDAOVenta().mostrarVenta(venta.getId());
            if(tVenta==null)
            {
                 if(FactoriaDAO.obtenerInstancia().getDAOVenta().altaVenta(venta)==1)
                {
                    idVenta=venta.getId();
                    //transaccion.commit();
                    TransactionManager.obtenerInstanacia().eliminaTransaccion();
                }
            }
            else if(tVenta!=null && tVenta.isActivo())
            {
                idVenta=tVenta.getId();
                //transaccion.rollback();
                TransactionManager.obtenerInstanacia().eliminaTransaccion();
            }
            else
            {
                idVenta=0;
                //transaccion.rollback();
                TransactionManager.obtenerInstanacia().eliminaTransaccion();
            }
        }
        catch(Exception e)
        {
            idVenta = -1;
            TransactionManager.obtenerInstanacia().eliminaTransaccion();
        }
        return 1;
    }

    @Override
    public boolean devolucionProducto(TCompraArticulo articulo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TVenta mostrarVenta(int id) 
    {
        TVenta tVenta=null;
        TransactionManager.obtenerInstanacia().nuevaTransaccion();
        try
        {
            //Iniciamos la transsacion y bloqueamos la tabla a modificar
            TransactionManager.obtenerInstanacia().getTransaccion().start();
            //buscamos el producto en la BBDD
            tVenta= FactoriaDAO.obtenerInstancia().getDAOVenta().mostrarVenta(id);
            //Eliminamos la transaccion
            TransactionManager.obtenerInstanacia().eliminaTransaccion();
        }
        catch(Exception e)
        {
            TransactionManager.obtenerInstanacia().eliminaTransaccion();
        } 
        return tVenta;
    }

    @Override
    public ArrayList<TVenta> mostrarListaVenta() 
    {
        ArrayList<TVenta> listaVentas=null;
        TransactionManager.obtenerInstanacia().nuevaTransaccion();
        try
        {
            //Iniciamos la transsacion y bloqueamos la tabla a modificar
            TransactionManager.obtenerInstanacia().getTransaccion().start();
            //Extraemos la lista de productos de la BBDD
            listaVentas= FactoriaDAO.obtenerInstancia().getDAOVenta().listarVentas();
            //Eliminamos la transaccion
            TransactionManager.obtenerInstanacia().eliminaTransaccion();
        }
        catch(Exception e)
        {
            TransactionManager.obtenerInstanacia().eliminaTransaccion();
        } 
        return listaVentas;
    }
    
}
