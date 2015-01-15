/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.FactoriaSA;

import javax.persistence.EntityManager;
import negocio.FactoriaSA.Imp.FactoriaSAImp;
import negocio.cliente.SACliente.Imp.SAClienteImp;
import negocio.cliente.SACliente.SACliente;
import negocio.producto.SAProducto.Imp.SAProductoImp;
import negocio.producto.SAProducto.SAProducto;
import negocio.venta.SAVenta.Imp.SAVentaImp;
import negocio.venta.SAVenta.SAVenta;

/**
 *
 * @author borja
 */
public abstract class FactoriaSA {
    
    private static FactoriaSA _instance = null;
       


	public abstract SACliente generaSACliente();

	public abstract SAProducto generaSAProducto();

	public abstract SAVenta generaSAVenta();
        
        public abstract SAVenta generaSAEmpleado();
        
        public abstract SAVenta generaSADepartamento();
        
        public abstract SAVenta generaSATurno();
        
        
        
     public static FactoriaSA obtenerInstancia() {

		
		if (_instance == null) {

			_instance = new FactoriaSAImp();
		}

		return _instance;
    }
     
}
