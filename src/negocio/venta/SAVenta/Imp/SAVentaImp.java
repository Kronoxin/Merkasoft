/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.venta.SAVenta.Imp;

import negocio.venta.SAVenta.SAVenta;
import negocio.venta.TCompraArticulo;
import negocio.venta.TVenta;
import integracion.DAO.factoriaDAO.FactoriaDAO;
import integracion.transaction.transactionManager.TransactionManager;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SAVentaImp implements SAVenta{

    @Override
    public int altaventa(TVenta venta,int idCliente) {

        int idVenta = -1;
        TransactionManager.obtenerInstanacia().nuevaTransaccion();
        try
        {
            TransactionManager.obtenerInstanacia().getTransaccion().start();
        
            TVenta tVenta = FactoriaDAO.obtenerInstancia().getDAOVenta().mostrarVenta(venta.getId());
            
            //Si la venta no existe la insertamos
            if(tVenta== null)
            {
                idVenta = FactoriaDAO.obtenerInstancia().getDAOVenta().altaVenta(venta,idCliente);
                
                // Se hizo la insercion con exito.
                if(idVenta > 0)
                {
                    // Se hace el commit.
                        try
                        {
                            TransactionManager.obtenerInstanacia().getTransaccion().commit();
                        }
                        // Si falla el commit.
                        catch(Exception e)
                        {
                           idVenta = -1;
                           TransactionManager.obtenerInstanacia().getTransaccion().rollback(); 
                        }
                    
                }                                
            }
            else if(tVenta.isActivo())
            {
                idVenta= tVenta.getId();
                TransactionManager.obtenerInstanacia().getTransaccion().rollback(); 
            }
            else
            {
                TransactionManager.obtenerInstanacia().getTransaccion().rollback(); 
            }
            // Eliminamos la transaccion.
            TransactionManager.obtenerInstanacia().eliminaTransaccion();
        }
        catch(Exception e)
        {
            try { 
                TransactionManager.obtenerInstanacia().getTransaccion().rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            idVenta = -1;
            TransactionManager.obtenerInstanacia().eliminaTransaccion();
            
        }
        return idVenta;
    }

    @Override
    public boolean devolucionProducto(TCompraArticulo articulo, int idVenta) 
    {
        boolean correcto=false;
        TransactionManager.obtenerInstanacia().nuevaTransaccion();
        try
        {
            //Iniciamos la transsacion y bloqueamos la tabla a modificar
            TransactionManager.obtenerInstanacia().getTransaccion().start();
            //buscamos el producto en la BBDD
            TVenta tVenta = FactoriaDAO.obtenerInstancia().getDAOVenta().mostrarVenta(idVenta);
            //Si el producto existe lo damos de baja logica
            if(tVenta!=null){
                if(tVenta.isActivo())
                {
                    //comprobamos si se introduce en la tabla o no
                    if(FactoriaDAO.obtenerInstancia().getDAOVenta().devolucionProducto(articulo, idVenta))
                    {
                        //confirmamos la transaccion
                        try
                        {
                            TransactionManager.obtenerInstanacia().getTransaccion().commit();
                            correcto=true;
                        }
                        // Si falla el commit.
                        catch(Exception e)
                        {
                           TransactionManager.obtenerInstanacia().getTransaccion().rollback();
                        }
                    }
                }	
            }
            else
            {
                // Echamos para atras la transaccion
                TransactionManager.obtenerInstanacia().getTransaccion().rollback();
                
            }
            //Eliminamos la transaccion
            TransactionManager.obtenerInstanacia().eliminaTransaccion();
        }
        catch(Exception e)
        {
            try {
                TransactionManager.obtenerInstanacia().getTransaccion().rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            TransactionManager.obtenerInstanacia().eliminaTransaccion();
        }     
        return correcto;
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
