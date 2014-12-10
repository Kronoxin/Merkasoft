/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.cliente.SACliente.Imp;

import Negocio.cliente.SACliente.SACliente;
import Negocio.cliente.TCliente;
import Negocio.cliente.TClienteNormal;
import Negocio.venta.TVenta;
import integracion.DAO.factoriaDAO.FactoriaDAO;
import integracion.transaction.transactionManager.TransactionManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
    public int altaCliente(TCliente cliente) {

         int idCliente =-1;
        
        TransactionManager.obtenerInstanacia().nuevaTransaccion();
        
        
        try{
            
            TransactionManager.obtenerInstanacia().getTransaccion().start();
           // TransactionManager.obtenerInstanacia().getTransaccion().lock("Clientes");
            
            TCliente tCliente = FactoriaDAO.obtenerInstancia().getDAOCliente().mostrarCliente(cliente.getId());
            
            //Si el cliente no existe lo insertamos
            
            if(tCliente == null){
                
                //comprobamos si es normal
                if(cliente.getClass().equals(TClienteNormal.class)){
                        TransactionManager.obtenerInstanacia().getTransaccion().lock("ClientesNormal");
                         idCliente = FactoriaDAO.obtenerInstancia().getDAOCliente().altaCliente(cliente);
                }
                else{
                    
                        TransactionManager.obtenerInstanacia().getTransaccion().lock("ClientesVip");
                        idCliente = FactoriaDAO.obtenerInstancia().getDAOCliente().altaCliente(cliente);
                
                
                }
                        TransactionManager.obtenerInstanacia().getTransaccion().commit();
                                
            
            
            }
            else{
            
            idCliente = tCliente.getId();
            
            // Si el cliente  existe  y no esta activo lo activamos
            
                if(!tCliente.isActivo()){
                
                   TransactionManager.obtenerInstanacia().eliminaTransaccion();
                   tCliente.setActivo(true);
                   //MOdificamos el cliente
                   // despues del modificar no haces commit?¿?¿?¿
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
            TransactionManager.obtenerInstanacia().eliminaTransaccion();
            
        
        }
        
        
        
        return idCliente;
    
        
    }
// elimnar por id
    public boolean eliminarCliente(int  id){
        
        boolean correcto = false;
        
        TransactionManager.obtenerInstanacia().nuevaTransaccion();
        
        try{
                        TransactionManager.obtenerInstanacia().getTransaccion().start();
                        
                        TCliente tCliente = FactoriaDAO.obtenerInstancia().getDAOCliente().mostrarCliente(id);
                        if(tCliente.getClass().equals(TClienteNormal.class)){
                        
                            TransactionManager.obtenerInstanacia().getTransaccion().lock("TClienteNormal");                        
                        }
                        else{
                        
                            TransactionManager.obtenerInstanacia().getTransaccion().lock("TClienteVip");                        
                        
                        }
                        
                        if(tCliente != null){
                        
                            if(tCliente.isActivo() == true){
                                
                                if(FactoriaDAO.obtenerInstancia().getDAOCliente().bajaCliente(id)){
                                
                                    //confirmamos la transaccion
                                    try{
                                    
                                        TransactionManager.obtenerInstanacia().getTransaccion().commit();
                                        correcto = true;
                                    
                                    }
                                    catch(Exception e){
                                    
                                        TransactionManager.obtenerInstanacia().getTransaccion().rollback();
                                        correcto = false;
                                    
                                    }
                                
                                
                                }
                                
                                
                            
                            }
                        
                        
                        }
                        else{
                        
                            // Echamos para atras la transaccion
                            TransactionManager.obtenerInstanacia().getTransaccion().rollback();
                        
                        
                        
                        }
                       
                        
                        
        
        }
        catch(Exception e ){
        
            TransactionManager.obtenerInstanacia().eliminaTransaccion();
        
        }
        
       return correcto;
    }

    //falta por hacer
    @Override
    public boolean modificarCliente(TCliente cliente) {
        
      boolean correcto = false;
      TransactionManager.obtenerInstanacia().nuevaTransaccion();
      
       try{
                  TransactionManager.obtenerInstanacia().getTransaccion().start();

        if(cliente.getClass().equals(TClienteNormal.class)){
                  TransactionManager.obtenerInstanacia().getTransaccion().lock("ClienteNormal");

        }
        else{
                  TransactionManager.obtenerInstanacia().getTransaccion().lock("ClienteVip");
        }
      
      TCliente tCliente = FactoriaDAO.obtenerInstancia().getDAOCliente().mostrarCliente(cliente.getId());
     
      if(tCliente !=null  && !tCliente.equals(cliente)){
          
          
          if(FactoriaDAO.obtenerInstancia().getDAOCliente().modificarCliente(cliente)){
          
          try{
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
      
      
      }
      
      //Eliminamos la transaccion
      TransactionManager.obtenerInstanacia().eliminaTransaccion();
      
      
      }
      catch(Exception e ){
      
          TransactionManager.obtenerInstanacia().eliminaTransaccion();
      
      }
       return correcto;
    }

    //mostrar por id
    @Override
    public TCliente mostrarCliente(int id) {
            
        TCliente tCliente = null;
        TransactionManager.obtenerInstanacia().nuevaTransaccion();
        
        
        try{
            
            TransactionManager.obtenerInstanacia().getTransaccion().start();
            
             tCliente = FactoriaDAO.obtenerInstancia().getDAOCliente().mostrarCliente(id);
             
             TransactionManager.obtenerInstanacia().eliminaTransaccion();
            
            
        }
        catch(Exception e ){
        
            TransactionManager.obtenerInstanacia().eliminaTransaccion();

        
        }
            
        
             return tCliente;
    }
//diferenciar entre lista de clientes normal o vip
    @Override
    public ArrayList<TCliente> mostrarListaCliente() {
                

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
    public ArrayList<TCliente> mostrarClientesMedia() {
        
        int tam =0;
        double media=0;
        int suma =0, sumatotal =0;
        
        ArrayList<TCliente> listaClientes= new ArrayList<TCliente>();
        ArrayList<TVenta> listaVentas = null;
        Map<Integer, TCliente> listaMapCliente = new HashMap<Integer, TCliente>();                      
                try{
                    
                    TransactionManager.obtenerInstanacia().getTransaccion().start();
                
                    listaVentas = FactoriaDAO.obtenerInstancia().getDAOVenta().listarVentas();
                    
                     for(int i =0; i< listaVentas.size();i++){
                
                    
                      for(int j=0; j<listaVentas.get(i).getListaproductos().size();j++){
                      
                          //suma de los articulos de un cliente
                          suma += listaVentas.get(i).getListaproductos().get(j).getPrecio();
                          
                          
                      
                      }
                      listaMapCliente.put(suma, listaVentas.get(i).getCliente());
                      sumatotal+= suma;
                      
                    
                    }      
                  media = sumatotal/listaMapCliente.size();
                  
                  Iterator it = listaMapCliente.keySet().iterator();
                  
                  while(it.hasNext()){
                  
                      Integer key = (Integer) it.next();
                      
                      if(key > media){
                      
                          listaClientes.add(listaMapCliente.get(key));
                      
                      }
                  
                  }
                  
                  
                }
                
                catch(Exception e ){
                
                    TransactionManager.obtenerInstanacia().eliminaTransaccion();
                
                }
                
                
                
                
                
                
                        
           return listaClientes;
        
    }

    
    
}
