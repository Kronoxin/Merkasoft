/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador.Comandos.cliente;

import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.FactoriaSA.FactoriaSA;
import presentacion.Controlador.Comandos.Command;
import presentacion.Controlador.Comandos.RespuestaComando;
import presentacion.Controlador.Eventos.EventoNegocio;

/**
 *
 * @author Pepu
 */
public class comandoBajaCliente implements Command
{
    @Override
    public RespuestaComando execute(Object datos) 
    {
        RespuestaComando respuesta = null;
        try {
            int idCliente = Integer.parseInt((String) datos);
            boolean eliminado;
            
            eliminado = FactoriaSA.obtenerInstancia().generaSACliente().eliminarCliente(idCliente);
            
            if(eliminado)
                respuesta = new RespuestaComando(EventoNegocio.EXITO_BAJA_CLIENTE, idCliente);
            else
                respuesta = new RespuestaComando(EventoNegocio.FRACASO_BAJA_CLIENTE, idCliente);
            
        } catch (Exception ex) {
        }
        return respuesta;
    }
}
