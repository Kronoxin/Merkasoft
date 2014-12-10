/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.FactoriaComandos;

import Presentacion.FactoriaComandos.factoriaComandos;
import presentacion.Controlador.Comandos.Command;
import presentacion.Controlador.Eventos.EventoNegocio;

/**
 *
 * @author Pepu
 */
class factoriaComandosImp extends factoriaComandos 
{
    @Override
    public Command getCommand(int evento) 
    {
        Command comando = null;

	switch(evento)
        {
            case EventoNegocio.ALTA_CLIENTE:
            {
		comando = new comandoAltaCliente();
                break;
            }
            case EventoNegocio.BAJA_CLIENTE:
            {
		comando = new comandoBajaCliente();
                break;
            }
            case EventoNegocio.MOSTRAR_CLIENTE:
            {
		comando = new comandoMostrarCliente();
                break;
            }
            case EventoNegocio.MOSTRAR_LISTA_CLIENTES:
            {
		comando = new comandoMostrarListaClientes();
                break;
            }
            case EventoNegocio.MODIFICAR_CLIENTE:
            {
		comando = new comandoModificarCliente();
                break;
            }
            case EventoNegocio.GUI_ALTA_CLIENTE:
            {
		comando = new comandoGUIcrearCliente();
                break;
            }
            case EventoNegocio.GUI_BAJA_CLIENTE:
            {
		comando = new comandoGUIeliminarCliente();
                break;
            }
            case EventoNegocio.GUI_MOSTRAR_CLIENTE:
            {
		comando = new comandoGUImostrarCliente();
                break;
            }
            case EventoNegocio.GUI_MOSTRAR_LISTA_CLIENTES:
            {
		comando = new comandoGUImostrarListaClientes();
                break;
            }
            case EventoNegocio.GUI_MODIFICAR_CLIENTE:
            {
		comando = new comandoGUImodificarCliente();
                break;
            }
            
        }
        return comando;
    }
    
}
