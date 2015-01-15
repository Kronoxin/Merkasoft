/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador.Comandos.departamento;

import negocio.FactoriaSA.FactoriaSA;
import negocio.producto.TProducto;
import presentacion.Controlador.Comandos.Command;
import presentacion.Controlador.Comandos.RespuestaComando;
import presentacion.Controlador.Eventos.EventoNegocio;

/**
 *
 * @author Ruben
 */
public class comandoAltaDepartamento implements Command{

    @Override
    public RespuestaComando execute(Object datos) {
    /*   RespuestaComando respuesta;
       int idDepartamento;
       idDepartamento = FactoriaSA.obtenerInstancia().generaSADepartamento().altaDepartamento((Departamento) datos);
       if(idDepartamento > 0)
           respuesta = new RespuestaComando(EventoNegocio.EXITO_ALTA_DEPARTAMENTO, idDepartamento);
       else
           respuesta = new RespuestaComando(EventoNegocio.FRACASO_ALTA_DEPARTAMENTO, idDepartamento);
       
       return respuesta;*/
        
      //para poder ejecutar la aplicacion mientras no está el SA completado 
      throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
