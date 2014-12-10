/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.producto;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Ruben
 */
public class GUIModificarProducto extends JPanel{
    
    public GUIModificarProducto(){
        
        this.setLayout(new BorderLayout());

        //Texfield para insertar el ID del producto
        final JTextField textID = new JTextField("");
        JLabel labID = new JLabel("ID del Producto",JLabel.CENTER);
        JButton boton_ok = new JButton("Aceptar");
        JButton boton_cancelar = new JButton("Cancelar");

        JPanel panelSuperior = new JPanel(new GridLayout(1,2));

        JPanel panelBotones = new JPanel(new GridLayout(1,2,10,10));
        
        //añadimos el JLabel y el JTextField al panel Superior
        panelSuperior.add(labID);
        panelSuperior.add(textID);

        //añadimos el boton de aceptar y cancelar al panel de botones
        panelBotones.add(boton_ok);
        panelBotones.add(boton_cancelar);

        this.add(panelSuperior,BorderLayout.NORTH);
        this.add(panelBotones,BorderLayout.SOUTH);
        this.setBorder(new TitledBorder(new TitledBorder(""), "Modificar Producto", TitledBorder.CENTER, TitledBorder.TOP ));	


        this.setVisible(true);
        
    }
    
}
