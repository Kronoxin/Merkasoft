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


public class comandoCalcularNominaDepartamento implements Command{

    @Override
    public RespuestaComando execute(Object datos) 
    {
        int idDepartamento = Integer.parseInt((String) datos);
        RespuestaComando respuesta;
        ArrayList<Object> d = new ArrayList<Object>();
        Departamento dept = FactoriaSA.obtenerInstancia().generaSADepartamento().mostrarDepartamento(idDepartamento);
        if (dept != null)
        {
            d.add(dept);
            double nomina = FactoriaSA.obtenerInstancia().generaSADepartamento().nominaPorDepartamento(idDepartamento);
            d.add(nomina);
            respuesta = new RespuestaComando(EventoNegocio.EXITO_CALCULAR_NOMINA_DEPARTAMENTO, d);
        }
        else
            respuesta = new RespuestaComando(EventoNegocio.FRACASO_CALCULAR_NOMINA_DEPARTAMENTO, d);
        
        return respuesta;
    }
    
}
