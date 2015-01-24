/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador.Comandos.producto;

import java.util.ArrayList;
import negocio.FactoriaSA.FactoriaSA;
import negocio.producto.TProducto;
import presentacion.Controlador.Comandos.Command;
import presentacion.Controlador.Comandos.RespuestaComando;
import presentacion.Controlador.Eventos.EventoNegocio;


public class comandoMostrarProducto implements Command
{
    public RespuestaComando execute(Object datos) 
    {
        ArrayList<Object> datosAlmacenados = (ArrayList<Object>)datos;
        
        
        Integer idProducto = (Integer)datosAlmacenados.get(0);
        TProducto producto;
	producto = FactoriaSA.obtenerInstancia().generaSAProducto().mostrarProducto(idProducto);
	RespuestaComando respuesta;
        datosAlmacenados.add(producto);
		
	if (producto != null) //Si existe
        {
            respuesta = new RespuestaComando(EventoNegocio.EXITO_MOSTRAR_PRODUCTO, datosAlmacenados);
	}
	else
        {
            respuesta = new RespuestaComando(EventoNegocio.FRACASO_MOSTRAR_PRODUCTO, datosAlmacenados);
	}
	return respuesta;
    }
}
