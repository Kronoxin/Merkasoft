/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador.Comandos.empleado;

import java.util.ArrayList;
import negocio.FactoriaSA.FactoriaSA;
import negocio.empleados.Empleado;
import negocio.producto.TProducto;
import presentacion.Controlador.Comandos.Command;
import presentacion.Controlador.Comandos.RespuestaComando;
import presentacion.Controlador.Eventos.EventoNegocio;


public class comandoModificarEmpleado implements Command{

    @Override
    public RespuestaComando execute(Object datos) {
       Empleado datosAlmacenados = (Empleado)datos;
        
        
        boolean correcto;
	correcto = FactoriaSA.obtenerInstancia().generaSAEmpleado().modificarEmpleado(datosAlmacenados);
	RespuestaComando respuesta;
        
		
	if (correcto) //Si existe
        {
            respuesta = new RespuestaComando(EventoNegocio.EXITO_MODIFICAR_EMPLEADO, null);
	}
	else
        {
            respuesta = new RespuestaComando(EventoNegocio.FRACASO_MODIFICAR_EMPLEADO, null);
	}
	return respuesta;
    }
    
    
}
