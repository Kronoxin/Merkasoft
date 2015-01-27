/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador.Comandos.horario;

import java.util.ArrayList;
import negocio.FactoriaSA.FactoriaSA;
import negocio.turnos.HorarioTrabajo;
import presentacion.Controlador.Comandos.Command;
import presentacion.Controlador.Comandos.RespuestaComando;
import presentacion.Controlador.Eventos.EventoNegocio;


public class comandoMostrarTurnosEmpleado implements Command{

    @Override
    public RespuestaComando execute(Object datos) {
        RespuestaComando ret = null;
        int entrada = (int) datos;
        ArrayList<HorarioTrabajo> resultado = FactoriaSA.obtenerInstancia().generaSATurno().mostrarTurnosEmpleado(entrada);
        if (resultado == null)
            ret = new RespuestaComando(EventoNegocio.FRACASO_MOSTRAR_TURNOS_EMPLEADO, resultado);
        else
            ret = new RespuestaComando(EventoNegocio.EXITO_MOSTRAR_TURNOS_EMPLEADO, resultado);
        
        return ret;
    }
    
}
