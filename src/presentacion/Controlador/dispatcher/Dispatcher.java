/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador.dispatcher;

import presentacion.Controlador.Comandos.RespuestaComando;
import presentacion.Controlador.dispatcher.Imp.DispatcherImp;


public abstract class Dispatcher 
{
    public static Dispatcher _instance = null;
    
    public static Dispatcher getInstance()
    {
        if (_instance == null)
            _instance = new DispatcherImp();
        
        return _instance;
    }
    
    public abstract void dispatch(RespuestaComando comando);
}
