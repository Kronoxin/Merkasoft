/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador.Comandos.turno;

import negocio.FactoriaSA.FactoriaSA;
import presentacion.Controlador.Comandos.Command;
import presentacion.Controlador.Comandos.RespuestaComando;
import presentacion.Controlador.Eventos.EventoNegocio;


public class comandoBajaTurno implements Command{

    @Override
    public RespuestaComando execute(Object datos) {
        int idTurno = Integer.parseInt((String) datos);
       RespuestaComando respuesta;
       boolean eliminado;
       
       eliminado = FactoriaSA.obtenerInstancia().generaSATurno().bajaTurno(idTurno);
       
       if(eliminado)
           respuesta = new RespuestaComando(EventoNegocio.EXITO_BAJA_TURNO, idTurno);
       else
           respuesta = new RespuestaComando(EventoNegocio.FRACASO_BAJA_TURNO, idTurno);
       
       return respuesta;
       
       
    }
    
}
