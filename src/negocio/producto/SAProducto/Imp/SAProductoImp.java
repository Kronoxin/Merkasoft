/**
 * esta clase implementa la interfaz del servicio de aplicacion de producto
 */
package Negocio.producto.SAProducto.Imp;

import Negocio.producto.SAProducto.SAProducto;
import Negocio.producto.TProducto;
import integracion.DAO.factoriaDAO.FactoriaDAO;
import integracion.transaction.Imp.TransactionMysql;
import integracion.transaction.transactionManager.TransactionManager;
import java.util.ArrayList;

public class SAProductoImp implements SAProducto
{

    @Override
    //Esta metodo permite dar de alta un producto en BBDD comprobando que este no exista ya en ella
    public int altaProducto(TProducto producto) 
    {
        int id_producto = -1;
        
        TransactionManager.obtenerInstanacia().nuevaTransaccion();
        try
        {
            TransactionManager.obtenerInstanacia().getTransaccion().start();
            TransactionManager.obtenerInstanacia().getTransaccion().lock("Productos");
        
            TProducto tProducto = FactoriaDAO.obtenerInstancia().getDAOProducto().mostrarProducto(producto.getId());
            
            //Si el producto no existe lo insertamos
            if(tProducto == null)
            {
                id_producto = FactoriaDAO.obtenerInstancia().getDAOProducto().altaProducto(producto);
                
                // Se hizo la insercion con exito.
                if(id_producto > 0)
                {
                    // Se hace el commit.
                        try
                        {
                            TransactionManager.obtenerInstanacia().getTransaccion().commit();
                        }
                        // Si falla el commit.
                        catch(Exception e)
                        {
                           id_producto = -1;
                           TransactionManager.obtenerInstanacia().getTransaccion().rollback(); 
                        }
                    
                }                                
            }
            else 
            {
                id_producto= tProducto.getId();

                //Si el producto existe y no esta activo lo activamos.

                if(!tProducto.getActivo())
                {
                   TransactionManager.obtenerInstanacia().eliminaTransaccion();
                   tProducto.setActivo(true);
                    //Modificamos el producto.
                    if(!FactoriaDAO.obtenerInstancia().getDAOProducto().modificarProducto(tProducto))
                    {
                        // Si no se ha podido modificar cambiamos la id a -1.
                        id_producto = -1;
                    }
                }

            }
            // Eliminamos la transaccion.
            TransactionManager.obtenerInstanacia().eliminaTransaccion();
        }
        catch(Exception e)
        {
            id_producto = -1;
            TransactionManager.obtenerInstanacia().eliminaTransaccion();
        }
        return id_producto;     
    }

    @Override
    //Este metodo permite la eliminacion de un producto de la BBDD
    public boolean bajaProducto(int id) 
    {
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
    public boolean modificarProducto(TProducto producto) 
    {
        boolean correcto=false;
        TransactionMysql transaccion=new TransactionMysql();
        TransactionManager.obtenerInstanacia().nuevaTransaccion();
        transaccion.start();
        transaccion.lock();
        TProducto tProducto = FactoriaDAO.obtenerInstancia().getDAOProducto().mostrarProducto(producto.getI);
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
    public TProducto mostrarProducto(int id) 
    {
        TransactionMysql transaccion=new TransactionMysql();
        TransactionManager.obtenerInstanacia().nuevaTransaccion();
        transaccion.start();

        TProducto tProducto = FactoriaDAO.obtenerInstancia().getDAOProducto().mostrarProducto(id);

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
