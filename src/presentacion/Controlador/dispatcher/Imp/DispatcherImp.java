/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Controlador.dispatcher.Imp;

import java.util.ArrayList;
import negocio.departamentos.Departamento;
import negocio.empleados.Empleado;
import negocio.producto.TProducto;
import negocio.turnos.Turno;
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
import presentacion.Vista.departamento.GUIAltaDepartamento;
import presentacion.Vista.departamento.GUIBajaDepartamento;
import presentacion.Vista.departamento.GUICalcularNominaDepartamento;
import presentacion.Vista.departamento.GUIModificarDepartamento;
import presentacion.Vista.departamento.GUIMostrarDepartamento;
import presentacion.Vista.departamento.GUIMostrarListaDepartamentos;
import presentacion.Vista.empleado.GUIAltaEmpleado;
import presentacion.Vista.empleado.GUIBajaEmpleado;
import presentacion.Vista.empleado.GUIModificarEmpleado;
import presentacion.Vista.empleado.GUIMostrarEmpleado;
import presentacion.Vista.empleado.GUIMostrarListaEmpleados;
import presentacion.Vista.horario.GUIAsignarTurnoEmpleado;
import presentacion.Vista.horario.GUIMostrarRelacionTurnoEmpleado;
import presentacion.Vista.horario.GUIMostrarTurnosEmpleado;
import presentacion.Vista.popups.PopupsCliente;
import presentacion.Vista.popups.PopupsDepartamento;
import presentacion.Vista.popups.PopupsEmpleado;
import presentacion.Vista.popups.PopupsProducto;
import presentacion.Vista.popups.PopupsTurno;
import presentacion.Vista.popups.PopupsVenta;
import presentacion.Vista.producto.GUIAltaProducto;
import presentacion.Vista.producto.GUIBajaProducto;
import presentacion.Vista.producto.GUIModificarProducto;
import presentacion.Vista.producto.GUIMostrarListaProductos;
import presentacion.Vista.producto.GUIMostrarProducto;
import presentacion.Vista.turno.GUIAltaTurno;
import presentacion.Vista.turno.GUIBajaTurno;
import presentacion.Vista.turno.GUIModificarTurno;
import presentacion.Vista.turno.GUIMostrarListaTurnos;
import presentacion.Vista.turno.GUIMostrarTurno;
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
            
            //Eventos cliente
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
                
               TProducto producto = null;
                //Si viene para modificar [2]==mod  ; [3]==producto
                if(datos.size() == 4)
                {
                    String mod = (String)datos.get(2);
                    producto = (TProducto)datos.get(3);
                    ((GUIModificarProducto)datos.get(1)).cargarProductoEnLista(producto);
                }
                else
                {
                    producto = (TProducto)datos.get(2);
                    ((GUIMostrarProducto)datos.get(1)).cargarProductoEnLista(producto);
                }
		
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
            
            
            //SEGUNDA PARTE
            //comandos GUI de empleado
            case EventoNegocio.GUI_ALTA_EMPLEADO:
            {
                new GUIAltaEmpleado();
                break;
            }
            case EventoNegocio.GUI_BAJA_EMPLEADO:
            {
                new GUIBajaEmpleado();
                break;
            }
            case EventoNegocio.GUI_MOSTRAR_EMPLEADO:
            {
                new GUIMostrarEmpleado();
                break;
            }
            case EventoNegocio.GUI_MOSTRAR_LISTA_EMPLEADOS:
            {
                new GUIMostrarListaEmpleados();
                break;
            }
            case EventoNegocio.GUI_MOSTRAR_EMPLEADO_PARA_MODIFICAR:
            {
                new GUIModificarEmpleado();
                break;
            }
            case EventoNegocio.GUI_MODIFICAR_EMPLEADO:
            {
                new GUIModificarEmpleado();
                break;
            }
            
            //comandos GUI de departamento.
            case EventoNegocio.GUI_ALTA_DEPARTAMENTO:
            {
                new GUIAltaDepartamento();
                break;
            }
            case EventoNegocio.GUI_BAJA_DEPARTAMENTO:
            {
                new GUIBajaDepartamento();
                break;
            }
            case EventoNegocio.GUI_MOSTRAR_DEPARTAMENTO:
            {
                new GUIMostrarDepartamento();
                break;
            }
            case EventoNegocio.GUI_MOSTRAR_LISTA_DEPARTAMENTOS:
            {
                new GUIMostrarListaDepartamentos();
                break;
            }
            case EventoNegocio.GUI_MODIFICAR_DEPARTAMENTO:
            {
                new GUIModificarDepartamento();
                break;
            }
            case EventoNegocio.GUI_CALCULAR_NOMINA_DEPARTAMENTO:
            {
                new GUICalcularNominaDepartamento();
                break;
            }
            case EventoNegocio.GUI_MOSTRAR_DEPARTAMENTO_PARA_MODIFICAR:
            {
                new GUIModificarDepartamento();
                break;
            }
            
            //comandos GUI de Turno
            case EventoNegocio.GUI_ALTA_TURNO:
            {
                new GUIAltaTurno();
                break;
            }
            case EventoNegocio.GUI_BAJA_TURNO:
            {
                new GUIBajaTurno();
                break;
            }
            case EventoNegocio.GUI_MOSTRAR_TURNO:
            {
                new GUIMostrarTurno();
                break;
            }
            case EventoNegocio.GUI_MOSTRAR_LISTA_TURNOS:
            {
                new GUIMostrarListaTurnos();
                break;
            }
            case EventoNegocio.GUI_MODIFICAR_TURNO:
            {
                new GUIModificarTurno();
                break;
            }
			case EventoNegocio.GUI_MOSTRAR_TURNO_PARA_MODIFICAR:
            {
                new GUIModificarTurno();
                break;
            }
            
            //exitos empleado
            case EventoNegocio.EXITO_ALTA_EMPLEADO:
            {
                PopupsEmpleado.AltaEmpleadoExito();
                break;
            }
            case EventoNegocio.EXITO_BAJA_EMPLEADO:
            {
                PopupsEmpleado.BajaEmpleadoExito();
                break;
            }
            case EventoNegocio.EXITO_MODIFICAR_EMPLEADO:
            {
                PopupsEmpleado.ModificarEmpleadoExito();
                
                break;
            }
            case EventoNegocio.EXITO_MOSTRAR_EMPLEADO:
            {
                ArrayList<Object> datos = (ArrayList<Object>)comando.getDatos();
                
                Empleado empleado = (Empleado)datos.get(1);
                GUIMostrarEmpleado gme = new GUIMostrarEmpleado();
                gme.cargarEmpleadoEnLista(empleado);
               
                break;
            }
            case EventoNegocio.EXITO_MOSTRAR_EMPLEADO_PARA_MODIFICAR:
            {
               ArrayList<Object> datos = (ArrayList<Object>)comando.getDatos();
                
                Empleado empleado = (Empleado)datos.get(1);
                GUIModificarEmpleado gme = new GUIModificarEmpleado();
                gme.cargarEmpleadoEnLista(empleado);
              
                break; 
            }
            case EventoNegocio.EXITO_MOSTRAR_LISTA_EMPLEADO:
            {
                 ArrayList<Object> datos = (ArrayList<Object>)comando.getDatos();
                
                ArrayList<Empleado> empleados = (ArrayList<Empleado>)datos.get(0);
                GUIMostrarListaEmpleados gmle = new GUIMostrarListaEmpleados();
                gmle.cargarEmpleadoEnLista(empleados);
		
                break;
            }
            
            //exitos Departamento
            case EventoNegocio.EXITO_ALTA_DEPARTAMENTO:
            {
                PopupsDepartamento.AltaDepartamentoExito();
                break;
            }
            case EventoNegocio.EXITO_BAJA_DEPARTAMENTO:
            {
                PopupsDepartamento.BajaDepartamentoExito();
                break;
            }
            case EventoNegocio.EXITO_MODIFICAR_DEPARTAMENTO:
            {
                PopupsDepartamento.ModificarDepartamentoExito();
                break;
            }
            case EventoNegocio.EXITO_MOSTRAR_DEPARTAMENTO:
            {
                 ArrayList<Object> datos = (ArrayList<Object>)comando.getDatos();
                
                Departamento departamento = (Departamento)datos.get(1);
                //MODIFICACION HECHA POR NAVARRO
                GUIMostrarDepartamento gd= new GUIMostrarDepartamento();
                gd.cargarDepartamentoEnLista(departamento);
               
                break;
            }
            case EventoNegocio.EXITO_MOSTRAR_DEPARTAMENTO_PARA_MODIFICAR:
            {
                  ArrayList<Object> datos = (ArrayList<Object>)comando.getDatos();
                
                Departamento departamento = (Departamento)datos.get(1);
                GUIModificarDepartamento gd= new GUIModificarDepartamento();
                gd.cargarDepartamentoEnLista(departamento);

               
                break;
            }
            case EventoNegocio.EXITO_MOSTRAR_LISTA_DEPARTAMENTO:
            {
                ArrayList<Object> datos = (ArrayList<Object>)comando.getDatos();
                
                ArrayList<Departamento> departamentos = (ArrayList<Departamento>)datos.get(0);
                
                GUIMostrarListaDepartamentos mld= new GUIMostrarListaDepartamentos();
                mld.cargarDepartamentoEnLista(departamentos);
               
		
                break;
            }
            
            case EventoNegocio.EXITO_CALCULAR_NOMINA_DEPARTAMENTO:
            {
                ArrayList<Object> datos = (ArrayList<Object>)comando.getDatos();
                Departamento departamento = (Departamento)datos.get(0);
                double nomina = (double)datos.get(1);
                GUICalcularNominaDepartamento cn = new GUICalcularNominaDepartamento();
                cn.cargarDepartamentoEnListaConNomina(departamento, nomina);
                break;
            }
            
             case EventoNegocio.FRACASO_CALCULAR_NOMINA_DEPARTAMENTO:
            {
                PopupsDepartamento.CalcularNominaDepartamentoFracaso();
                break;
            }
            
            //exitos turno
            case EventoNegocio.EXITO_ALTA_TURNO:
            {
                PopupsTurno.AltaTurnoExito();
                break;
            }
            case EventoNegocio.EXITO_BAJA_TURNO:
            {
                PopupsTurno.BajaTurnoExito();
                break;
            }
            case EventoNegocio.EXITO_MODIFICAR_TURNO:
            {
                PopupsTurno.ModificarTurnoExito();
                break;
            }
            case EventoNegocio.EXITO_MOSTRAR_TURNO:
            {
                ArrayList<Object> datos = (ArrayList<Object>)comando.getDatos();
                
                Turno turno = (Turno)datos.get(1);
                GUIMostrarTurno gmt = new GUIMostrarTurno();
                gmt.cargarTurnoEnLista(turno);
                
                break;
            }
            case EventoNegocio.EXITO_MOSTRAR_LISTA_TURNO:
            {
                ArrayList<Object> datos = (ArrayList<Object>)comando.getDatos();
                
                ArrayList<Turno> turnos = (ArrayList<Turno>)datos.get(0);
                GUIMostrarListaTurnos gmlt = new GUIMostrarListaTurnos();
                gmlt.cargarTurnoEnLista(turnos);
		
                break;
            }
            case EventoNegocio.EXITO_MOSTRAR_TURNO_PARA_MODIFICAR:
            {
               ArrayList<Object> datos = (ArrayList<Object>)comando.getDatos();
                
                Turno turno = (Turno)datos.get(1);
                GUIModificarTurno gmt = new GUIModificarTurno();
                gmt.cargarTurnoEnLista(turno);
                break;
            }
            
            //fracaso Empleado
            case EventoNegocio.FRACASO_ALTA_EMPLEADO:
            {
                PopupsEmpleado.AltaEmpleadoFracaso();
                break;
            }
            case EventoNegocio.FRACASO_BAJA_EMPLEADO:
            {
                PopupsEmpleado.BajaEmpleadoFracaso();
                break;
            }
            case EventoNegocio.FRACASO_MODIFICAR_EMPLEADO:
            {
                PopupsEmpleado.ModificarEmpleadoFracaso();
                break;
            }
            case EventoNegocio.FRACASO_MOSTRAR_EMPLEADO_PARA_MODIFICAR:
            {
                PopupsEmpleado.ModificarEmpleadoFracaso();
                break;
            }
            
            //fracaso Departamento
            case EventoNegocio.FRACASO_ALTA_DEPARTAMENTO:
            {
                PopupsDepartamento.AltaDepartamentoFracaso();
                break;
            }
            case EventoNegocio.FRACASO_BAJA_DEPARTAMENTO:
            {
                PopupsDepartamento.BajaDepartamentoFracaso();
                break;
            }
            case EventoNegocio.FRACASO_MODIFICAR_DEPARTAMENTO:
            {
                PopupsDepartamento.ModificarDepartamentoFracaso();
                break;
            }
            
            case EventoNegocio.FRACASO_MOSTRAR_DEPARTAMENTO_PARA_MODIFICAR:
            {
                PopupsDepartamento.ModificarDepartamentoFracaso();
                break;
            }
            
            //fracaso Turno
            case EventoNegocio.FRACASO_ALTA_TURNO:
            {
                PopupsTurno.AltaTurnoFracaso();
                break;
            }
            case EventoNegocio.FRACASO_BAJA_TURNO:
            {
                PopupsTurno.BajaTurnoFracaso();
                break;
            }
            case EventoNegocio.FRACASO_MODIFICAR_TURNO:
            {
                PopupsTurno.ModificarTurnoFracaso();
                break;
            }
			case EventoNegocio.FRACASO_MOSTRAR_TURNO_PARA_MODIFICAR:
            {
                PopupsTurno.ModificarTurnoFracaso();
                break;
            }
            //horarios
            case EventoNegocio.GUI_ASIGNAR_TURNO_EMPLEADO:
            {
                new GUIAsignarTurnoEmpleado();
                break;
            }
            case EventoNegocio.GUI_MOSTRAR_TURNOS_EMPLEADO:
            {
                new GUIMostrarTurnosEmpleado();
                break;
            }
            case EventoNegocio.GUI_MOSTRAR_RELACION_TURNO_EMPLEADO:
            {
                new GUIMostrarRelacionTurnoEmpleado();
                break;
            }
                        
                        

        
                
        }
    }
    
}
   

