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
    
        GUIAltaProducto alta = new GUIAltaProducto();
        GUIMostrarProducto mostrar_producto = new GUIMostrarProducto();
        GUIMostrarListaProductos lista_productos = new GUIMostrarListaProductos();
        GUIModificarProducto mod = new GUIModificarProducto();
        GUIBajaProducto baja = new GUIBajaProducto();
        JPanel panel_botones_productos = new JPanel(new GridLayout(5,1,4,4));

        TitledBorder borde_productos = new TitledBorder("Productos");
        
        JButton boton_alta_producto = new JButton("Alta Producto");
        JButton boton_baja_producto = new JButton("Baja Producto");
        JButton boton_mostrar_producto = new JButton("Mostrar Producto");
        JButton boton_modificar_producto = new JButton("Modificar Producto");
        JButton boton_mostrar_lista_productos = new JButton("Listado de Productos");
        
    public GUIPrincipal_Producto(){

        
        this.setLayout(new GridLayout(1, 2));


		borde_productos.setTitleFont(new Font(null, Font.BOLD, 16));
		borde_productos.setTitleJustification(TitledBorder.CENTER);
		panel_botones_productos.setBorder(borde_productos);
                
                //añadimos los botones al panell
                panel_botones_productos.add(boton_alta_producto);
                panel_botones_productos.add(boton_mostrar_producto);
                panel_botones_productos.add(boton_modificar_producto);
                panel_botones_productos.add(boton_baja_producto);
                panel_botones_productos.add(boton_mostrar_lista_productos);
                
                this.add(panel_botones_productos);
                this.add(mostrar_producto);
                this.setVisible(true);
                
    }
    //getters y setters
    public GUIAltaProducto getAlta() {
        return alta;
    }

    public void setAlta(GUIAltaProducto alta) {
        this.alta = alta;
    }

    public GUIMostrarProducto getMostrar_producto() {
        return mostrar_producto;
    }

    public void setMostrar_producto(GUIMostrarProducto mostrar_producto) {
        this.mostrar_producto = mostrar_producto;
    }

    public GUIMostrarListaProductos getLista_productos() {
        return lista_productos;
    }

    public void setLista_productos(GUIMostrarListaProductos lista_productos) {
        this.lista_productos = lista_productos;
    }

    public GUIModificarProducto getMod() {
        return mod;
    }

    public void setMod(GUIModificarProducto mod) {
        this.mod = mod;
    }

    public GUIBajaProducto getBaja() {
        return baja;
    }

    public void setBaja(GUIBajaProducto baja) {
        this.baja = baja;
    }

    public JPanel getPanel_botones_productos() {
        return panel_botones_productos;
    }

    public void setPanel_botones_productos(JPanel panel_botones_productos) {
        this.panel_botones_productos = panel_botones_productos;
    }

    public TitledBorder getBorde_productos() {
        return borde_productos;
    }

    public void setBorde_productos(TitledBorder borde_productos) {
        this.borde_productos = borde_productos;
    }

    public JButton getBoton_alta_producto() {
        return boton_alta_producto;
    }

    public void setBoton_alta_producto(JButton boton_alta_producto) {
        this.boton_alta_producto = boton_alta_producto;
    }

    public JButton getBoton_baja_producto() {
        return boton_baja_producto;
    }

    public void setBoton_baja_producto(JButton boton_baja_producto) {
        this.boton_baja_producto = boton_baja_producto;
    }

    public JButton getBoton_mostrar_producto() {
        return boton_mostrar_producto;
    }

    public void setBoton_mostrar_producto(JButton boton_mostrar_producto) {
        this.boton_mostrar_producto = boton_mostrar_producto;
    }

    public JButton getBoton_modificar_producto() {
        return boton_modificar_producto;
    }

    public void setBoton_modificar_producto(JButton boton_modificar_producto) {
        this.boton_modificar_producto = boton_modificar_producto;
    }

    public JButton getBoton_mostrar_lista_productos() {
        return boton_mostrar_lista_productos;
    }

    public void setBoton_mostrar_lista_productos(JButton boton_mostrar_lista_productos) {
        this.boton_mostrar_lista_productos = boton_mostrar_lista_productos;
    }
    
    
    
}
