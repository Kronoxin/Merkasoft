/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador.Comandos.producto;

import negocio.FactoriaSA.FactoriaSA;
import negocio.producto.TProducto;
import presentacion.Controlador.Comandos.Command;
import presentacion.Controlador.Comandos.RespuestaComando;
import presentacion.Controlador.Eventos.EventoNegocio;

/**
 *
 * @author Pepu
 */
public class comandoModificarProducto implements Command
{
    public RespuestaComando execute(Object datos) 
    {
        //int idProducto = Integer.parseInt((String) datos);
        //Devuelvo el producto, e intento modificarlo
	//TProducto prod = FactoriaSA.obtenerInstancia().generaSAProducto().mostrarProducto(idProducto);
        
        boolean correcto = FactoriaSA.obtenerInstancia().generaSAProducto().modificarProducto((TProducto)datos);
	RespuestaComando respuesta;
		
	if (correcto)
        {
            respuesta = new RespuestaComando(EventoNegocio.EXITO_MODIFICAR_PRODUCTO, (TProducto)datos);
	}
	else
        {
            respuesta = new RespuestaComando(EventoNegocio.FRACASO_MODIFICAR_PRODUCTO, (TProducto)datos);
	}
	return respuesta;
    }
}
