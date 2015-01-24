/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador.Comandos.producto;

import negocio.FactoriaSA.FactoriaSA;
import negocio.producto.TProducto;
import java.util.ArrayList;
import presentacion.Controlador.Comandos.Command;
import presentacion.Controlador.Comandos.RespuestaComando;
import presentacion.Controlador.Eventos.EventoNegocio;


public class comandoMostrarListaProductos implements Command
{
    public RespuestaComando execute(Object datos) 
    {
        ArrayList<Object> datosLista = (ArrayList<Object>)datos;
        ArrayList<TProducto> listaProductos;
	listaProductos = FactoriaSA.obtenerInstancia().generaSAProducto().mostrarListaProducto();
	RespuestaComando respuesta;
        datosLista.add(listaProductos);
		
	if (!listaProductos.isEmpty()) //Si ha cargado la lista
        {
            respuesta = new RespuestaComando(EventoNegocio.EXITO_MOSTRAR_LISTA_PRODUCTO, datosLista);
	}
	else
        {
            respuesta = new RespuestaComando(EventoNegocio.FRACASO_MOSTRAR_LISTA_PRODUCTO, datosLista);
	}
	return respuesta;
    }
    
}
