/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador.Comandos;

/**
 *
 * @author Pepu
 */
public class RespuestaComando 
{
    private int evento;
    private Object datos;
	
    public RespuestaComando(int evento, Object datos) 
    {
	this.evento = evento;
	this.datos = datos;
    }
	
	public int getEvento() {
		return evento;
	}
	
	public Object getDatos() {
		return datos;
	}
    
}
