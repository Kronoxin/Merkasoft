/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.cliente.SACliente.Imp;

import Negocio.cliente.SACliente.SACliente;
import Negocio.cliente.TCliente;
import Negocio.cliente.TClienteNormal;
import Negocio.cliente.TClienteVip;
import integracion.DAO.factoriaDAO.FactoriaDAO;
import integracion.transaction.Imp.TransactionMysql;
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
    public int altaCliente(TCliente cliente)throws Exception {

        int id=-1;
        TCliente clienteTemp = null;
            
                 TransactionMysql transaccion=new TransactionMysql();
                 TransactionManager.obtenerInstanacia().nuevaTransaccion();
                 
                 try
                      {
                         transaccion.start();
                         transaccion.lock("Productos");
                     }
                 catch(Exception e)
                 {
                       TransactionManager.obtenerInstanacia().eliminaTransaccion();
                  }

		if(cliente.getClass().equals(TClienteVip.class)){

                    clienteTemp = FactoriaDAO.obtenerInstancia().getDAOCliente().mostrarCliente(cliente.getId());

                    if(clienteTemp == null){

                            
                            id = FactoriaDAO.obtenerInstancia().getDAOCliente().altaCliente(cliente);
                        try {
                            transaccion.commit();
                        } catch (Exception ex) {
                          throw new Exception(ex.getMessage());
                        }
                            TransactionManager.obtenerInstanacia().eliminaTransaccion();
                            
                            
				
                    }
                    else if (clienteTemp != null && clienteTemp.isActivo()==true ){

                                
                                cliente.setDNI(cliente.getDNI());
                                FactoriaDAO.obtenerInstancia().getDAOCliente().modificarCliente(cliente);
                                transaccion.commit();
                                TransactionManager.obtenerInstanacia().eliminaTransaccion();
				

                    }
		}
		else if(cliente.getClass().equals(TClienteNormal.class)){

			clienteTemp = FactoriaDAO.obtenerInstancia().getDAOCliente().mostrarCliente(cliente.getId());

			if(clienteTemp == null){
                               
                            id = cliente.getId();
                            transaccion.commit();
                            TransactionManager.obtenerInstanacia().eliminaTransaccion();
			

			}
			 else if (clienteTemp != null && clienteTemp.isActivo()==true ){

                                
                                cliente.setDNI(cliente.getDNI());
                                FactoriaDAO.obtenerInstancia().getDAOCliente().modificarCliente(cliente);
                                transaccion.commit();
                                TransactionManager.obtenerInstanacia().eliminaTransaccion();
				

                        }
		}

		

		return id;
    }
// elimnar por id
    public boolean eliminarCliente(int  id) throws Exception{
        
        TransactionMysql transaccion=new TransactionMysql();
        TransactionManager.obtenerInstanacia().nuevaTransaccion();
                try{
                 transaccion.start();
                 transaccion.lock("Clientes");
                 }catch(Exception e){
                        TransactionManager.obtenerInstanacia().eliminaTransaccion();
                 }
        
        boolean ok = true;

        
         TCliente cliente = FactoriaDAO.obtenerInstancia().getDAOCliente().mostrarCliente(id);
        
         
         if (cliente == null){
             ok = false;
            try {
                transaccion.rollback();
            } catch (Exception  ex) {
                 throw new Exception(ex.getMessage());
            }
            TransactionManager.obtenerInstanacia().eliminaTransaccion();
         
         
         }else if(cliente.isActivo()== false){
             ok = false;
             transaccion.rollback();
            TransactionManager.obtenerInstanacia().eliminaTransaccion();
         
         }else{
             
             FactoriaDAO.obtenerInstancia().getDAOCliente().bajaCliente(id);
             transaccion.commit();
             TransactionManager.obtenerInstanacia().eliminaTransaccion();

                     
         }
        



        return ok;
    }

    @Override
    public boolean modificarCliente(TCliente cliente)throws Exception {
        
        boolean ok=false;
        TransactionMysql transaccion=new TransactionMysql();
        TransactionManager.obtenerInstanacia().nuevaTransaccion();
        
                try{
             
                 transaccion.start();
                 transaccion.lock("Clientes");
                 }catch(Exception e){
                        TransactionManager.obtenerInstanacia().eliminaTransaccion();
                 }
        
        if(cliente !=null){
        
            FactoriaDAO.obtenerInstancia().getDAOCliente().modificarCliente(cliente);
            try {
                transaccion.commit();
            } catch (Exception ex) {
                throw new Exception(ex.getMessage());
            }
            TransactionManager.obtenerInstanacia().eliminaTransaccion();
            
            ok = true;           
        
        }else{
            
            try {
                transaccion.rollback();
            } catch (Exception ex) {
                throw new Exception(ex.getMessage());
            }            
            TransactionManager.obtenerInstanacia().eliminaTransaccion();
        
        
        }
        
        

        return ok;
    }

    //mostrar por id
    @Override
    public TCliente mostrarCliente(int id)throws Exception {
            
            TransactionMysql transaccion=new TransactionMysql();
            TransactionManager.obtenerInstanacia().nuevaTransaccion();
            try
                  {
                 transaccion.start();
                 transaccion.lock("Productos");
                 }
            catch(Exception e)
                   {
                   TransactionManager.obtenerInstanacia().eliminaTransaccion();
                }
             
             TCliente cliente = FactoriaDAO.obtenerInstancia().getDAOCliente().mostrarCliente(id);
             
             if(cliente !=null){
             
                    if(cliente.isActivo()== false){
                        
                        try {
                            transaccion.commit();
                        } catch (Exception ex) {
                            throw new Exception(ex.getMessage());
                        }
                         TransactionManager.obtenerInstanacia().eliminaTransaccion();
                    
                    }
                     
             }else{
                 try {
                 transaccion.rollback();
                 }catch(Exception ex){
                        throw new Exception(ex.getMessage());
                 }
                TransactionManager.obtenerInstanacia().eliminaTransaccion();
             
             
             }
        
             return cliente;
    }

    @Override
    public ArrayList<TCliente> mostrarListaCliente() {
                

                ArrayList<TCliente> listaProductos;
                TransactionMysql transaccion=new TransactionMysql();
                TransactionManager.obtenerInstanacia().nuevaTransaccion();
                try
                    {
                     transaccion.start();
                     transaccion.lock("Productos");
                     }
                 catch(Exception e)
                     {
                       TransactionManager.obtenerInstanacia().eliminaTransaccion();
                        }
                listaProductos=FactoriaDAO.obtenerInstancia().getDAOCliente().listarClientes();
        return listaProductos;
    }

    @Override
    public ArrayList<TCliente> mostrarClientesMedia() {
        
        double media;
        

                ArrayList<TCliente> listaProductos;
                
                TransactionMysql transaccion=new TransactionMysql();
                TransactionManager.obtenerInstanacia().nuevaTransaccion();
               
                
                try
                    {
                     transaccion.start();
                      transaccion.lock("Productos");
                     }
                catch(Exception e)
                     {
                           TransactionManager.obtenerInstanacia().eliminaTransaccion();
                     }
                
                
                listaProductos=FactoriaDAO.obtenerInstancia().getDAOCliente().listarClientes();
                
                          
                
                
                
                
                
                        
           return listaProductos;
        
    }

    
    
}
