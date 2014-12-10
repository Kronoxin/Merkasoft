/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.venta;


import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Ruben
 */
public class GUIPrincipal_Venta extends JPanel{
    
    public GUIPrincipal_Venta(){
        
        GUIAltaVenta alta = new GUIAltaVenta();
        GUIMostrarVenta mostrar_una = new GUIMostrarVenta();
        GUIMostrarListaVentas lista = new GUIMostrarListaVentas();
        GUIDevolverProducto dev = new GUIDevolverProducto();
        
         this.setLayout(new GridLayout(1, 2));
        
        JPanel panel_aux = new JPanel();
        JLabel lab_aux = new JLabel("aqui");
        panel_aux.add(lab_aux);
        
        JPanel panel_botones_ventas = new JPanel(new GridLayout(4,1,4,4));
                
                TitledBorder borde_productos = new TitledBorder("Ventas");
		borde_productos.setTitleFont(new Font(null, Font.BOLD, 16));
		borde_productos.setTitleJustification(TitledBorder.CENTER);
		panel_botones_ventas.setBorder(borde_productos);
                
           
                
                JButton boton_alta_venta = new JButton("Alta Venta");
                JButton boton_devolver_producto = new JButton("Devolver Producto");
                JButton boton_mostrar_venta = new JButton("Mostrar Venta");
                JButton boton_mostrar_lista_ventas = new JButton("Listado de Ventas");
                
                
                panel_botones_ventas.add(boton_alta_venta);
                panel_botones_ventas.add(boton_mostrar_venta);
                panel_botones_ventas.add(boton_devolver_producto);
                panel_botones_ventas.add(boton_mostrar_lista_ventas);
                
                this.add(panel_botones_ventas);
                this.add(mostrar_una);
                this.setVisible(true);
        
        
        
    }
    
}
