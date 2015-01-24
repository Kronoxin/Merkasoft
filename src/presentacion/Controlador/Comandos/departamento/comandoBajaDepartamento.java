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


public class comandoBajaDepartamento implements Command{

    @Override
    public RespuestaComando execute(Object datos) {
        int idDepartamento = Integer.parseInt((String) datos);
       RespuestaComando respuesta;
       boolean eliminado;
       
       eliminado = FactoriaSA.obtenerInstancia().generaSADepartamento().bajaDepartamento(idDepartamento);
       
       if(eliminado)
           respuesta = new RespuestaComando(EventoNegocio.EXITO_BAJA_DEPARTAMENTO, idDepartamento);
       else
           respuesta = new RespuestaComando(EventoNegocio.FRACASO_BAJA_DEPARTAMENTO, idDepartamento);
       
       return respuesta;
        
    }
    
}
