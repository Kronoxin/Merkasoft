/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.cliente;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Eventos.EventoNegocio;


public class GUIModificarCliente extends JFrame{
    
    JTextField textID = new JTextField("");
    JLabel labID = new JLabel("ID del Cliente",JLabel.CENTER);
    JButton boton_ok = new JButton("Aceptar");
    JButton boton_cancelar = new JButton("Cancelar");

    JPanel panelSuperior = new JPanel(new GridLayout(1,2));

    JPanel panelBotones = new JPanel(new GridLayout(1,2,10,10));
    
    public GUIModificarCliente(){
        this.setName("Modificar Cliente");
	setBounds(100, 100, 400, 300);
        this.setLocationRelativeTo(null);
        
        this.setLayout(new BorderLayout());

        //añadimos el JLabel y el JTextField al panel Superior
        panelSuperior.add(labID);
        panelSuperior.add(textID);

        //añadimos el boton de aceptar y cancelar al panel de botones
        panelBotones.add(boton_ok);
        panelBotones.add(boton_cancelar);

        this.add(panelSuperior,BorderLayout.NORTH);
        this.add(panelBotones,BorderLayout.SOUTH);
    //    this.setBorder(new TitledBorder(new TitledBorder(""), "Modificar Cliente", TitledBorder.CENTER, TitledBorder.TOP ));	
    //Actionlisteners
        boton_ok.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                Controlador con = Controlador.getInstance();
                con.accion(EventoNegocio.GUI_ALTA_CLIENTE, textID.getText());
                }
            });
        boton_cancelar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                dispose();
                }
            });
        
        this.setVisible(true);
    }
    
    //getters y setters

    public JTextField getTextID() {
        return textID;
    }

    public void setTextID(JTextField textID) {
        this.textID = textID;
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
    
    
}
