/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.FactoriaSA.Imp;

import Negocio.FactoriaSA.FactoriaSA;
import Negocio.cliente.SACliente.Imp.SAClienteImp;
import Negocio.cliente.SACliente.SACliente;
import Negocio.producto.SAProducto.Imp.SAProductoImp;
import Negocio.producto.SAProducto.SAProducto;
import Negocio.venta.SAVenta.Imp.SAVentaImp;
import Negocio.venta.SAVenta.SAVenta;

/**
 * Clase FactoriaSAImp: se encarga de realizar las instanciaciones de los SA (servicion de aplicacion)
 * del modelo de negocio.
 */
public class FactoriaSAImp extends FactoriaSA {

    @Override
    public SACliente generaSACliente() {
        
	return new SAClienteImp();
    }

    @Override
    public SAProducto generaSAProducto() {
        return new SAProductoImp();

    }

    @Override
    public SAVenta generaSAVenta() {
        
        return new SAVentaImp();

    }
    
    
    
}
