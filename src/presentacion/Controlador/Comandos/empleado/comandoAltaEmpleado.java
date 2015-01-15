/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador.Comandos.empleado;

import negocio.FactoriaSA.FactoriaSA;
import negocio.empleados.Empleado;
import presentacion.Controlador.Comandos.Command;
import presentacion.Controlador.Comandos.RespuestaComando;
import presentacion.Controlador.Eventos.EventoNegocio;

/**
 *
 * @author Ruben
 */
public class comandoAltaEmpleado implements Command{

    @Override
    public RespuestaComando execute(Object datos) {
       RespuestaComando respuesta;
       int idEmpleado;
       idEmpleado = FactoriaSA.obtenerInstancia().generaSAEmpleado().altaEmpleado((Empleado) datos);
       if(idEmpleado > 0)
           respuesta = new RespuestaComando(EventoNegocio.EXITO_ALTA_EMPLEADO, idEmpleado);
       else
           respuesta = new RespuestaComando(EventoNegocio.FRACASO_ALTA_EMPLEADO, idEmpleado);
       
       return respuesta;
       
    }
    
}
