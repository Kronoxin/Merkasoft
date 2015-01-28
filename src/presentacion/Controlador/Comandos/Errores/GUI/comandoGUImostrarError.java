/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador.Comandos.Errores.GUI;

import presentacion.Controlador.Comandos.Command;
import presentacion.Controlador.Comandos.RespuestaComando;
import presentacion.Controlador.Eventos.EventoNegocio;

public class comandoGUImostrarError implements Command{

    @Override
    public RespuestaComando execute(Object datos) 
    {
        String prueba=datos.toString();
       return new RespuestaComando(EventoNegocio.MOSTRAR_INFORMACION_ERROR, prueba);
    }
    
}
