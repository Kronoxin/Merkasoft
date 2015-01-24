/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador.Comandos.departamento;

import java.util.ArrayList;
import negocio.FactoriaSA.FactoriaSA;
import negocio.departamentos.Departamento;
import presentacion.Controlador.Comandos.Command;
import presentacion.Controlador.Comandos.RespuestaComando;
import presentacion.Controlador.Eventos.EventoNegocio;


public class comandoMostrarListaDepartamentos implements Command{

    @Override
    public RespuestaComando execute(Object datos) {
        ArrayList<Object> datosLista = (ArrayList<Object>)datos;
        ArrayList<Departamento> listaDepartamentos;
	listaDepartamentos = FactoriaSA.obtenerInstancia().generaSADepartamento().mostrarListaDepartamentos();
	RespuestaComando respuesta;
        datosLista.add(listaDepartamentos);
		
	if (!listaDepartamentos.isEmpty()) //Si ha cargado la lista
        {
            respuesta = new RespuestaComando(EventoNegocio.EXITO_MOSTRAR_LISTA_DEPARTAMENTO, datosLista);
	}
	else
        {
            respuesta = new RespuestaComando(EventoNegocio.FRACASO_MOSTRAR_LISTA_DEPARTAMENTO, datosLista);
	}
	return respuesta;
        
    }
    
}
