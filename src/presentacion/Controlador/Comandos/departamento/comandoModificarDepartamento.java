/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador.Comandos.departamento;

import negocio.FactoriaSA.FactoriaSA;
import presentacion.Controlador.Comandos.Command;
import presentacion.Controlador.Comandos.RespuestaComando;
import presentacion.Controlador.Eventos.EventoNegocio;

/**
 *
 * @author Ruben
 */
public class comandoModificarDepartamento implements Command{

    @Override
    public RespuestaComando execute(Object datos) {
      /*  boolean correcto = FactoriaSA.obtenerInstancia().generaSADepartamento().modificarDepartamento((Departamento)datos);
	RespuestaComando respuesta;
		
	if (correcto)
        {
            respuesta = new RespuestaComando(EventoNegocio.EXITO_MODIFICAR_DEPARTAMENTO, (Departamento)datos);
	}
	else
        {
            respuesta = new RespuestaComando(EventoNegocio.FRACASO_MODIFICAR_DEPARTAMENTO, (Departamento)datos);
	}
	return respuesta;*/
        
        //para poder ejecutar la aplicacion mientras no está el SA completado 
      throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
