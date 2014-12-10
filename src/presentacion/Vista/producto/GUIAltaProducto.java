/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.producto;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Ruben
 */
public class GUIAltaProducto extends JPanel{
    
    public GUIAltaProducto(){
        
         this.setLayout(new BorderLayout());

		JPanel panelSuperior = new JPanel();
		panelSuperior.setLayout(new GridLayout(5,2));
                
                JPanel panelBotones = new JPanel(new GridLayout(1,2,5,5));

		final JTextField text_nombre = new JTextField("");
		final JTextField text_precio = new JTextField("");
		final JTextField text_descripcion = new JTextField("");
                final JTextField text_codigo_barras = new JTextField("");
                final JTextField text_stock = new JTextField("");
                
             
           

		JLabel label_nombre = new JLabel("Nombre",JLabel.CENTER);
                JLabel label_precio = new JLabel("Precio",JLabel.CENTER);
                JLabel label_descripcion = new JLabel("Descripción",JLabel.CENTER);
                JLabel label_codigo_barras = new JLabel("Cod Barras",JLabel.CENTER);
                JLabel label_strock = new JLabel("Stock",JLabel.CENTER);
                
                JButton boton_ok = new JButton("Aceptar");
		JButton boton_cancelar = new JButton("Cancelar");

                
		panelSuperior.add(label_nombre);
		panelSuperior.add(text_nombre);

		panelSuperior.add(label_precio);
		panelSuperior.add(text_precio);
                text_precio.setText("0.00€");
                
                panelSuperior.add(label_descripcion);
                panelSuperior.add(text_descripcion);
                
                panelSuperior.add(label_codigo_barras);
                panelSuperior.add(text_codigo_barras);
                
                panelSuperior.add(label_strock);
                panelSuperior.add(text_stock);
                
                panelBotones.add(boton_ok);
		panelBotones.add(boton_cancelar);
                       

		this.add(panelSuperior,BorderLayout.NORTH);	


		this.add(panelBotones,BorderLayout.SOUTH);

		this.setBorder(new TitledBorder(new TitledBorder(""), "Alta Producto", 
				TitledBorder.CENTER, TitledBorder.TOP ));		

	
		this.setVisible(true);
        
        
        
    }
    
}
