/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador.Dispatcher;

import presentacion.Controlador.Comandos.Command;
import presentacion.Controlador.Comandos.RespuestaComando;
import presentacion.Controlador.Eventos.EventoNegocio;
import presentacion.Vista.popups.PopupsCliente;
import presentacion.Vista.popups.PopupsProducto;
import presentacion.Vista.popups.PopupsVenta;


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
            //Eventos de exito en operaciones
            case EventoNegocio.EXITO_ALTA_CLIENTE:
            {
                PopupsCliente.AltaClienteExito();
                break;
            }       
            case EventoNegocio.EXITO_BAJA_CLIENTE:
            {
		PopupsCliente.BajaClienteExito();
                break;
            }
            case EventoNegocio.EXITO_MODIFICAR_CLIENTE:
            {
		PopupsCliente.ModificarClienteExito();
                break;
            }
            case EventoNegocio.EXITO_ALTA_PRODUCTO:
            {
		PopupsProducto.AltaProductoExito();
                break;
            }
            case EventoNegocio.EXITO_BAJA_PRODUCTO:
            {
		PopupsProducto.BajaProductoExito();
                break;
            }
            case EventoNegocio.EXITO_MODIFICAR_PRODUCTO:
            {
		PopupsProducto.ModificarProductoExito();
                break;
            }
            case EventoNegocio.EXITO_ALTA_VENTA:
            {
		PopupsVenta.AltaVentaExito();
                break;
            }
            case EventoNegocio.EXITO_DEVOLUCION_PRODUCTO:
            {
		PopupsVenta.DevolucionProductoExito();
                break;
            }
            
            //Eventos de fracaso en operaciones
            case EventoNegocio.FRACASO_ALTA_CLIENTE:
            {
		PopupsCliente.AltaClienteFracaso();
                break;
            }
            case EventoNegocio.FRACASO_BAJA_CLIENTE:
            {
		PopupsCliente.BajaClienteFracaso();
                break;
            }
            case EventoNegocio.FRACASO_MODIFICAR_CLIENTE:
            {
		PopupsCliente.ModificarClienteFracaso();
                break;
            }
            case EventoNegocio.FRACASO_ALTA_PRODUCTO:
            {
		PopupsProducto.AltaProductoFracaso();
                break;
            }
            case EventoNegocio.FRACASO_BAJA_PRODUCTO:
            {
		PopupsProducto.BajaProductoFracaso();
                break;
            }
            case EventoNegocio.FRACASO_MODIFICAR_PRODUCTO:
            {
		PopupsProducto.ModificarProductoFracaso();
                break;
            }
            case EventoNegocio.FRACASO_ALTA_VENTA:
            {
		PopupsVenta.AltaVentaFracaso();
                break;
            }
            case EventoNegocio.FRACASO_DEVOLUCION_PRODUCTO:
            {
		PopupsVenta.DevolucionProductoFracaso();
                break;
            }
                
        }
        return null;
    }
    
}
