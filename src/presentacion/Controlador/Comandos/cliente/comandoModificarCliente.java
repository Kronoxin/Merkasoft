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


public class comandoModificarCliente implements Command{

    public RespuestaComando execute(Object datos) 
    {
        RespuestaComando respuesta = null;
        try {
            //int idProducto = Integer.parseInt((String) datos);
            TCliente cliente = (TCliente)datos;
            boolean correcto = FactoriaSA.obtenerInstancia().generaSACliente().modificarCliente(cliente);
            
            if (correcto)
            {
                respuesta = new RespuestaComando(EventoNegocio.EXITO_MODIFICAR_CLIENTE, cliente);
            }
            else
            {
                respuesta = new RespuestaComando(EventoNegocio.FRACASO_MODIFICAR_CLIENTE, cliente);
            }
        } catch (Exception ex) {
        }
        return respuesta;
    }
    
}
