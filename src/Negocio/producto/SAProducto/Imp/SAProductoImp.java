/**
 * esta clase implementa la interfaz del servicio de aplicacion de producto
 */
package Negocio.producto.SAProducto.Imp;

import Negocio.producto.SAProducto.SAProducto;
import Negocio.producto.TProducto;
import integracion.DAO.factoriaDAO.FactoriaDAO;
import integracion.transaction.Transaction;
import integracion.transaction.transactionManager.TransactionManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SAProductoImp implements SAProducto{

    @Override
    //Esta clase implemena el metodo altaProducto que permite dar de alta un producto en BBDD comprobando que este no exista ya en ella
    public String altaProducto(TProducto producto) {
        TransactionManager.obtenerInstanacia().nuevaTransaccion();
        try {
            TransactionManager.obtenerInstanacia().getTransaccion().start();
        } catch (SQLException ex) {
            Logger.getLogger(SAProductoImp.class.getName()).log(Level.SEVERE, null, ex);
        }

        String codigoBarras=null;

        TProducto tProducto = FactoriaDAO.obtenerInstancia().getDAOProducto().mostrarProducto(producto.getCodigoDeBarras());

        if(tProducto==null){	
                if(FactoriaDAO.obtenerInstancia().getDAOProducto().altaProducto(producto) == 1){

                        codigoBarras=producto.getCodigoDeBarras();
                        //Falta el commit
                        TransactionManager.obtenerInstanacia().eliminaTransaccion();
                }
        }
        else if(tProducto!=null && tProducto.getActivo()==true){

               codigoBarras=tProducto.getCodigoDeBarras();
        }

        if(codigoBarras==null){

            try {
                TransactionManager.obtenerInstanacia().getTransaccion().rollback();
            } catch (SQLException ex) {
                Logger.getLogger(SAProductoImp.class.getName()).log(Level.SEVERE, null, ex);
            }
                TransactionManager.obtenerInstanacia().eliminaTransaccion();

        }
        return codigoBarras;     
    }

    @Override
    public boolean bajaProducto(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificarProducto(TProducto producto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TProducto mostrarProducto(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TProducto> mostrarListaProducto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
