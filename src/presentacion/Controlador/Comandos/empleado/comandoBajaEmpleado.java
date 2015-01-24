/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador.Comandos.empleado;

import negocio.FactoriaSA.FactoriaSA;
import presentacion.Controlador.Comandos.Command;
import presentacion.Controlador.Comandos.RespuestaComando;
import presentacion.Controlador.Eventos.EventoNegocio;


public class comandoBajaEmpleado implements Command{

    @Override
    public RespuestaComando execute(Object datos) {
        
       RespuestaComando respuesta = null;
        try {
            int idEmpleado = Integer.parseInt((String) datos);
            boolean eliminado;
            
            eliminado = FactoriaSA.obtenerInstancia().generaSAEmpleado().bajaEmpleado(idEmpleado);
            
            if(eliminado)
                respuesta = new RespuestaComando(EventoNegocio.EXITO_BAJA_EMPLEADO, idEmpleado);
            else
                respuesta = new RespuestaComando(EventoNegocio.FRACASO_BAJA_EMPLEADO, idEmpleado);
            
        } catch (Exception ex) {
        }
        return respuesta;
    }
    
    
}
