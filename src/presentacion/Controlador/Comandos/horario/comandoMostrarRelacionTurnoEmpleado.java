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


public class comandoMostrarRelacionTurnoEmpleado implements Command{

    @Override
    public RespuestaComando execute(Object datos) {
        RespuestaComando ret = null;
        
        ArrayList<HorarioTrabajo> resultado = FactoriaSA.obtenerInstancia().generaSATurno().mostrarRelacionTurnoEmpleado();        
        ret = new RespuestaComando(EventoNegocio.EXITO_MOSTRAR_RELACION_TURNO_EMPLEADO, resultado);
        //No identifico cuando puede haber fracaso. si no hay ningún horario, devolverá una lista vacía
        
        return ret;
    }
    
}
