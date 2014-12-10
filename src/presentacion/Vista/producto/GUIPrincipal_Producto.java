/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.producto;

import java.awt.*;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Ruben
 */
public class GUIPrincipal_Producto extends JPanel{
    
    public GUIPrincipal_Producto(){
        
        GUIAltaProducto alta = new GUIAltaProducto();
        GUIMostrarProducto mostrar_producto = new GUIMostrarProducto();
        GUIMostrarListaProductos lista_productos = new GUIMostrarListaProductos();
        GUIModificarProducto mod = new GUIModificarProducto();
        GUIBajaProducto baja = new GUIBajaProducto();
        
        this.setLayout(new GridLayout(1, 2));
        
     /*   JPanel panel_aux = new JPanel();
        JLabel lab_aux = new JLabel("aqui");
        panel_aux.add(lab_aux);
        */
        JPanel panel_botones_productos = new JPanel(new GridLayout(5,1,4,4));
                
                TitledBorder borde_productos = new TitledBorder("Productos");
		borde_productos.setTitleFont(new Font(null, Font.BOLD, 16));
		borde_productos.setTitleJustification(TitledBorder.CENTER);
		panel_botones_productos.setBorder(borde_productos);
                
           
                
                JButton boton_alta_producto = new JButton("Alta Producto");
                JButton boton_baja_producto = new JButton("Baja Producto");
                JButton boton_mostrar_producto = new JButton("Mostrar Producto");
                JButton boton_modificar_producto = new JButton("Modificar Producto");
                JButton boton_mostrar_lista_productos = new JButton("Listado de Productos");
                
                
                panel_botones_productos.add(boton_alta_producto);
                panel_botones_productos.add(boton_mostrar_producto);
                panel_botones_productos.add(boton_modificar_producto);
                panel_botones_productos.add(boton_baja_producto);
                panel_botones_productos.add(boton_mostrar_lista_productos);
                
                this.add(panel_botones_productos);
                this.add(lista_productos);
                this.setVisible(true);
                
    }
    
}
