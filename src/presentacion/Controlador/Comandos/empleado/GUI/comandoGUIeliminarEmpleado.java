/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador.Comandos.empleado.GUI;

import presentacion.Controlador.Comandos.Command;
import presentacion.Controlador.Comandos.RespuestaComando;
import presentacion.Controlador.Eventos.EventoNegocio;


public class comandoGUIeliminarEmpleado implements Command{

    @Override
    public RespuestaComando execute(Object datos) {
        return new RespuestaComando(EventoNegocio.GUI_BAJA_EMPLEADO, datos);
    }
    
}
