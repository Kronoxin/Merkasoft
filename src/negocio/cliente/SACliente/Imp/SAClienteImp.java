/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.cliente.SACliente.Imp;

import Negocio.cliente.SACliente.SACliente;
import Negocio.cliente.TCliente;
import integracion.DAO.factoriaDAO.FactoriaDAO;
import integracion.query.factoriaQuery.FactoriaQuery;
import integracion.transaction.transactionManager.TransactionManager;
import java.util.ArrayList;

/*
* Clase SAClienteImp: implementa la interfaz SACliente, se encarga del modelo de negocio de cliente 
 * (alta, baja, mostrar por id, mostrar todos, modificar)
*/
public class SAClienteImp implements SACliente{

    /**
	 * Metodo altaCliente: recibe como parametro de entrada un cliente, comprueba si es normal
	 * o vip e interactua con la capa de integracion (DAOS) para almacenar los datos.
	 * Devuleve el id del cliente.
	 */
    
    //devuelve un id
    @Override
    public int altaCliente(TCliente cliente) 
    {

         int idCliente =-1;
        
        TransactionManager.obtenerInstanacia().nuevaTransaccion();
        
        
        try{
            
            TransactionManager.obtenerInstanacia().getTransaccion().start();
       
            
            TCliente tCliente = FactoriaDAO.obtenerInstancia().getDAOCliente().mostrarCliente(cliente.getId());
            
            //Si el cliente no existe lo insertamos
            
            if(tCliente == null)
            {
             
              idCliente = FactoriaDAO.obtenerInstancia().getDAOCliente().altaCliente(cliente);  
              
              if(idCliente > 0)
              {
                       TransactionManager.obtenerInstanacia().getTransaccion().commit();
              }                 
            
            
            }
            else{
            
            idCliente = tCliente.getId();
            
            // Si el cliente  existe  y no esta activo lo activamos
            
                if(!tCliente.isActivo()){
                
                   
                   tCliente.setActivo(true);
                   //MOdificamos el cliente
                   if(!FactoriaDAO.obtenerInstancia().getDAOCliente().modificarCliente(tCliente)){
                   
                      // Si no se ha podido modificar cambiamos la id a -1.
                        idCliente = -1;
                                
                   
                   }
                   //Eliminamos la transaccion
                   
                   TransactionManager.obtenerInstanacia().eliminaTransaccion();
                }
            
            
            
            
            }
            
        
        }
        catch(Exception e){
            
            idCliente = -1;
             try 
             {
                 TransactionManager.obtenerInstanacia().getTransaccion().rollback();
             } catch (Exception ex) 
             {
                 ex.printStackTrace();
             }
            TransactionManager.obtenerInstanacia().eliminaTransaccion();
            
        
        }
        
        return idCliente;
    
        
    }
// eliminar por id
    public boolean eliminarCliente(int  id)
    {
        
        boolean correcto = false;
        
        TransactionManager.obtenerInstanacia().nuevaTransaccion();
        
        try
        {
            TransactionManager.obtenerInstanacia().getTransaccion().start();
                        
            TCliente tCliente = FactoriaDAO.obtenerInstancia().getDAOCliente().mostrarCliente(id);
                       
            // Si existe el cliente
            if(tCliente != null)
            {
                // Si el cliente esta activo lo damos de baja.
                if(tCliente.isActivo() == true)
                {
                    // Si se da de baja correctamente.
                    if(FactoriaDAO.obtenerInstancia().getDAOCliente().bajaCliente(id))
                    {                         
                        // Hacemos el commit.
                        try
                        {                             
                            TransactionManager.obtenerInstanacia().getTransaccion().commit();
                            correcto = true;

                        }
                        catch(Exception e)
                        {                                   
                            TransactionManager.obtenerInstanacia().getTransaccion().rollback();
                                                            
                        }
                    }
                    else
                    {
                        correcto = false;
                        TransactionManager.obtenerInstanacia().getTransaccion().rollback();
                    }
                        
                }              
            }
            else
            {           
                            // Echamos para atras la transaccion
                TransactionManager.obtenerInstanacia().getTransaccion().rollback();                  
            }     
             TransactionManager.obtenerInstanacia().eliminaTransaccion();
        }
        catch(Exception e )
        {
        
            TransactionManager.obtenerInstanacia().eliminaTransaccion();
            try 
            {
                TransactionManager.obtenerInstanacia().getTransaccion().rollback();
            } 
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
        }
        
       return correcto;
    }

