/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador.Comandos.cliente.GUI;

import presentacion.Controlador.Comandos.Command;
import presentacion.Controlador.Comandos.RespuestaComando;
import presentacion.Controlador.Eventos.EventoNegocio;


public class comandoGUIcrearCliente implements Command{

    @Override
    public RespuestaComando execute(Object datos) {
         return new RespuestaComando(EventoNegocio.GUI_ALTA_CLIENTE, datos);
    }
    
}
