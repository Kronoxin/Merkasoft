/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador;


public abstract class Controlador 
{
    private static Controlador _controlador;

    public static Controlador getInstance() 
    {

        if(_controlador == null)
        {
            _controlador = new ControladorImp();
        }
	return _controlador;
    }

    public abstract void accion(int evento, Object datos);
}
