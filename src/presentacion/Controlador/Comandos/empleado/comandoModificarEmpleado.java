/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador.Comandos.empleado;

import negocio.FactoriaSA.FactoriaSA;
import negocio.empleados.Empleado;
import negocio.producto.TProducto;
import presentacion.Controlador.Comandos.Command;
import presentacion.Controlador.Comandos.RespuestaComando;
import presentacion.Controlador.Eventos.EventoNegocio;

/**
 *
 * @author Ruben
 */
public class comandoModificarEmpleado implements Command{

    @Override
    public RespuestaComando execute(Object datos) {
       //int idEmpleado = Integer.parseInt((String) datos);
	boolean correcto = FactoriaSA.obtenerInstancia().generaSAEmpleado().modificarEmpleado((Empleado)datos);
	RespuestaComando respuesta;
		
	if (correcto)
        {
            respuesta = new RespuestaComando(EventoNegocio.EXITO_MODIFICAR_EMPLEADO, (Empleado)datos);
	}
	else
        {
            respuesta = new RespuestaComando(EventoNegocio.FRACASO_MODIFICAR_EMPLEADO, (Empleado)datos);
	}
	return respuesta;
    }
    
    
}
