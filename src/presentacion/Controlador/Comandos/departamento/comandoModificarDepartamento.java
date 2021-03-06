/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador.Comandos.departamento;

import negocio.FactoriaSA.FactoriaSA;
import negocio.departamentos.Departamento;
import presentacion.Controlador.Comandos.Command;
import presentacion.Controlador.Comandos.RespuestaComando;
import presentacion.Controlador.Eventos.EventoNegocio;


public class comandoModificarDepartamento implements Command{

    @Override
    public RespuestaComando execute(Object datos) {
        boolean correcto = FactoriaSA.obtenerInstancia().generaSADepartamento().modificarDepartamento((Departamento)datos);
	RespuestaComando respuesta;
		
	if (correcto)
        {
            respuesta = new RespuestaComando(EventoNegocio.EXITO_MODIFICAR_DEPARTAMENTO, (Departamento)datos);
	}
	else
        {
            respuesta = new RespuestaComando(EventoNegocio.FRACASO_MODIFICAR_DEPARTAMENTO, (Departamento)datos);
	}
	return respuesta;
        
    }
    
}
