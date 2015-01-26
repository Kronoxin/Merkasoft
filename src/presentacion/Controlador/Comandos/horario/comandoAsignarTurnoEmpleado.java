/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador.Comandos.horario;

import java.util.ArrayList;
import negocio.FactoriaSA.FactoriaSA;
import presentacion.Controlador.Comandos.Command;
import presentacion.Controlador.Comandos.RespuestaComando;
import presentacion.Controlador.Eventos.EventoNegocio;


public class comandoAsignarTurnoEmpleado implements Command{

    @Override
    public RespuestaComando execute(Object datos) 
    {
        RespuestaComando respuesta;
        ArrayList<Object> entrada = (ArrayList<Object>)datos;
        int idEmpleado = Integer.parseInt((String)entrada.get(0));
        int idTurno = Integer.parseInt((String)entrada.get(1));
        if (FactoriaSA.obtenerInstancia().generaSATurno().asignarTurno(idEmpleado, idTurno))
            respuesta = new RespuestaComando(EventoNegocio.EXITO_ASIGNAR_TURNO_EMPLEADO, datos);
        else
            respuesta = new RespuestaComando(EventoNegocio.FRACASO_ASIGNAR_TURNO_EMPLEADO, datos);
        return respuesta;
    }
    
}
