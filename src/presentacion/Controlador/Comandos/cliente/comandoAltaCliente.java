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
import presentacion.Controlador.Comandos.*;
import presentacion.Controlador.Eventos.EventoNegocio;


public class comandoAltaCliente implements Command
{
    public RespuestaComando execute(Object datos) 
    {
        RespuestaComando respuesta = null;
        try {
            TCliente cliente = (TCliente)datos;
            int idCliente;
            idCliente = FactoriaSA.obtenerInstancia().generaSACliente().altaCliente(cliente);
            
            if(idCliente > 0)
                respuesta = new RespuestaComando(EventoNegocio.EXITO_ALTA_CLIENTE, idCliente);
            else
                respuesta = new RespuestaComando(EventoNegocio.FRACASO_ALTA_CLIENTE, idCliente);
            
     
        } catch (Exception ex) {
            Logger.getLogger(comandoAltaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
}
