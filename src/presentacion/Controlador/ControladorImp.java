/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador;

import presentacion.Controlador.dispatcher.Dispatcher;
import presentacion.FactoriaComandos.factoriaComandos;
import presentacion.Controlador.Comandos.Command;
import presentacion.Controlador.Comandos.RespuestaComando;


public class ControladorImp extends Controlador
{
    public void accion(int evento, Object datos) {

		Command comando;
		RespuestaComando aux;

		comando = factoriaComandos.getInstance().getCommand(evento);
		aux = comando.execute(datos);

		if (aux != null) 
                {
			Dispatcher.getInstance().dispatch(aux);
		}

	}
}
