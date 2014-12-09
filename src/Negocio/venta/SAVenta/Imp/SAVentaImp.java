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
        TransactionMysql transaccion=new TransactionMysql();
        TransactionManager.obtenerInstanacia().nuevaTransaccion();
        transaccion.start();
        transaccion.lock();
        
        int idVenta=0;
        
        TVenta tVenta=FactoriaDAO.obtenerInstancia().getDAOVenta().mostrarVenta(venta.getId());
        if(tVenta==null)
        {
             if(FactoriaDAO.obtenerInstancia().getDAOVenta().altaVenta(venta)==1)
            {
                idVenta=venta.getId();
                transaccion.commit();
                TransactionManager.obtenerInstanacia().eliminaTransaccion();
            }
        }
        else if(tVenta!=null && tVenta.isActivo())
        {
            idVenta=tVenta.getId();
            transaccion.rollback();
            TransactionManager.obtenerInstanacia().eliminaTransaccion();
        }
        else
        {
            idVenta=0;
            transaccion.rollback();
            TransactionManager.obtenerInstanacia().eliminaTransaccion();
        }
        return idVenta;
    }

    @Override
    public boolean devolucionProducto(TCompraArticulo articulo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TVenta mostrarVenta(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TVenta> mostrarListaVenta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
