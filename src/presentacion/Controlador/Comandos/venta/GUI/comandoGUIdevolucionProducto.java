/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentacion.Controlador.Comandos.venta.GUI;

import presentacion.Controlador.Comandos.RespuestaComando;
import presentacion.Controlador.Eventos.EventoNegocio;

/**
 *
 * @author usuario_local
 */
public class comandoGUIdevolucionProducto 
{
    public RespuestaComando execute(Object datos) {
        
       return new RespuestaComando(EventoNegocio.GUI_DEVOLUCION_PRODUCTO, null);
    }
}