    //falta por hacer
    @Override
    public boolean modificarCliente(TCliente cliente) 
    {
        
      boolean correcto = false;
      TransactionManager.obtenerInstanacia().nuevaTransaccion();
      
       try
       {
            TransactionManager.obtenerInstanacia().getTransaccion().start();
      
      TCliente tCliente = FactoriaDAO.obtenerInstancia().getDAOCliente().mostrarCliente(cliente.getId());
     
      if(tCliente !=null  && !tCliente.equals(cliente))
      {
          
          
          if(FactoriaDAO.obtenerInstancia().getDAOCliente().modificarCliente(cliente))
          {
          
          try
          {
              TransactionManager.obtenerInstanacia().getTransaccion().commit();
              correcto = true;
          
          }//si falla el commit
          catch(Exception e){
          
              TransactionManager.obtenerInstanacia().getTransaccion().rollback();
              correcto = false;
              
          }
                    
          }
            
      }
      else{
      
      //echamos para atras la transaccion
          
          TransactionManager.obtenerInstanacia().getTransaccion().rollback();
          correcto = false;
      
      }
      
      //Eliminamos la transaccion
      TransactionManager.obtenerInstanacia().eliminaTransaccion();
      
      
      }
      catch(Exception e ){
          try {
              TransactionManager.obtenerInstanacia().getTransaccion().rollback();
          } catch (Exception ex) {
              ex.printStackTrace();
          }
          TransactionManager.obtenerInstanacia().eliminaTransaccion();
          correcto = false;
      
      }
       return correcto;
    }

    //mostrar por id
    @Override
    public TCliente mostrarCliente(int id) 
    {
            
        TCliente tCliente = null;
        TransactionManager.obtenerInstanacia().nuevaTransaccion();
        
        
        try{
            
            TransactionManager.obtenerInstanacia().getTransaccion().start();
            
             tCliente = FactoriaDAO.obtenerInstancia().getDAOCliente().mostrarCliente(id);
             
             TransactionManager.obtenerInstanacia().eliminaTransaccion();
            
            
        }
        catch(Exception e )
        {       
            TransactionManager.obtenerInstanacia().eliminaTransaccion();        
        }
            
        
             return tCliente;
    }
//diferenciar entre lista de clientes normal o vip
    @Override
    public ArrayList<TCliente> mostrarListaCliente() 
    {
                

                ArrayList<TCliente> listaClientes=null;
                TransactionManager.obtenerInstanacia().nuevaTransaccion();
                try
                    {
                        TransactionManager.obtenerInstanacia().getTransaccion().start();
                        listaClientes = FactoriaDAO.obtenerInstancia().getDAOCliente().listarClientes();
                        TransactionManager.obtenerInstanacia().eliminaTransaccion();
                     }
                 catch(Exception e)
                     {
                       TransactionManager.obtenerInstanacia().eliminaTransaccion();
                        }
        return listaClientes;
    }
    //falta por hacer 
    @Override
    public ArrayList<TCliente> mostrarClientesMedia() 
    {
        
        ArrayList<TCliente> listaClientes;
        
        listaClientes = (ArrayList<TCliente>)FactoriaQuery.getInstance().obtenerQueryClientesMedia().execute(null);
        
        return listaClientes;
        
    }

    
    
}
