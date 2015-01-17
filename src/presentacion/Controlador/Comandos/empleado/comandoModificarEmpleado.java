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

/**
 *
 * @author Ruben
 */
public class comandoModificarEmpleado implements Command{

    @Override
    public RespuestaComando execute(Object datos) {
       ArrayList<Object> datosAlmacenados = (ArrayList<Object>)datos;
        
        
        Integer idEmpleado = (Integer)datosAlmacenados.get(0);
        Empleado empleado;
        Empleado empleadoAux;
	empleado = FactoriaSA.obtenerInstancia().generaSAEmpleado().mostrarEmpleado(idEmpleado);
	RespuestaComando respuesta;
        datosAlmacenados.add(empleado);
		
	if (empleado != null) //Si existe
        {
            respuesta = new RespuestaComando(EventoNegocio.EXITO_MODIFICAR_EMPLEADO, datosAlmacenados);
	}
	else
        {
            respuesta = new RespuestaComando(EventoNegocio.FRACASO_MODIFICAR_PRODUCTO, datosAlmacenados);
	}
	return respuesta;
    }
    
    
}
