/**
 * esta clase implementa la interfaz del servicio de aplicacion de producto
 */
package Negocio.producto.SAProducto.Imp;

import Negocio.producto.SAProducto.SAProducto;
import Negocio.producto.TProducto;
import integracion.DAO.factoriaDAO.FactoriaDAO;
import integracion.transaction.transactionManager.TransactionManager;
import java.util.ArrayList;

public class SAProductoImp implements SAProducto
{

    @Override
    //Esta metodo permite dar de alta un producto en BBDD comprobando que este no exista ya en ella
    public int altaProducto(TProducto producto) 
    {
        int id_producto;
        
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
            try 
             {
                 TransactionManager.obtenerInstanacia().getTransaccion().rollback();
             } catch (Exception ex) 
             {
                 ex.printStackTrace();
             }
            TransactionManager.obtenerInstanacia().eliminaTransaccion();
        }
        return id_producto;     
    }

    @Override
    //Este metodo permite la eliminacion de un producto de la BBDD
    public boolean bajaProducto(int id) 
    {
        boolean correcto=false;
        TransactionManager.obtenerInstanacia().nuevaTransaccion();
        try
        {
            //Iniciamos la transsacion y bloqueamos la tabla a modificar
            TransactionManager.obtenerInstanacia().getTransaccion().start();
            TransactionManager.obtenerInstanacia().getTransaccion().lock("Productos");
            //buscamos el producto en la BBDD
            TProducto tProducto = FactoriaDAO.obtenerInstancia().getDAOProducto().mostrarProducto(id);
            //Si el producto existe lo damos de baja logica
            if(tProducto!=null){
                if(tProducto.getActivo()==true)
                {
                    //comprobamos si se introduce en la tabla o no
                    if(FactoriaDAO.obtenerInstancia().getDAOProducto().bajaProducto(id))
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
                           correcto=false;
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
            TransactionManager.obtenerInstanacia().eliminaTransaccion();
        }     
        return correcto;
    }

    @Override
    //Metodo que permite la modificacion de un producto existente en la BBDD
    public boolean modificarProducto(TProducto producto) 
    {
        boolean correcto=false;
        TransactionManager.obtenerInstanacia().nuevaTransaccion();
        try
        {
            //Iniciamos la transsacion y bloqueamos la tabla a modificar
            TransactionManager.obtenerInstanacia().getTransaccion().start();
            TransactionManager.obtenerInstanacia().getTransaccion().lock("Productos");
            //buscamos el producto en la BBDD
            TProducto tProducto = FactoriaDAO.obtenerInstancia().getDAOProducto().mostrarProducto(producto.getId());
            //Si el producto existe y no es igual al pasado lo modificamos
            if(tProducto!=null && !tProducto.equals(producto))
            {
                if(FactoriaDAO.obtenerInstancia().getDAOProducto().modificarProducto(producto))
                {
                    try
                    {
                        TransactionManager.obtenerInstanacia().getTransaccion().commit();
                        correcto=true;
                    }
                    // Si falla el commit.
                    catch(Exception e)
                    {
                       TransactionManager.obtenerInstanacia().getTransaccion().rollback();
                       correcto=false;
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
            TransactionManager.obtenerInstanacia().eliminaTransaccion();
        } 
        return correcto;
    }

    @Override
    //Metodo que muestra el producto solicitado mediante un codigo de barras en caso de que este exista en la BBDD
    public TProducto mostrarProducto(int id) 
    {
        TProducto tProducto=null;
        TransactionManager.obtenerInstanacia().nuevaTransaccion();
        try
        {
            //Iniciamos la transsacion y bloqueamos la tabla a modificar
            TransactionManager.obtenerInstanacia().getTransaccion().start();
            //buscamos el producto en la BBDD
            tProducto= FactoriaDAO.obtenerInstancia().getDAOProducto().mostrarProducto(id);
            //Eliminamos la transaccion
            TransactionManager.obtenerInstanacia().eliminaTransaccion();
        }
        catch(Exception e)
        {
            TransactionManager.obtenerInstanacia().eliminaTransaccion();
        } 
        return tProducto;
    }

    @Override
    //Metodo que genera un lista de todos los productos existentes en la BBDD que esten activos
    public ArrayList<TProducto> mostrarListaProducto() 
    {
        ArrayList<TProducto> listaProductos=null;
        TransactionManager.obtenerInstanacia().nuevaTransaccion();
        try
        {
            //Iniciamos la transsacion y bloqueamos la tabla a modificar
            TransactionManager.obtenerInstanacia().getTransaccion().start();
            //Extraemos la lista de productos de la BBDD
            listaProductos= FactoriaDAO.obtenerInstancia().getDAOProducto().listarProducto();
            //Eliminamos la transaccion
            TransactionManager.obtenerInstanacia().eliminaTransaccion();
        }
        catch(Exception e)
        {
            TransactionManager.obtenerInstanacia().eliminaTransaccion();
        } 
        return listaProductos;
    }
}
