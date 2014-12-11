/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.venta;


import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Eventos.EventoNegocio;

/**
 *
 * @author Ruben
 */
public class GUIPrincipal_Venta extends JPanel{
        GUIAltaVenta alta = new GUIAltaVenta();
        GUIMostrarVenta mostrar_una = new GUIMostrarVenta();
        GUIMostrarListaVentas lista = new GUIMostrarListaVentas();
        GUIDevolverProducto dev = new GUIDevolverProducto();
        
        JPanel panel_botones_ventas = new JPanel(new GridLayout(4,1,4,4));

        TitledBorder borde_productos = new TitledBorder("Ventas");

        JButton boton_alta_venta = new JButton("Alta Venta");
        JButton boton_devolver_producto = new JButton("Devolver Producto");
        JButton boton_mostrar_venta = new JButton("Mostrar Venta");
        JButton boton_mostrar_lista_ventas = new JButton("Listado de Ventas");
    
    public GUIPrincipal_Venta(){
        
        this.setLayout(new GridLayout(1, 2));
        
        borde_productos.setTitleFont(new Font(null, Font.BOLD, 16));
        borde_productos.setTitleJustification(TitledBorder.CENTER);
        panel_botones_ventas.setBorder(borde_productos);

        panel_botones_ventas.add(boton_alta_venta);
        panel_botones_ventas.add(boton_mostrar_venta);
        panel_botones_ventas.add(boton_devolver_producto);
        panel_botones_ventas.add(boton_mostrar_lista_ventas);
        
        //incorporamos el actionListener!
        boton_alta_venta.addActionListener(new oyenteVenta());
        boton_mostrar_venta.addActionListener(new oyenteVenta());
        boton_devolver_producto.addActionListener(new oyenteVenta());
        boton_mostrar_lista_ventas.addActionListener(new oyenteVenta());

        this.add(panel_botones_ventas);
        this.add(mostrar_una);
        this.setVisible(true);
          
    }
    class oyenteVenta implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if( e.getSource() ==  boton_alta_venta){
                    Controlador.getInstance().accion(EventoNegocio.GUI_ALTA_VENTA, GUIPrincipal_Venta.this);
            }
            else if( e.getSource() == boton_devolver_producto){
                    Controlador.getInstance().accion(EventoNegocio.GUI_DEVOLUCION_PRODUCTO, GUIPrincipal_Venta.this);
            }
            else if( e.getSource() == boton_mostrar_lista_ventas){
                    Controlador.getInstance().accion(EventoNegocio.GUI_MOSTRAR_LISTA_VENTAS, GUIPrincipal_Venta.this);
            }
            else if( e.getSource() == boton_mostrar_venta){
                    Controlador.getInstance().accion(EventoNegocio.GUI_MOSTRAR_VENTA, GUIPrincipal_Venta.this);
            
            }
        }
    }

    public GUIAltaVenta getAlta() {
        return alta;
    }

    public void setAlta(GUIAltaVenta alta) {
        this.alta = alta;
    }

    public GUIMostrarVenta getMostrar_una() {
        return mostrar_una;
    }

    public void setMostrar_una(GUIMostrarVenta mostrar_una) {
        this.mostrar_una = mostrar_una;
    }

    public GUIMostrarListaVentas getLista() {
        return lista;
    }

    public void setLista(GUIMostrarListaVentas lista) {
        this.lista = lista;
    }

    public GUIDevolverProducto getDev() {
        return dev;
    }

    public void setDev(GUIDevolverProducto dev) {
        this.dev = dev;
    }

    public JPanel getPanel_botones_ventas() {
        return panel_botones_ventas;
    }

    public void setPanel_botones_ventas(JPanel panel_botones_ventas) {
        this.panel_botones_ventas = panel_botones_ventas;
    }

    public TitledBorder getBorde_productos() {
        return borde_productos;
    }

    public void setBorde_productos(TitledBorder borde_productos) {
        this.borde_productos = borde_productos;
    }

    public JButton getBoton_alta_venta() {
        return boton_alta_venta;
    }

    public void setBoton_alta_venta(JButton boton_alta_venta) {
        this.boton_alta_venta = boton_alta_venta;
    }

    public JButton getBoton_devolver_producto() {
        return boton_devolver_producto;
    }

    public void setBoton_devolver_producto(JButton boton_devolver_producto) {
        this.boton_devolver_producto = boton_devolver_producto;
    }

    public JButton getBoton_mostrar_venta() {
        return boton_mostrar_venta;
    }

    public void setBoton_mostrar_venta(JButton boton_mostrar_venta) {
        this.boton_mostrar_venta = boton_mostrar_venta;
    }

    public JButton getBoton_mostrar_lista_ventas() {
        return boton_mostrar_lista_ventas;
    }

    public void setBoton_mostrar_lista_ventas(JButton boton_mostrar_lista_ventas) {
        this.boton_mostrar_lista_ventas = boton_mostrar_lista_ventas;
    }
    
    
    
}
