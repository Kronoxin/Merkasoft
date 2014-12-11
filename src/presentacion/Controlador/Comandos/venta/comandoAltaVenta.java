/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador.Comandos.venta;

import negocio.FactoriaSA.FactoriaSA;
import negocio.venta.TVenta;
import presentacion.Controlador.Comandos.Command;
import presentacion.Controlador.Comandos.RespuestaComando;
import presentacion.Controlador.Eventos.EventoNegocio;

/**
 *
 * @author Pepu
 */
public class comandoAltaVenta implements Command
{
    public RespuestaComando execute(Object datos) 
    {
       TVenta datosVenta = (TVenta)datos;
       RespuestaComando respuesta;
       int idVenta;
       idVenta = FactoriaSA.obtenerInstancia().generaSAVenta().altaventa(datosVenta, datosVenta.getCliente().getId());
       if(idVenta > 0)
           respuesta = new RespuestaComando(EventoNegocio.EXITO_ALTA_VENTA, datosVenta);
       else
           respuesta = new RespuestaComando(EventoNegocio.FRACASO_ALTA_VENTA, datosVenta);
       
       return respuesta;
    }
}
