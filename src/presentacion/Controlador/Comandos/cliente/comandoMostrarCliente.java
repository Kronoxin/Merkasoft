/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador.Comandos.cliente;

import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.FactoriaSA.FactoriaSA;
import negocio.cliente.TCliente;
import negocio.producto.TProducto;
import presentacion.Controlador.Comandos.Command;
import presentacion.Controlador.Comandos.RespuestaComando;
import presentacion.Controlador.Eventos.EventoNegocio;


public class comandoMostrarCliente implements Command
{
    public RespuestaComando execute(Object datos) 
    {
        RespuestaComando respuesta = null;
        try {
            int idCliente = Integer.parseInt((String) datos);
            TCliente cliente;
            cliente = FactoriaSA.obtenerInstancia().generaSACliente().mostrarCliente(idCliente);
            
            if (cliente != null) //Si existe
            {
                respuesta = new RespuestaComando(EventoNegocio.EXITO_MOSTRAR_CLIENTE, cliente);
            }
            else
            {
                respuesta = new RespuestaComando(EventoNegocio.FRACASO_MOSTRAR_CLIENTE, cliente);
            }
        } catch (Exception ex) {
        }
        return respuesta;
    }
    
}
