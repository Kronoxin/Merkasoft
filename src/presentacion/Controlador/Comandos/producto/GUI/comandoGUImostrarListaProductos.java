/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentacion.Controlador.Comandos.producto.GUI;

import presentacion.Controlador.Comandos.Command;
import presentacion.Controlador.Comandos.RespuestaComando;
import presentacion.Controlador.Eventos.EventoNegocio;


public class comandoGUImostrarListaProductos implements Command
{
    public RespuestaComando execute(Object datos) {
        
       return new RespuestaComando(EventoNegocio.GUI_MOSTRAR_LISTA_PRODUCTOS, datos);
    }
}
