/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentacion;

import java.awt.*;
import java.awt.event.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;

import presentacion.Vista.cliente.GUIPrincipal_Cliente;
import presentacion.Vista.departamento.GUIPrincipal_Departamento;
import presentacion.Vista.empleado.GUIPrincipal_Empleado;
import presentacion.Vista.horario.GUIPrincipal_Horario;
import presentacion.Vista.producto.GUIPrincipal_Producto;
import presentacion.Vista.turno.GUIPrincipal_Turno;
import presentacion.Vista.venta.GUIPrincipal_Venta;



public class VentanaPrincipal extends JPanel {
    
    private final JTabbedPane tab_principal = new JTabbedPane();
    
    
    //PRIMERA ENTREGA
    GUIPrincipal_Cliente principal_cliente = new GUIPrincipal_Cliente();
    GUIPrincipal_Producto principal_producto = new GUIPrincipal_Producto();
    GUIPrincipal_Venta principal_venta = new GUIPrincipal_Venta();
            
    private final ImageIcon icono_clientes = new ImageIcon("icono-clientes.GIF");
    private final ImageIcon icono_productos = new ImageIcon("icono_productos.PNG");
    private final ImageIcon icono_ventas = new ImageIcon("icono_ventas.GIF");
    
    //SEGUNDA ENTREGA
    GUIPrincipal_Empleado principal_empleado = new GUIPrincipal_Empleado();
    GUIPrincipal_Departamento principal_departamento = new GUIPrincipal_Departamento();
    GUIPrincipal_Turno principal_turno = new GUIPrincipal_Turno();
    GUIPrincipal_Horario principal_horario = new GUIPrincipal_Horario();
    
    private final ImageIcon icono_empleados = new ImageIcon("icono-empleados.PNG");
    private final ImageIcon icono_departamentos = new ImageIcon("icono-departamento.PNG");
    private final ImageIcon icono_turnos = new ImageIcon("icono-turno.GIF");
    private final ImageIcon icono_horarios = new ImageIcon("icono-horarios.PNG");
    

	public VentanaPrincipal() {
            
            //añadimos el Tab de clientes al principal, con el icono y la clase principal de este panel
            tab_principal.addTab("Clientes", icono_clientes, principal_cliente, "Clientes - Tab 1");

            //añadimos el Tab de Productos al principal, con el icono y la clase principal de este panel
            tab_principal.addTab("Productos", icono_productos, principal_producto, "Productos - Tab 2");

            //añadimos el Tab de Ventas al principal, con el icono y la clase principal de este panel
            tab_principal.addTab("Ventas", icono_ventas, principal_venta, "Ventas - Tab 3");
            
            //añadimos el Tab de Empleados al principal, con el icono y la clase principal de este panel
            tab_principal.addTab("Empleados", icono_empleados, principal_empleado, "Empleados - Tab 4");
            
            //añadimos el Tab de Departamentos al principal, con el icono y la clase principal de este panel
            tab_principal.addTab("Departamentos", icono_departamentos, principal_departamento, "Departamentos - Tab 5");
            
            //añadimos el Tab de Turnos al principal, con el icono y la clase principal de este panel
            tab_principal.addTab("Turnos", icono_turnos, principal_turno, "Turnos - Tab 6");
            
            tab_principal.addTab("Horarios", icono_horarios, principal_horario, "Horarios - Tab 7");
            
            

            setLayout(new GridLayout(1, 1));
            this.add(tab_principal);
            setSize(1000, 700);
            setVisible(true);
	}
        
     //Main de ejecución para la interfaz gráfica
     //tengo otra clase que extiende directamente desde JFrame, por si hace falta.
    public static void main(String[] args) {
		JFrame frame = new JFrame("");
		frame.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.getContentPane().add(new VentanaPrincipal(),BorderLayout.CENTER);
		frame.setSize(1000, 700);
		frame.setVisible(true);
	}

    //Getters y setters
    public GUIPrincipal_Cliente getPrincipal_cliente() {
        return principal_cliente;
    }

    public void setPrincipal_cliente(GUIPrincipal_Cliente principal_cliente) {
        this.principal_cliente = principal_cliente;
    }

    public GUIPrincipal_Producto getPrincipal_producto() {
        return principal_producto;
    }

    public void setPrincipal_producto(GUIPrincipal_Producto principal_producto) {
        this.principal_producto = principal_producto;
    }

    public GUIPrincipal_Venta getPrincipal_venta() {
        return principal_venta;
    }

    public void setPrincipal_venta(GUIPrincipal_Venta principal_venta) {
        this.principal_venta = principal_venta;
    }

    
    
  
    
}
