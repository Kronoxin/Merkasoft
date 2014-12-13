/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador.dispatcher.Imp;

import java.util.ArrayList;
import negocio.producto.TProducto;
import presentacion.Controlador.Comandos.RespuestaComando;
import presentacion.Controlador.Eventos.EventoNegocio;
import presentacion.Controlador.dispatcher.Dispatcher;
import presentacion.VentanaPrincipal;
import presentacion.Vista.cliente.GUIAltaCliente;
import presentacion.Vista.cliente.GUIBajaCliente;
import presentacion.Vista.cliente.GUIClientesMedia;
import presentacion.Vista.cliente.GUIModificarCliente;
import presentacion.Vista.cliente.GUIMostrarCliente;
import presentacion.Vista.cliente.GUIMostrarListaClientes;
import presentacion.Vista.cliente.GUIPrincipal_Cliente;
import presentacion.Vista.popups.PopupsCliente;
import presentacion.Vista.popups.PopupsProducto;
import presentacion.Vista.popups.PopupsVenta;
import presentacion.Vista.producto.GUIAltaProducto;
import presentacion.Vista.producto.GUIBajaProducto;
import presentacion.Vista.producto.GUIModificarProducto;
import presentacion.Vista.producto.GUIMostrarListaProductos;
import presentacion.Vista.producto.GUIMostrarProducto;
import presentacion.Vista.venta.GUIAltaVenta;
import presentacion.Vista.venta.GUIDevolverProducto;
import presentacion.Vista.venta.GUIMostrarListaVentas;
import presentacion.Vista.venta.GUIMostrarVenta;


public class DispatcherImp extends Dispatcher
{

 @Override
   public void dispatch(RespuestaComando comando)
    {
        switch(comando.getEvento())
        {
             //Eventos GUI cliente
            case EventoNegocio.GUI_ALTA_CLIENTE:
            {
                new GUIAltaCliente();
                break;
            }
            
            case EventoNegocio.GUI_BAJA_CLIENTE:
            {
                new GUIBajaCliente();
                break;
            }
            case EventoNegocio.GUI_MEDIA_CLIENTES:
            {
                new GUIClientesMedia();
                break;
            }
            case EventoNegocio.GUI_MODIFICAR_CLIENTE:
            {
                new GUIModificarCliente();
                break;
            }
            case EventoNegocio.GUI_MOSTRAR_CLIENTE:
            {
                new GUIMostrarCliente();
                break;
            }
            case EventoNegocio.GUI_MOSTRAR_LISTA_CLIENTES:
            {
                new GUIMostrarListaClientes();
                break;
            }
            
            //GUIS DE PRODUCTO
            
            case EventoNegocio.GUI_ALTA_PRODUCTO:
            {
                new GUIAltaProducto();
                break;
            }
            case EventoNegocio.GUI_BAJA_PRODUCTO:
            {
                new GUIBajaProducto();
                break;
            }
            case EventoNegocio.GUI_MODIFICAR_PRODUCTO:
            {
                new GUIModificarProducto();
                break;
            }
            case EventoNegocio.GUI_MOSTRAR_PRODUCTO:
            {
                new GUIMostrarProducto();
                break;
            }
            case EventoNegocio.GUI_MOSTRAR_LISTA_PRODUCTOS:
            {
                new GUIMostrarListaProductos();
                break;
            }
            
            //GUI VENTAS
            
            case EventoNegocio.GUI_ALTA_VENTA:
            {
                new GUIAltaVenta();
                break;
            }
            case EventoNegocio.GUI_DEVOLUCION_PRODUCTO:
            {
                new GUIDevolverProducto();
                break;
            }
            case EventoNegocio.GUI_MOSTRAR_VENTA:
            {
                new GUIMostrarVenta();
                break;
            }
            case EventoNegocio.GUI_MOSTRAR_LISTA_VENTAS:
            {
                new GUIMostrarListaVentas();
                break;
            }
            
            //Eventos GUI cliente
            case EventoNegocio.ALTA_CLIENTE:
            {
                //VentanaPrincipal.ventanaPrincipal.getPrincipal_cliente().cambioVentana("alta");
                break;
            }  
            case EventoNegocio.BAJA_CLIENTE:
            {
                //VentanaPrincipal.ventanaPrincipal.getPrincipal_cliente().cambioVentana("baja");
                break;
            }
            
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
		PopupsProducto.AltaProductoExito((int)comando.getDatos());
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
            
            case EventoNegocio.EXITO_MOSTRAR_PRODUCTO:
            {
                ArrayList<Object> datos = (ArrayList<Object>)comando.getDatos();
                
                TProducto producto = (TProducto)datos.get(2);
                ((GUIMostrarProducto)datos.get(1)).cargarProductoEnLista(producto);
		
                break;
            }
            
            case EventoNegocio.EXITO_MOSTRAR_LISTA_PRODUCTO:
            {
                ArrayList<Object> datos = (ArrayList<Object>)comando.getDatos();
                
                ArrayList<TProducto> productos = (ArrayList<TProducto>)datos.get(1);
                ((GUIMostrarListaProductos)datos.get(0)).cargarProductoEnLista(productos);
		
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
    }
    
}
   

