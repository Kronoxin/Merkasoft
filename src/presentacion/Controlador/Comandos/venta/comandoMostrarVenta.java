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


public class comandoMostrarVenta implements Command
{
    public RespuestaComando execute(Object datos) 
    {
       TVenta datosVenta;
       RespuestaComando respuesta;
       int idVenta = Integer.parseInt((String) datos);
       datosVenta = FactoriaSA.obtenerInstancia().generaSAVenta().mostrarVenta(idVenta);
       
       if(datosVenta != null) //Si existe la venta
           respuesta = new RespuestaComando(EventoNegocio.EXITO_MOSTRAR_VENTA, datosVenta);
       else
           respuesta = new RespuestaComando(EventoNegocio.FRACASO_MOSTRAR_VENTA, datosVenta);
       
       return respuesta;
    }
}
