/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador.Comandos.turno;

import java.util.ArrayList;
import negocio.FactoriaSA.FactoriaSA;

import presentacion.Controlador.Comandos.Command;
import presentacion.Controlador.Comandos.RespuestaComando;
import presentacion.Controlador.Eventos.EventoNegocio;

/**
 *
 * @author Ruben
 */
public class comandoMostrarListaTurnos implements Command{

    @Override
    public RespuestaComando execute(Object datos) {
    /*    ArrayList<Object> datosLista = (ArrayList<Object>)datos;
        ArrayList<Turno> listaTurnos;
	listaTurnos = FactoriaSA.obtenerInstancia().generaSATurno().mostrarListaTurno();
	RespuestaComando respuesta;
        datosLista.add(listaTurnos);
		
	if (!listaTurnos.isEmpty()) //Si ha cargado la lista
        {
            respuesta = new RespuestaComando(EventoNegocio.EXITO_MOSTRAR_LISTA_TURNO, datosLista);
	}
	else
        {
            respuesta = new RespuestaComando(EventoNegocio.FRACASO_MOSTRAR_LISTA_TURNO, datosLista);
	}
	return respuesta;*/
        
        //puesto aqui hasta que no esté completo el SA, para poder ejecutar la aplicacion
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
