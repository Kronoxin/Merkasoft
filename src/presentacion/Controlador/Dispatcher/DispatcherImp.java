/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador.Dispatcher;

import presentacion.Controlador.Comandos.Command;
import presentacion.Controlador.Comandos.RespuestaComando;
import presentacion.Controlador.Eventos.EventoNegocio;


/**
 *
 * @author Pepu
 */
class DispatcherImp extends Dispatcher 
{
    public Command dispatch(RespuestaComando comando)
    {
        switch(comando.getEvento())
        {
            case EventoNegocio.GUI_ALTA_CLIENTE:
                (FJrame)comando.getDatos()
                break;
                
        }
        return null;
    }
    
}
