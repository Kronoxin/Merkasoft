/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.FactoriaComandos;

import presentacion.Controlador.Comandos.Command;
import presentacion.FactoriaComandos.Imp.*;

/**
 *
 * @author Pepu
 */
public abstract class factoriaComandos 
{
    private static factoriaComandos _instance = null;

    public abstract Command getCommand(int evento);

    public static factoriaComandos getInstance() 
    {
	if (_instance == null) 
        {
            _instance = new factoriaComandosImp();
	}

	return _instance;
    }
}
