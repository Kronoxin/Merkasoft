/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.venta;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;


public class GUIAltaVenta extends JFrame{
    
        JPanel panelSuperior = new JPanel();
        JPanel panelBotones = new JPanel(new GridLayout(1,3,5,5));

        JTextField text_id_producto = new JTextField("");
        JTextField text_id_cliente = new JTextField("");
        JTextField text_cantidad = new JTextField("");

        JLabel label_id_cliente = new JLabel("ID Cliente",JLabel.CENTER);
        JButton boton_mostrar_clientes = new JButton("Mostrar Clientes");
        JLabel label_id_producto = new JLabel("ID Producto",JLabel.CENTER);
        JButton boton_mostrar_productos = new JButton("Mostrar Productos");

        JButton boton_FinalizarVenta = new JButton("Finalizar Venta");
        JButton boton_Continuar = new JButton("Añadir más productos");
        JButton boton_Cancelar = new JButton("Cancelar");

        JLabel label_cantidad = new JLabel("Cantidad",JLabel.CENTER);

    public GUIAltaVenta(){
        this.setTitle("Alta Venta");
	setBounds(100, 100, 400, 300);
        this.setLocationRelativeTo(null);
        
        this.setLayout(new BorderLayout());
        panelSuperior.setLayout(new GridLayout(7,2));

        panelSuperior.add(label_id_cliente);
        panelSuperior.add(text_id_cliente);
        panelSuperior.add(boton_mostrar_clientes);
        panelSuperior.add(new JLabel());


        panelSuperior.add(label_id_producto);
        panelSuperior.add(text_id_producto);
        panelSuperior.add(boton_mostrar_productos);
        panelSuperior.add(new JLabel());

        panelSuperior.add(label_cantidad);
        panelSuperior.add(text_cantidad);


        panelBotones.add(boton_FinalizarVenta);
        panelBotones.add(boton_Continuar);
        panelBotones.add(boton_Cancelar);
        
        this.add(panelSuperior,BorderLayout.NORTH);
        this.add(panelBotones,BorderLayout.SOUTH);
//        this.setBorder(new TitledBorder(new TitledBorder(""), "Nueva Venta", TitledBorder.CENTER, TitledBorder.TOP ));		

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

    public JTextField getText_id_cliente() {
        return text_id_cliente;
    }

    public void setText_id_cliente(JTextField text_id_cliente) {
        this.text_id_cliente = text_id_cliente;
    }

    public JTextField getText_cantidad() {
        return text_cantidad;
    }

    public void setText_cantidad(JTextField text_cantidad) {
        this.text_cantidad = text_cantidad;
    }

    public JLabel getLabel_id_cliente() {
        return label_id_cliente;
    }

    public void setLabel_id_cliente(JLabel label_id_cliente) {
        this.label_id_cliente = label_id_cliente;
    }

    public JButton getBoton_mostrar_clientes() {
        return boton_mostrar_clientes;
    }

    public void setBoton_mostrar_clientes(JButton boton_mostrar_clientes) {
        this.boton_mostrar_clientes = boton_mostrar_clientes;
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

    public JButton getBoton_FinalizarVenta() {
        return boton_FinalizarVenta;
    }

    public void setBoton_FinalizarVenta(JButton boton_FinalizarVenta) {
        this.boton_FinalizarVenta = boton_FinalizarVenta;
    }

    public JButton getBoton_Continuar() {
        return boton_Continuar;
    }

    public void setBoton_Continuar(JButton boton_Continuar) {
        this.boton_Continuar = boton_Continuar;
    }

    public JButton getBoton_Cancelar() {
        return boton_Cancelar;
    }

    public void setBoton_Cancelar(JButton boton_Cancelar) {
        this.boton_Cancelar = boton_Cancelar;
    }

    public JLabel getLabel_cantidad() {
        return label_cantidad;
    }

    public void setLabel_cantidad(JLabel label_cantidad) {
        this.label_cantidad = label_cantidad;
    }
    
    
    
}
