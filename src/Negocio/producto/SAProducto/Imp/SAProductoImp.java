/**
 * esta clase implementa la interfaz del servicio de aplicacion de producto
 */
package Negocio.producto.SAProducto.Imp;

import Negocio.producto.SAProducto.SAProducto;
import Negocio.producto.TProducto;
import integracion.DAO.factoriaDAO.FactoriaDAO;
import integracion.transaction.Imp.TransactionMysql;
import integracion.transaction.transactionManager.TransactionManager;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class SAProductoImp implements SAProducto{

    @Override
    //Esta metodo permite dar de alta un producto en BBDD comprobando que este no exista ya en ella
    public String altaProducto(TProducto producto) {
        TransactionMysql transaccion=new TransactionMysql();
        TransactionManager.obtenerInstanacia().nuevaTransaccion();
        transaccion.start();
        transaccion.lock();

        String codigoBarras=null;

        TProducto tProducto = FactoriaDAO.obtenerInstancia().getDAOProducto().mostrarProducto(producto.getCodigoDeBarras());

        if(tProducto==null){	
                if(FactoriaDAO.obtenerInstancia().getDAOProducto().altaProducto(producto) == 1){

                        codigoBarras=producto.getCodigoDeBarras();
                        transaccion.commit();
                        TransactionManager.obtenerInstanacia().eliminaTransaccion();
                }
        }
        else if(tProducto!=null && tProducto.getActivo()==true){

               codigoBarras=tProducto.getCodigoDeBarras();
        }

        if(codigoBarras==null){

                transaccion.rollback();
                TransactionManager.obtenerInstanacia().eliminaTransaccion();

        }
        return codigoBarras;     
    }

    @Override
    //Este metodo permite la eliminacion de un producto de la BBDD
    public boolean bajaProducto(String codigoBarras) {
        TransactionMysql transaccion=new TransactionMysql();
        TransactionManager.obtenerInstanacia().nuevaTransaccion();
        transaccion.start();
        transaccion.lock();
        boolean correcto=false;
        TProducto tProducto = FactoriaDAO.obtenerInstancia().getDAOProducto().mostrarProducto(codigoBarras);
        if(tProducto!=null){
            if(tProducto.getActivo()==true)
            {
                tProducto.setActivo(false);
                //deberia pasarsele el transfer no el codigo de barras
                FactoriaDAO.obtenerInstancia().getDAOProducto().bajaProducto(codigoBarras);
                correcto=true;
                transaccion.commit();
                TransactionManager.obtenerInstanacia().eliminaTransaccion();
            }	
        }
        else
        {
            transaccion.rollback();
            TransactionManager.obtenerInstanacia().eliminaTransaccion();
        }
        return correcto;
    }

    @Override
    //Metodo que permite la modificacion de un producto existente en la BBDD
    public boolean modificarProducto(TProducto producto) {
        boolean correcto=false;
        TransactionMysql transaccion=new TransactionMysql();
        TransactionManager.obtenerInstanacia().nuevaTransaccion();
        transaccion.start();
        transaccion.lock();
        TProducto tProducto = FactoriaDAO.obtenerInstancia().getDAOProducto().mostrarProducto(producto.getCodigoDeBarras());
        if(tProducto!=null && !tProducto.equals(producto))
        {
            FactoriaDAO.obtenerInstancia().getDAOProducto().modificarProducto(producto);
            transaccion.commit();
            TransactionManager.obtenerInstanacia().eliminaTransaccion();
            correcto=true;
        }
        else
        {
            transaccion.rollback();
            TransactionManager.obtenerInstanacia().eliminaTransaccion();
        }
        return correcto;
    }

    @Override
    //Metodo que muestra el producto solicitado mediante un codigo de barras en caso de que este exista en la BBDD
    public TProducto mostrarProducto(String codigoBarras) {
        TransactionMysql transaccion=new TransactionMysql();
        TransactionManager.obtenerInstanacia().nuevaTransaccion();
        transaccion.start();

        TProducto tProducto = FactoriaDAO.obtenerInstancia().getDAOProducto().mostrarProducto(codigoBarras);

        if(tProducto!=null){
                if(tProducto.getActivo()==true){
                    transaccion.commit();
                    TransactionManager.obtenerInstanacia().eliminaTransaccion();		
                }	
        }
        else{
            transaccion.rollback();
            TransactionManager.obtenerInstanacia().eliminaTransaccion();
        }


        return tProducto;
    }

    @Override
    //Metodo que genera un lista de todos los productos existentes en la BBDD que esten activos
    public ArrayList<TProducto> mostrarListaProducto() 
    {
        ArrayList<TProducto> listaProductos;
        TransactionMysql transaccion=new TransactionMysql();
        TransactionManager.obtenerInstanacia().nuevaTransaccion();
        transaccion.start();
        listaProductos=FactoriaDAO.obtenerInstancia().getDAOProducto().listarProducto();
        return listaProductos;
    }
}
