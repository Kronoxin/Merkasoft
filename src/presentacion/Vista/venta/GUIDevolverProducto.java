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

/**
 *
 * @author Ruben
 */
public class GUIDevolverProducto extends JPanel{
    
    public GUIDevolverProducto(){
        
        this.setLayout(new BorderLayout());

		JPanel panelSuperior = new JPanel();
		panelSuperior.setLayout(new GridLayout(7,2));

		final JTextField text_id_producto = new JTextField("");
		final JTextField text_id_venta = new JTextField("");
		final JTextField text_cantidad = new JTextField("");
                
                JLabel label_id_venta = new JLabel("ID Venta",JLabel.CENTER);
		JButton boton_mostrar_ventas = new JButton("Mostrar Ventas");
		panelSuperior.add(label_id_venta);
		panelSuperior.add(text_id_venta);
		panelSuperior.add(boton_mostrar_ventas);
		panelSuperior.add(new JLabel());

		JLabel label_id_producto = new JLabel("ID Producto",JLabel.CENTER);
		JButton boton_mostrar_productos = new JButton("Mostrar Productos");
		panelSuperior.add(label_id_producto);
		panelSuperior.add(text_id_producto);
		panelSuperior.add(boton_mostrar_productos);
		panelSuperior.add(new JLabel());



		JLabel label_cantidad = new JLabel("Cantidad",JLabel.CENTER);
		panelSuperior.add(label_cantidad);
		panelSuperior.add(text_cantidad);


		this.add(panelSuperior,BorderLayout.NORTH);	



		JButton boton_devolver_producto = new JButton("Devolver Producto");

		JButton boton_continuar = new JButton("Devolver otro producto");

		JButton boton_cancelar = new JButton("Cancelar");

		JPanel panelBotones = new JPanel(new GridLayout(1,3,5,5));
		panelBotones.add(boton_devolver_producto);
		panelBotones.add(boton_continuar);
		panelBotones.add(boton_cancelar);

		this.add(panelBotones,BorderLayout.SOUTH);

		this.setBorder(new TitledBorder(new TitledBorder(""), "Devolver Producto/s de una Venta", TitledBorder.CENTER, TitledBorder.TOP ));		

		this.setVisible(true);
        
        
    }
    
    
}
