/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador.Comandos.turno;

import negocio.FactoriaSA.FactoriaSA;
import negocio.turnos.Turno;
import presentacion.Controlador.Comandos.Command;
import presentacion.Controlador.Comandos.RespuestaComando;
import presentacion.Controlador.Eventos.EventoNegocio;


public class comandoModificarTurno implements Command{

    @Override
    public RespuestaComando execute(Object datos) {
        boolean correcto = FactoriaSA.obtenerInstancia().generaSATurno().modificarTurno((Turno)datos);
	RespuestaComando respuesta;
		
	if (correcto)
        {
            respuesta = new RespuestaComando(EventoNegocio.EXITO_MODIFICAR_TURNO, (Turno)datos);
	}
	else
        {
            respuesta = new RespuestaComando(EventoNegocio.FRACASO_MODIFICAR_TURNO, (Turno)datos);
	}
	return respuesta;
        
        //puesto aqui hasta que no esté completo el SA, para poder ejecutar la aplicacion
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
