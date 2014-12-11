/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador.Comandos.venta;

import negocio.FactoriaSA.FactoriaSA;
import negocio.venta.TVenta;
import java.util.ArrayList;
import presentacion.Controlador.Comandos.Command;
import presentacion.Controlador.Comandos.RespuestaComando;
import presentacion.Controlador.Eventos.EventoNegocio;

/**
 *
 * @author Pepu
 */
public class comandoMostrarListaVentas implements Command
{
    public RespuestaComando execute(Object datos) 
    {
       ArrayList<TVenta> listaVentas;
       RespuestaComando respuesta;
       //int idVenta = Integer.parseInt((String) datos);
       listaVentas = FactoriaSA.obtenerInstancia().generaSAVenta().mostrarListaVenta();
       
       if(!listaVentas.isEmpty()) //Si hay alguna venta
           respuesta = new RespuestaComando(EventoNegocio.EXITO_MOSTRAR_LISTA_VENTA, listaVentas);
       else
           respuesta = new RespuestaComando(EventoNegocio.FRACASO_MOSTRAR_LISTA_VENTA, listaVentas);
       
       return respuesta;
    }
    
}
