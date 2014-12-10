/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.venta;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Ruben
 */
public class GUIAltaVenta extends JPanel{

    public GUIAltaVenta(){
        
        this.setLayout(new BorderLayout());

		JPanel panelSuperior = new JPanel();
		panelSuperior.setLayout(new GridLayout(7,2));

		final JTextField text_id_producto = new JTextField("");
		final JTextField text_id_cliente = new JTextField("");
		final JTextField text_cantidad = new JTextField("");
                
                JLabel label_id_cliente = new JLabel("ID Cliente",JLabel.CENTER);
		JButton boton_mostrar_clientes = new JButton("Mostrar Clientes");
		panelSuperior.add(label_id_cliente);
		panelSuperior.add(text_id_cliente);
		panelSuperior.add(boton_mostrar_clientes);
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



		JButton butFinalizarVenta = new JButton("Finalizar Venta");

		JButton butContinuar = new JButton("Añadir más productos");

		JButton butCancelar = new JButton("Cancelar");

		JPanel panelBotones = new JPanel(new GridLayout(1,3,5,5));
		panelBotones.add(butFinalizarVenta);
		panelBotones.add(butContinuar);
		panelBotones.add(butCancelar);

		this.add(panelBotones,BorderLayout.SOUTH);

		this.setBorder(new TitledBorder(new TitledBorder(""), "Nueva Venta", TitledBorder.CENTER, TitledBorder.TOP ));		

		this.setVisible(true);
        
    }
    
}
