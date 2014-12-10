/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentacion;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import presentacion.Vista.cliente.GUIPrincipal_Cliente;
import presentacion.Vista.producto.GUIPrincipal_Producto;
import presentacion.Vista.venta.GUIPrincipal_Venta;




/**
 *
 * @author Ruben
 */
public class VentanaPrincipal extends JPanel {

	public VentanaPrincipal() {
            
            GUIPrincipal_Cliente principal_cliente = new GUIPrincipal_Cliente();
            GUIPrincipal_Producto principal_producto = new GUIPrincipal_Producto();
            GUIPrincipal_Venta principal_venta = new GUIPrincipal_Venta();
            
            //Imagenes para cada tab
		ImageIcon icono_clientes = new ImageIcon("icono-clientes.GIF");
                ImageIcon icono_productos = new ImageIcon("icono_productos.PNG");
                ImageIcon icono_ventas = new ImageIcon("icono_ventas.GIF");
                
               
                
		JTabbedPane tab_principal = new JTabbedPane();

                
                
		tab_principal.addTab("Clientes", icono_clientes, principal_cliente, "Clientes - Tab 1");
               
                
		
		tab_principal.addTab("Productos", icono_productos, principal_producto, "Productos - Tab 2");
                

		tab_principal.addTab("Ventas", icono_ventas, principal_venta, "Ventas - Tab 3");
                
                
/*		JPanel jplInnerPanel4 = createInnerPanel("Tab 4 ");
		tab_principal.addTab("Otro", jplInnerPanel4);
                */
                
		// Add the tabbed pane to this panel.
		setLayout(new GridLayout(1, 1));
		add(tab_principal);
	}
/*	protected JPanel createInnerPanel(String text) {
		JPanel jplPanel = new JPanel();
		JLabel jlbDisplay = new JLabel(text);
		jlbDisplay.setHorizontalAlignment(JLabel.CENTER);
		jplPanel.setLayout(new GridLayout(1, 1));
		jplPanel.add(jlbDisplay);
		return jplPanel;
	}
          */      
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
}
