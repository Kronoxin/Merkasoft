/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.FactoriaSA;

import Negocio.FactoriaSA.Imp.FactoriaSAImp;
import Negocio.cliente.SACliente.Imp.SAClienteImp;
import Negocio.cliente.SACliente.SACliente;
import Negocio.producto.SAProducto.Imp.SAProductoImp;
import Negocio.producto.SAProducto.SAProducto;
import Negocio.venta.SAVenta.Imp.SAVentaImp;
import Negocio.venta.SAVenta.SAVenta;

/**
 *
 * @author borja
 */
public abstract class FactoriaSA {
    
    private static FactoriaSA _instance = null;


	public abstract SACliente generaSACliente();

	public abstract SAProducto generaSAProducto();

	public abstract SAVenta generaSAVenta();
        
        
        
     public static FactoriaSA obtenerInstancia() {

		
		if (_instance == null) {

			_instance = new FactoriaSAImp();
		}

		return _instance;
    }
     
}
