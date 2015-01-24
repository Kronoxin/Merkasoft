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


public class comandoMostrarDepartamento implements Command{

    @Override
    public RespuestaComando execute(Object datos) {
         ArrayList<Object> datosAlmacenados = (ArrayList<Object>)datos;
        
        
        Integer idDepartamento = (Integer)datosAlmacenados.get(0);
        Departamento departamento;
	departamento = FactoriaSA.obtenerInstancia().generaSADepartamento().mostrarDepartamento(idDepartamento);
	RespuestaComando respuesta;
        datosAlmacenados.add(departamento);
		
	if (departamento != null) //Si existe
        {
            respuesta = new RespuestaComando(EventoNegocio.EXITO_MOSTRAR_DEPARTAMENTO, datosAlmacenados);
	}
	else
        {
            respuesta = new RespuestaComando(EventoNegocio.FRACASO_MOSTRAR_DEPARTAMENTO, datosAlmacenados);
	}
	return respuesta;
        
  
    }
    
}
