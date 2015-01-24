/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador.Comandos.turno;

import java.util.ArrayList;
import negocio.FactoriaSA.FactoriaSA;
import negocio.turnos.Turno;
import presentacion.Controlador.Comandos.Command;
import presentacion.Controlador.Comandos.RespuestaComando;
import presentacion.Controlador.Eventos.EventoNegocio;


public class comandoMostrarTurno implements Command{

    @Override
    public RespuestaComando execute(Object datos) {
         ArrayList<Object> datosAlmacenados = (ArrayList<Object>)datos;
        
        
        Integer idTurno = (Integer)datosAlmacenados.get(0);
        Turno turno;
	turno = FactoriaSA.obtenerInstancia().generaSATurno().mostrarTurno(idTurno);
	RespuestaComando respuesta;
        datosAlmacenados.add(turno);
		
	if (turno != null) //Si existe
        {
            respuesta = new RespuestaComando(EventoNegocio.EXITO_MOSTRAR_TURNO, datosAlmacenados);
	}
	else
        {
            respuesta = new RespuestaComando(EventoNegocio.FRACASO_MOSTRAR_TURNO, datosAlmacenados);
	}
	return respuesta;
        
      
    }
    
}
