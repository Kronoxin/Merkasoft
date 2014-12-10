/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador.Comandos.producto;

import negocio.FactoriaSA.FactoriaSA;
import negocio.producto.TProducto;
import presentacion.Controlador.Comandos.RespuestaComando;
import presentacion.Controlador.Eventos.EventoNegocio;

/**
 *
 * @author Pepu
 */
public class comandoBajaProducto 
{
    public RespuestaComando execute(Object datos) 
    {
       int idProducto = Integer.parseInt((String) datos);
       RespuestaComando respuesta;
       boolean eliminado;
       
       eliminado = FactoriaSA.obtenerInstancia().generaSAProducto().bajaProducto(idProducto);
       
       if(eliminado)
           respuesta = new RespuestaComando(EventoNegocio.EXITO_BAJA_PRODUCTO, idProducto);
       else
           respuesta = new RespuestaComando(EventoNegocio.FRACASO_BAJA_PRODUCTO, idProducto);
       
       return respuesta;
    }
    
}
