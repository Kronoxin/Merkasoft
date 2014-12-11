/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.producto;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Ruben
 */
public class GUIBajaProducto extends JFrame{
    
        JTextField textID = new JTextField("");

        JPanel panelSuperior = new JPanel(new GridLayout(1,2));
        JPanel panelBotones = new JPanel(new GridLayout(1,2,10,10));

        JLabel labID = new JLabel("ID del Producto",JLabel.CENTER);

        JButton boton_ok = new JButton("Aceptar");
        JButton boton_cancelar = new JButton("Cancelar");

            
            
    public GUIBajaProducto(){
        this.setTitle("Baja Producto");
	setBounds(100, 100, 400, 300);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        //añadimos el Jlabel y el TextField del ID del producto al panelSuperior
        panelSuperior.add(labID);
        panelSuperior.add(textID);

        //añadimos el boton Aceptar y cancelar al panelBotones
        panelBotones.add(boton_ok);
        panelBotones.add(boton_cancelar);
        
        //añadimos los paneles individuales al de la clase
        this.add(panelSuperior,BorderLayout.NORTH);
        this.add(panelBotones,BorderLayout.SOUTH);
      //  this.setBorder(new TitledBorder(new TitledBorder(""), "Baja Producto", TitledBorder.CENTER, TitledBorder.TOP ));	

        this.setVisible(true);
        
        
    }
    
    //getters y setters

    public JTextField getTextID() {
        return textID;
    }

    public void setTextID(JTextField textID) {
        this.textID = textID;
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

    public JLabel getLabID() {
        return labID;
    }

    public void setLabID(JLabel labID) {
        this.labID = labID;
    }

    public JButton getBoton_ok() {
        return boton_ok;
    }

    public void setBoton_ok(JButton boton_ok) {
        this.boton_ok = boton_ok;
    }

    public JButton getBoton_cancelar() {
        return boton_cancelar;
    }

    public void setBoton_cancelar(JButton boton_cancelar) {
        this.boton_cancelar = boton_cancelar;
    }
    
    
}
