/**
 * esta clase implementa la interfaz del servicio de aplicacion de producto
 */
package Negocio.producto.SAProducto.Imp;

import Negocio.producto.SAProducto.SAProducto;
import Negocio.producto.TProducto;
import integracion.DAO.factoriaDAO.FactoriaDAO;
import integracion.transaction.Imp.TransactionMysql;
import integracion.transaction.Transaction;
import integracion.transaction.transactionManager.TransactionManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SAProductoImp implements SAProducto{

    @Override
    //Esta metodo permite dar de alta un producto en BBDD comprobando que este no exista ya en ella
    public String altaProducto(TProducto producto) {
        TransactionManager.obtenerInstanacia().nuevaTransaccion();
        new TransactionMysql().start();

        String codigoBarras=null;

        TProducto tProducto = FactoriaDAO.obtenerInstancia().getDAOProducto().mostrarProducto(producto.getCodigoDeBarras());

        if(tProducto==null){	
                if(FactoriaDAO.obtenerInstancia().getDAOProducto().altaProducto(producto) == 1){

                        codigoBarras=producto.getCodigoDeBarras();
                        new TransactionMysql().commit();
                        TransactionManager.obtenerInstanacia().eliminaTransaccion();
                }
        }
        else if(tProducto!=null && tProducto.getActivo()==true){

               codigoBarras=tProducto.getCodigoDeBarras();
        }

        if(codigoBarras==null){

                new TransactionMysql().rollback();
                TransactionManager.obtenerInstanacia().eliminaTransaccion();

        }
        return codigoBarras;     
    }

    @Override
    //Este metodo permie la eliminacion de un producto de la BBDD
    public boolean bajaProducto(String codigoBarras) {
        TransactionManager.obtenerInstanacia().nuevaTransaccion();
        new TransactionMysql().start();
        boolean correcto=false;
        TProducto tProducto = FactoriaDAO.obtenerInstancia().getDAOProducto().mostrarProducto(codigoBarras);
        if(tProducto!=null){
            if(tProducto.getActivo()==true)
            {
                tProducto.setActivo(false);
                //deberia pasarsele el transfer no el codigo de barras
                FactoriaDAO.obtenerInstancia().getDAOProducto().bajaProducto(tProducto);
                correcto=true;
                new TransactionMysql().commit();
                TransactionManager.obtenerInstanacia().eliminaTransaccion();
            }	
        }
        return correcto;
    }

    @Override
    public boolean modificarProducto(TProducto producto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TProducto mostrarProducto(String codigoBarras) {
        TransactionManager.obtenerInstanacia().nuevaTransaccion();
        new TransactionMysql().start();

        TProducto tProducto = FactoriaDAO.obtenerInstancia().getDAOProducto().mostrarProducto(codigoBarras);

        if(tProducto!=null){
                if(tProducto.getActivo()==true){
                        new TransactionMysql().commit();
                        TransactionManager.obtenerInstanacia().eliminaTransaccion();		
                }	
        }
        else{
            new TransactionMysql().rollback();
            TransactionManager.obtenerInstanacia().eliminaTransaccion();
        }


        return tProducto;
    }

    @Override
    public ArrayList<TProducto> mostrarListaProducto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
