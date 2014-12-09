/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.cliente;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Ruben
 */
public class GUIBajaCliente extends JPanel{
    
    public GUIBajaCliente(){
        
        
        this.setLayout(new BorderLayout());

		final JTextField textID = new JTextField("");

		JPanel panelSuperior = new JPanel(new GridLayout(1,2));

		JLabel labID = new JLabel("ID del Cliente",JLabel.CENTER);
		
		panelSuperior.add(labID);
		panelSuperior.add(textID);
		
		JButton boton_ok = new JButton("Aceptar");
		JButton boton_cancelar = new JButton("Cancelar");

		JPanel panelBotones = new JPanel(new GridLayout(1,2,10,10));
		panelBotones.add(boton_ok);
		panelBotones.add(boton_cancelar);

		this.add(panelSuperior,BorderLayout.NORTH);
		this.add(panelBotones,BorderLayout.SOUTH);
		this.setBorder(new TitledBorder(new TitledBorder(""), "Baja Cliente", TitledBorder.CENTER, TitledBorder.TOP ));	
	

		this.setVisible(true);
	}

}
            
    
