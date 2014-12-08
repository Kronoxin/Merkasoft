/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.cliente.SACliente.Imp;

import Negocio.cliente.SACliente.SACliente;
import Negocio.cliente.TCliente;
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
    @Override
    public int altaCliente(TCliente cliente) {
        boolean ok = false;
	TCliente clienteTemp = null;

		/*TransactionManager.obtenerInstancia().nuevaTransaccion();
		TransactionManager.obtenerInstancia().getTransaccion().start();
                */
        return -1;
    }

    @Override
    public boolean eliminarCliente(int id) {
            
       /* TransactionManager.obtenerInstancia().nuevaTransaccion();
	TransactionManager.obtenerInstancia().getTransaccion().start();*/

		boolean ok = true;
		//TCliente cliente = FactoriaDAO.obtenerInstancia().getDAOCliente().obtieneClienteBD(id);

        return false;
    }

    @Override
    public boolean modificarCliente(TCliente cliente) {

    	boolean ok = false;

            /*TransactionManager.obtenerInstancia().nuevaTransaccion();
            TransactionManager.obtenerInstancia().getTransaccion().start();*/
                
        return ok;
    }

    @Override
    public boolean mostrarCliente(int id) {
                /*TransactionManager.obtenerInstancia().nuevaTransaccion();
		TransactionManager.obtenerInstancia().getTransaccion().start();*/

		boolean ok = false;
                
                return ok;
    }

    @Override
    public ArrayList<TCliente> mostrarListaCliente() {
                /*TransactionManager.obtenerInstancia().nuevaTransaccion();
		TransactionManager.obtenerInstancia().getTransaccion().start();*/

		ArrayList<TCliente> aux;

		//aux = FactoriaDAO.obtenerInstancia().getDAOCliente().listarClientes();
                
                return aux;
    }

    @Override
    public ArrayList<TCliente> mostrarClientesMedia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
