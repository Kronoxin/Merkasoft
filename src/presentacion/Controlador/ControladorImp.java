/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador;

/**
 *
 * @author Pepu
 */
public class ControladorImp extends Controlador
{
    public void accion(int evento, Object datos) {

		Command comando;
		RespuestaComando aux;

		comando = FactoriaComandos.obtenerInstancia().getCommand(evento);
		aux = comando.execute(datos);

		if (aux != null) {
			comando = Dispatcher.getInstance().dispatch(aux);
			comando.execute(aux.getDatos());
		}

	}
}
