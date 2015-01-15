/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.FactoriaComandos.Imp;


import presentacion.Controlador.Comandos.cliente.GUI.comandoGUImediaClientes;
import presentacion.Controlador.Comandos.cliente.*;
import presentacion.Controlador.Comandos.producto.*;
import presentacion.Controlador.Comandos.venta.*;
import presentacion.Controlador.Comandos.cliente.GUI.*;
import presentacion.Controlador.Comandos.producto.GUI.*;
import presentacion.Controlador.Comandos.venta.GUI.*;
import presentacion.FactoriaComandos.factoriaComandos;
import presentacion.Controlador.Comandos.Command;
import presentacion.Controlador.Comandos.empleado.GUI.comandoGUIaltaEmpleado;
import presentacion.Controlador.Comandos.empleado.comandoAltaEmpleado;
import presentacion.Controlador.Eventos.EventoNegocio;
/**
 *
 * @author Pepu
 */
public class factoriaComandosImp extends factoriaComandos 
{
    @Override
    public Command getCommand(int evento) 
    {
        Command comando = null;

	switch(evento)
        {
            //Eventos de cliente
            case EventoNegocio.ALTA_CLIENTE: {
                comando = new comandoAltaCliente();
                break;
            }
            case EventoNegocio.BAJA_CLIENTE: {
                comando = new comandoBajaCliente();
                break;
            }
            case EventoNegocio.MOSTRAR_CLIENTE: {
                comando = new comandoMostrarCliente();
                break;
            }
            case EventoNegocio.MOSTRAR_LISTA_CLIENTES: {
                comando = new comandoMostrarListaClientes();
                break;
            }
            case EventoNegocio.MODIFICAR_CLIENTE: {
                comando = new comandoModificarCliente();
                break;
            }
            
            //Eventos de cliente GUI
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
            
            case EventoNegocio.GUI_MEDIA_CLIENTES:
            {
                comando = new comandoGUImediaClientes();
                break;
            }
            
            //Eventos de producto
            case EventoNegocio.ALTA_PRODUCTO:
            {
		comando = new comandoAltaProducto();
                break;
            }
            case EventoNegocio.BAJA_PRODUCTO:
            {
		comando = new comandoBajaProducto();
                break;
            }
            case EventoNegocio.MOSTRAR_PRODUCTO:
            {
		comando = new comandoMostrarProducto();
                break;
            }
            case EventoNegocio.MOSTRAR_LISTA_PRODUCTOS:
            {
		comando = new comandoMostrarListaProductos();
                break;
            }
            case EventoNegocio.MODIFICAR_PRODUCTO:
            {
		comando = new comandoModificarProducto();
                break;
            }
            
            //Eventos de GUI producto
            case EventoNegocio.GUI_ALTA_PRODUCTO:
            {
		comando = new comandoGUIcrearProducto();
                break;
            }
            case EventoNegocio.GUI_BAJA_PRODUCTO:
            {
		comando = new comandoGUIeliminarProducto();
                break;
            }
            case EventoNegocio.GUI_MOSTRAR_PRODUCTO:
            {
		comando = new comandoGUImostrarProducto();
                break;
            }
            case EventoNegocio.GUI_MOSTRAR_LISTA_PRODUCTOS:
            {
		comando = new comandoGUImostrarListaProductos();
                break;
            }
            case EventoNegocio.GUI_MODIFICAR_PRODUCTO:
            {
		comando = new comandoGUImodificarProducto();
                break;
            }
            
            //Eventos de venta
            case EventoNegocio.ALTA_VENTA:
            {
		comando = new comandoAltaVenta();
                break;
            }
            case EventoNegocio.DEVOLUCION_PRODUCTO:
            {
		comando = new comandoDevolucionProducto();
                break;
            }
            case EventoNegocio.MOSTRAR_VENTA:
            {
		comando = new comandoMostrarVenta();
                break;
            }
            case EventoNegocio.MOSTRAR_LISTA_VENTAS:
            {
		comando = new comandoMostrarListaVentas();
                break;
            }
            
            //Eventos de GUI venta
            case EventoNegocio.GUI_ALTA_VENTA:
            {
		comando = new comandoGUIcrearVenta();
                break;
            }
            case EventoNegocio.GUI_DEVOLUCION_PRODUCTO:
            {
		comando = new comandoGUIdevolucionProducto();
                break;
            }
            case EventoNegocio.GUI_MOSTRAR_VENTA:
            {
		comando = new comandoGUImostrarVenta();
                break;
            }
            case EventoNegocio.GUI_MOSTRAR_LISTA_VENTAS:
            {
		comando = new comandoGUImostrarListaVentas();
                break;
            }
            //Eventos de vista
            
            
            //SEGUNDA PARTE
            case EventoNegocio.GUI_ALTA_EMPLEADO:
            {
                comando = new comandoGUIaltaEmpleado();
                break;
            }
           
            default:
                comando=null;
                break;
        }
        return comando;
    }
    
}
