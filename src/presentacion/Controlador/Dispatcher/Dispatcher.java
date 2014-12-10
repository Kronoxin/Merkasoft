/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Controlador.Dispatcher;

import Presentacion.Controlador.Comandos.*;
import presentacion.Controlador.Dispatcher.Imp.DispatcherImp;

/**
 *
 * @author Pepu
 */
public abstract class Dispatcher 
{
    private static Dispatcher _dispatcher=null;

    public static Dispatcher getInstance() 
    {
	if(_dispatcher == null)
        {
            _dispatcher = new DispatcherImp();
	}
	return _dispatcher;
    }
    
    public abstract void dispatch(RespuestaComando comando);
}
