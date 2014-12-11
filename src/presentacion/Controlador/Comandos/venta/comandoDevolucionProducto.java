/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentacion.Controlador.Comandos.venta;

import negocio.FactoriaSA.FactoriaSA;
import negocio.venta.TCompraArticulo;
import negocio.venta.TVenta;
import java.util.ArrayList;
import presentacion.Controlador.Comandos.Command;
import presentacion.Controlador.Comandos.RespuestaComando;
import presentacion.Controlador.Eventos.EventoNegocio;

/**
 *
 * @author usuario_local
 */
public class comandoDevolucionProducto implements Command
{
    public RespuestaComando execute(Object datos) 
    {
        /*
       TVenta venta = (TVenta)datos;
       boolean correcto = false;
       ArrayList<TCompraArticulo> listaProd;
       int idVenta = Integer.parseInt((String) datos);
       RespuestaComando respuesta;
       
       correcto = FactoriaSA.obtenerInstancia().generaSAVenta().devolucionProducto(listaProd.get(0), datosVenta.getId());
       
       if(correcto)
           respuesta = new RespuestaComando(EventoNegocio.EXITO_DEVOLUCION_PRODUCTO, datosVenta);
       else
           respuesta = new RespuestaComando(EventoNegocio.FRACASO_DEVOLUCION_PRODUCTO, datosVenta);
       
       return respuesta;
                */
        return null;
    }
}
