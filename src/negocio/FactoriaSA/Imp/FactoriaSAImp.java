/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.FactoriaSA.Imp;

import javax.persistence.EntityManager;
import negocio.FactoriaSA.FactoriaSA;
import negocio.cliente.SACliente.Imp.SAClienteImp;
import negocio.cliente.SACliente.SACliente;
import negocio.departamentos.SA.Imp.SADepartamentoImp;
import negocio.departamentos.SA.SADepartamento;
import negocio.empleados.SA.SAEmpleado;
import negocio.empleados.SA.Imp.SAEmpleadoImp;
import negocio.producto.SAProducto.Imp.SAProductoImp;
import negocio.producto.SAProducto.SAProducto;
import negocio.turnos.SA.Imp.SATurnoImp;
import negocio.turnos.SA.SATurno;
import negocio.venta.SAVenta.Imp.SAVentaImp;
import negocio.venta.SAVenta.SAVenta;
import org.eclipse.persistence.internal.jpa.EntityManagerImpl;

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

    @Override
    public SAEmpleado generaSAEmpleado() {
        return new SAEmpleadoImp();
    }

    @Override
    public SADepartamento generaSADepartamento() {
        return new SADepartamentoImp();
    }

    @Override
    public SATurno generaSATurno() {
        return new SATurnoImp();
    }

    
    
    
}
