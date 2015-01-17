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

/**
 *
 * @author Ruben
 */
public class comandoAltaTurno implements Command{

    @Override
    public RespuestaComando execute(Object datos) {
        
       RespuestaComando respuesta;
       int idTurno;
       idTurno = FactoriaSA.obtenerInstancia().generaSATurno().altaTurno((Turno) datos);
       if(idTurno > 0)
           respuesta = new RespuestaComando(EventoNegocio.EXITO_ALTA_TURNO, idTurno);
       else
           respuesta = new RespuestaComando(EventoNegocio.FRACASO_ALTA_TURNO, idTurno);
       
       return respuesta;
       
       
    }
    
}
