/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador.Comandos.cliente;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.FactoriaSA.FactoriaSA;
import negocio.cliente.TCliente;
import negocio.producto.TProducto;
import presentacion.Controlador.Comandos.Command;
import presentacion.Controlador.Comandos.RespuestaComando;
import presentacion.Controlador.Eventos.EventoNegocio;

/**
 *
 * @author Pepu
 */
public class comandoMostrarListaClientes implements Command{

    @Override
    public RespuestaComando execute(Object datos) 
    {
        RespuestaComando respuesta = null;
        try {
            ArrayList<Object> datosLista = (ArrayList<Object>)datos;
            ArrayList<TCliente> listaClientes;
            listaClientes = FactoriaSA.obtenerInstancia().generaSACliente().mostrarListaCliente();
            datosLista.add(listaClientes);
             
            if (!listaClientes.isEmpty()) //Si ha cargado la lista
            {
                respuesta = new RespuestaComando(EventoNegocio.EXITO_MOSTRAR_LISTA_CLIENTE, datosLista);
            }
            else
            {
                respuesta = new RespuestaComando(EventoNegocio.FRACASO_MOSTRAR_LISTA_CLIENTE, datosLista);
            }
        } catch (Exception ex) {
        }
        return respuesta;
    }
    
}
