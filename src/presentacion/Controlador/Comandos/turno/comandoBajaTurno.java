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

/**
 *
 * @author Ruben
 */
public class comandoBajaTurno implements Command{

    @Override
    public RespuestaComando execute(Object datos) {
    /*    int idTurno = Integer.parseInt((String) datos);
       RespuestaComando respuesta;
       boolean eliminado;
       
       eliminado = FactoriaSA.obtenerInstancia().generaSATurno().bajaTurno(idTurno);
       
       if(eliminado)
           respuesta = new RespuestaComando(EventoNegocio.EXITO_BAJA_TURNO, idTurno);
       else
           respuesta = new RespuestaComando(EventoNegocio.FRACASO_BAJA_TURNO, idTurno);
       
       return respuesta;*/
        
       //puesto aqui hasta que no esté completo el SA, para poder ejecutar la aplicacion
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
