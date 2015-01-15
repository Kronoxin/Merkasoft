/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador.Comandos.empleado;

import java.util.ArrayList;
import negocio.FactoriaSA.FactoriaSA;
import negocio.empleados.Empleado;
import negocio.empleados.TEmpleado;
import presentacion.Controlador.Comandos.Command;
import presentacion.Controlador.Comandos.RespuestaComando;
import presentacion.Controlador.Eventos.EventoNegocio;

/**
 *
 * @author Ruben
 */
public class comandoMostrarListaEmpleados implements Command{

    @Override
    public RespuestaComando execute(Object datos) {
        ArrayList<Object> datosLista = (ArrayList<Object>)datos;
        ArrayList<Empleado> listaEmpleados;
	listaEmpleados = FactoriaSA.obtenerInstancia().generaSAEmpleado().mostrarListaEmpleados();
	RespuestaComando respuesta;
        datosLista.add(listaEmpleados);
		
	if (!listaEmpleados.isEmpty()) //Si ha cargado la lista
        {
            respuesta = new RespuestaComando(EventoNegocio.EXITO_MOSTRAR_LISTA_EMPLEADO, datosLista);
	}
	else
        {
            respuesta = new RespuestaComando(EventoNegocio.FRACASO_MOSTRAR_LISTA_EMPLEADO, datosLista);
	}
	return respuesta;
    }
    
}
