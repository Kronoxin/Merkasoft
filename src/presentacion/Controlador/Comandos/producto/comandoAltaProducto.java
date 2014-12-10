/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador.Comandos.producto;

import Negocio.FactoriaSA.FactoriaSA;
import Negocio.producto.TProducto;
import presentacion.Controlador.Comandos.Command;
import presentacion.Controlador.Comandos.RespuestaComando;
import presentacion.Controlador.Eventos.EventoNegocio;

/**
 *
 * @author Pepu
 */
public class comandoAltaProducto implements Command
{
    
    @Override
    public RespuestaComando execute(Object datos) 
    {
       RespuestaComando respuesta;
       int idProducto;
       idProducto = FactoriaSA.obtenerInstancia().generaSAProducto().altaProducto((TProducto) datos);
       if(idProducto > 0)
           respuesta = new RespuestaComando(EventoNegocio.EXITO_ALTA_PRODUCTO, idProducto);
       else
           respuesta = new RespuestaComando(EventoNegocio.FRACASO_ALTA_PRODUCTO, idProducto);
       
       return respuesta;
    }
    
}
