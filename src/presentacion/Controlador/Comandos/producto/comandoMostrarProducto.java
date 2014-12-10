/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador.Comandos.producto;

import Negocio.FactoriaSA.FactoriaSA;
import Negocio.producto.TProducto;
import presentacion.Controlador.Comandos.RespuestaComando;
import presentacion.Controlador.Eventos.EventoNegocio;

/**
 *
 * @author Pepu
 */
public class comandoMostrarProducto 
{
    public RespuestaComando execute(Object datos) 
    {
        int idProducto = Integer.parseInt((String) datos);
        TProducto producto;
	producto = FactoriaSA.obtenerInstancia().generaSAProducto().mostrarProducto(idProducto);
	RespuestaComando respuesta;
		
	if (producto != null) //Si existe
        {
            respuesta = new RespuestaComando(EventoNegocio.EXITO_MOSTRAR_PRODUCTO, producto);
	}
	else
        {
            respuesta = new RespuestaComando(EventoNegocio.FRACASO_MOSTRAR_PRODUCTO, producto);
	}
	return respuesta;
    }
}
