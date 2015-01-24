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
import negocio.departamentos.SA.SADepartamento;
import negocio.empleados.SA.SAEmpleado;
import negocio.producto.SAProducto.Imp.SAProductoImp;
import negocio.producto.SAProducto.SAProducto;
import negocio.venta.SAVenta.Imp.SAVentaImp;
import negocio.venta.SAVenta.SAVenta;
import negocio.turnos.SA.SATurno;


public abstract class FactoriaSA {
    
    private static FactoriaSA _instance = null;
       


	public abstract SACliente generaSACliente();

	public abstract SAProducto generaSAProducto();

	public abstract SAVenta generaSAVenta();
        
        public abstract SAEmpleado generaSAEmpleado();
        
        public abstract SADepartamento generaSADepartamento();
        
        public abstract SATurno generaSATurno();
        
        
        
     public static FactoriaSA obtenerInstancia() {

		
		if (_instance == null) {

			_instance = new FactoriaSAImp();
		}

		return _instance;
    }
     
}
