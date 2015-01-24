/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.venta;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.TitledBorder;


public class GUIDevolverProducto extends JFrame{
    	JPanel panelSuperior = new JPanel();
        JPanel panelBotones = new JPanel(new GridLayout(1,3,5,5));
        

        JTextField text_id_producto = new JTextField("");
        JTextField text_id_venta = new JTextField("");
        JTextField text_cantidad = new JTextField("");

        JLabel label_id_venta = new JLabel("ID Venta",JLabel.CENTER);
        JButton boton_mostrar_ventas = new JButton("Mostrar Ventas");
        JLabel label_id_producto = new JLabel("ID Producto",JLabel.CENTER);
        JButton boton_mostrar_productos = new JButton("Mostrar Productos");
        JLabel label_cantidad = new JLabel("Cantidad",JLabel.CENTER);
        
        JButton boton_devolver_producto = new JButton("Devolver Producto");
	JButton boton_continuar = new JButton("Devolver otro producto");
        JButton boton_cancelar = new JButton("Cancelar");

		
    
    public GUIDevolverProducto(){
        this.setTitle("Devolver Producto");
	setBounds(100, 100, 400, 300);
        this.setLocationRelativeTo(null);
        
        this.setLayout(new BorderLayout());
        panelSuperior.setLayout(new GridLayout(7,2));

	
        panelSuperior.add(label_id_venta);
        panelSuperior.add(text_id_venta);
        panelSuperior.add(boton_mostrar_ventas);
        panelSuperior.add(new JLabel());


        panelSuperior.add(label_id_producto);
        panelSuperior.add(text_id_producto);
        panelSuperior.add(boton_mostrar_productos);
        panelSuperior.add(new JLabel());

        panelSuperior.add(label_cantidad);
        panelSuperior.add(text_cantidad);
        
        panelBotones.add(boton_devolver_producto);
        panelBotones.add(boton_continuar);
        panelBotones.add(boton_cancelar);

        this.add(panelSuperior,BorderLayout.NORTH);
        this.add(panelBotones,BorderLayout.SOUTH);
 //       this.setBorder(new TitledBorder(new TitledBorder(""), "Devolver Producto/s de una Venta", TitledBorder.CENTER, TitledBorder.TOP ));		

        this.setVisible(true);
        
        
    }

    public JPanel getPanelSuperior() {
        return panelSuperior;
    }

    public void setPanelSuperior(JPanel panelSuperior) {
        this.panelSuperior = panelSuperior;
    }

    public JPanel getPanelBotones() {
        return panelBotones;
    }

    public void setPanelBotones(JPanel panelBotones) {
        this.panelBotones = panelBotones;
    }

    public JTextField getText_id_producto() {
        return text_id_producto;
    }

    public void setText_id_producto(JTextField text_id_producto) {
        this.text_id_producto = text_id_producto;
    }

    public JTextField getText_id_venta() {
        return text_id_venta;
    }

    public void setText_id_venta(JTextField text_id_venta) {
        this.text_id_venta = text_id_venta;
    }

    public JTextField getText_cantidad() {
        return text_cantidad;
    }

    public void setText_cantidad(JTextField text_cantidad) {
        this.text_cantidad = text_cantidad;
    }

    public JLabel getLabel_id_venta() {
        return label_id_venta;
    }

    public void setLabel_id_venta(JLabel label_id_venta) {
        this.label_id_venta = label_id_venta;
    }

    public JButton getBoton_mostrar_ventas() {
        return boton_mostrar_ventas;
    }

    public void setBoton_mostrar_ventas(JButton boton_mostrar_ventas) {
        this.boton_mostrar_ventas = boton_mostrar_ventas;
    }

    public JLabel getLabel_id_producto() {
        return label_id_producto;
    }

    public void setLabel_id_producto(JLabel label_id_producto) {
        this.label_id_producto = label_id_producto;
    }

    public JButton getBoton_mostrar_productos() {
        return boton_mostrar_productos;
    }

    public void setBoton_mostrar_productos(JButton boton_mostrar_productos) {
        this.boton_mostrar_productos = boton_mostrar_productos;
    }

    public JLabel getLabel_cantidad() {
        return label_cantidad;
    }

    public void setLabel_cantidad(JLabel label_cantidad) {
        this.label_cantidad = label_cantidad;
    }

    public JButton getBoton_devolver_producto() {
        return boton_devolver_producto;
    }

    public void setBoton_devolver_producto(JButton boton_devolver_producto) {
        this.boton_devolver_producto = boton_devolver_producto;
    }

    public JButton getBoton_continuar() {
        return boton_continuar;
    }

    public void setBoton_continuar(JButton boton_continuar) {
        this.boton_continuar = boton_continuar;
    }

    public JButton getBoton_cancelar() {
        return boton_cancelar;
    }

    public void setBoton_cancelar(JButton boton_cancelar) {
        this.boton_cancelar = boton_cancelar;
    }
    
    
    
    
}
