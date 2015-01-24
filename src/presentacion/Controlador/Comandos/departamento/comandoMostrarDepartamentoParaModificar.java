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


public class comandoMostrarDepartamentoParaModificar implements Command{

    @Override
    public RespuestaComando execute(Object datos) {
          ArrayList<Object> datosAlmacenados = (ArrayList<Object>)datos;
        
        
        Integer idEmpleado = (Integer)datosAlmacenados.get(0);
        Departamento departamento;
	departamento = FactoriaSA.obtenerInstancia().generaSADepartamento().mostrarDepartamento(idEmpleado);
	RespuestaComando respuesta;
        datosAlmacenados.add(departamento);
		
	if (departamento != null) //Si existe
        {
           // System.out.println("hola mod"+departamento.getNombre());
            respuesta = new RespuestaComando(EventoNegocio.EXITO_MOSTRAR_DEPARTAMENTO_PARA_MODIFICAR, datosAlmacenados);
	}
	else
        {
            respuesta = new RespuestaComando(EventoNegocio.FRACASO_MOSTRAR_DEPARTAMENTO_PARA_MODIFICAR, datosAlmacenados);
	}
	return respuesta;
    }
    
}
