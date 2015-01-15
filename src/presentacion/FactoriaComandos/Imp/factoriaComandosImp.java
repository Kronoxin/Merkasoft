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
import presentacion.Controlador.Comandos.departamento.GUI.comandoGUIaltaDepartamento;
import presentacion.Controlador.Comandos.departamento.GUI.comandoGUIcalcularNominaDepartamento;
import presentacion.Controlador.Comandos.departamento.GUI.comandoGUIeliminarDepartamento;
import presentacion.Controlador.Comandos.departamento.GUI.comandoGUImodificarDepartamento;
import presentacion.Controlador.Comandos.departamento.GUI.comandoGUImostrarDepartamento;
import presentacion.Controlador.Comandos.departamento.GUI.comandoGUImostrarListaDepartamentos;
import presentacion.Controlador.Comandos.departamento.comandoAltaDepartamento;
import presentacion.Controlador.Comandos.departamento.comandoBajaDepartamento;
import presentacion.Controlador.Comandos.departamento.comandoCalcularNominaDepartamento;
import presentacion.Controlador.Comandos.departamento.comandoModificarDepartamento;
import presentacion.Controlador.Comandos.departamento.comandoMostrarDepartamento;
import presentacion.Controlador.Comandos.departamento.comandoMostrarListaDepartamentos;
import presentacion.Controlador.Comandos.empleado.GUI.comandoGUIaltaEmpleado;
import presentacion.Controlador.Comandos.empleado.GUI.comandoGUIeliminarEmpleado;
import presentacion.Controlador.Comandos.empleado.GUI.comandoGUImodificarEmpleado;
import presentacion.Controlador.Comandos.empleado.GUI.comandoGUImostrarEmpleado;
import presentacion.Controlador.Comandos.empleado.GUI.comandoGUImostrarListaEmpleados;
import presentacion.Controlador.Comandos.empleado.comandoAltaEmpleado;
import presentacion.Controlador.Comandos.empleado.comandoBajaEmpleado;
import presentacion.Controlador.Comandos.empleado.comandoModificarEmpleado;
import presentacion.Controlador.Comandos.empleado.comandoMostrarEmpleado;
import presentacion.Controlador.Comandos.empleado.comandoMostrarListaEmpleados;
import presentacion.Controlador.Comandos.turno.GUI.comandoGUIaltaTurno;
import presentacion.Controlador.Comandos.turno.GUI.comandoGUIeliminarTurno;
import presentacion.Controlador.Comandos.turno.GUI.comandoGUImodificarTurno;
import presentacion.Controlador.Comandos.turno.GUI.comandoGUImostrarListaTurnos;
import presentacion.Controlador.Comandos.turno.GUI.comandoGUImostrarTurno;
import presentacion.Controlador.Comandos.turno.*;
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
            //eventos Empleado
             case EventoNegocio.ALTA_EMPLEADO:
            {
                comando = new comandoAltaEmpleado();
                break;
            }
            case EventoNegocio.BAJA_EMPLEADO:
            {
                comando = new comandoBajaEmpleado();
                break;
            }
            case EventoNegocio.MODIFICAR_EMPLEADO:
            {
                comando = new comandoModificarEmpleado();
                break;
            }
            case EventoNegocio.MOSTRAR_EMPLEADO:
            {
                comando = new comandoMostrarEmpleado();
                break;
            }
            case EventoNegocio.MOSTRAR_LISTA_EMPLEADO:
            {
                comando = new comandoMostrarListaEmpleados();
                break;
            }
            
            //eventos GUI Empleado
            case EventoNegocio.GUI_ALTA_EMPLEADO:
            {
                comando = new comandoGUIaltaEmpleado();
                break;
            }
            case EventoNegocio.GUI_BAJA_EMPLEADO:
            {
                comando = new comandoGUIeliminarEmpleado();
                break;
            }
            case EventoNegocio.GUI_MODIFICAR_EMPLEADO:
            {
                comando = new comandoGUImodificarEmpleado();
                break;
            }
            case EventoNegocio.GUI_MOSTRAR_EMPLEADO:
            {
                comando = new comandoGUImostrarEmpleado();
                break;
            }
            case EventoNegocio.GUI_MOSTRAR_LISTA_EMPLEADOS:
            {
                comando = new comandoGUImostrarListaEmpleados();
                break;
            }
            //eventos Departamento
             case EventoNegocio.ALTA_DEPARTAMENTO:
            {
                comando = new comandoAltaDepartamento();
                break;
            }
            case EventoNegocio.BAJA_DEPARTAMENTO:
            {
                comando = new comandoBajaDepartamento();
                break;
            }
            case EventoNegocio.MOSTRAR_DEPARTAMENTO:
            {
                comando = new comandoMostrarDepartamento();
                break;
            }
            case EventoNegocio.MOSTRAR_LISTA_DEPARTAMENTO:
            {
                comando = new comandoMostrarListaDepartamentos();
                break;
            }
            case EventoNegocio.MODIFICAR_DEPARTAMENTO:
            {
                comando = new comandoModificarDepartamento();
                break;
            }
            case EventoNegocio.CALCULAR_NOMINA_DEPARTAMENTO:
            {
                comando = new comandoCalcularNominaDepartamento();
                break;
            }
            
            //eventos GUI Departamento
            case EventoNegocio.GUI_ALTA_DEPARTAMENTO:
            {
                comando = new comandoGUIaltaDepartamento();
                break;
            }
            case EventoNegocio.GUI_BAJA_DEPARTAMENTO:
            {
                comando = new comandoGUIeliminarDepartamento();
                break;
            }
            case EventoNegocio.GUI_MOSTRAR_DEPARTAMENTO:
            {
                comando = new comandoGUImostrarDepartamento();
                break;
            }
            case EventoNegocio.GUI_MOSTRAR_LISTA_DEPARTAMENTOS:
            {
                comando = new comandoGUImostrarListaDepartamentos();
                break;
            }
            case EventoNegocio.GUI_MODIFICAR_DEPARTAMENTO:
            {
                comando = new comandoGUImodificarDepartamento();
                break;
            }
            case EventoNegocio.GUI_CALCULAR_NOMINA_DEPARTAMENTO:
            {
                comando = new comandoGUIcalcularNominaDepartamento();
                break;
            }
            
            //eventos Turno
            
            case EventoNegocio.ALTA_TURNO:
            {
                comando = new comandoAltaTurno();
                break;
            }
            case EventoNegocio.BAJA_TURNO:
            {
                comando = new comandoBajaTurno();
                break;
            }
            case EventoNegocio.MODIFICAR_TURNO:
            {
                comando = new comandoModificarTurno();
                break;
            }
            case EventoNegocio.MOSTRAR_TURNO:
            {
                comando = new comandoMostrarTurno();
                break;
            }
            case EventoNegocio.MOSTRAR_LISTA_TURNO:
            {
                comando = new comandoMostrarListaTurnos();
                break;
            }
            
            //eventos GUI turno
            case EventoNegocio.GUI_ALTA_TURNO:
            {
                comando = new comandoGUIaltaTurno();
                break;
            }
            case EventoNegocio.GUI_BAJA_TURNO:
            {
                comando = new comandoGUIeliminarTurno();
                break;
            }
            case EventoNegocio.GUI_MODIFICAR_TURNO:
            {
                comando = new comandoGUImodificarTurno();
                break;
            }
            case EventoNegocio.GUI_MOSTRAR_TURNO:
            {
                comando = new comandoGUImostrarTurno();
                break;
            }
            case EventoNegocio.GUI_MOSTRAR_LISTA_TURNOS:
            {
                comando = new comandoGUImostrarListaTurnos();
                break;
            }
            
            
           
            default:
                comando=null;
                break;
        }
        return comando;
    }
    
}
