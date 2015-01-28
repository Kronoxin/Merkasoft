/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.empleado;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Eventos.EventoNegocio;
import presentacion.Vista.ControlErrores;


public class GUIBajaEmpleado extends JFrame{
    final ControlErrores control=new ControlErrores();
     JTextField textID = new JTextField("");
    
    JPanel panelSuperior = new JPanel(new GridLayout(1,2));
    JPanel panelBotones = new JPanel(new GridLayout(1,2,10,10));
    
    JLabel labID = new JLabel("ID del Cliente",JLabel.CENTER);
    
    JButton boton_ok = new JButton("Aceptar");
    JButton boton_cancelar = new JButton("Cancelar");
    
    public GUIBajaEmpleado(){
         this.setTitle("Baja empleado");
    	setBounds(100, 100, 400, 300);
        this.setLocationRelativeTo(null);
        
        
        this.setLayout(new BorderLayout());
        
        //añadimos el Jlabel y el Jtextfield para el ID del empleado al panelSuperior
        panelSuperior.add(labID);
        panelSuperior.add(textID);

        //añadimos los botones aceptar y cancelar al panelBotones
        panelBotones.add(boton_ok);
        panelBotones.add(boton_cancelar);

        //añadimos a este panel Bajaempleado cada panel independiente de la clase
        this.add(panelSuperior,BorderLayout.NORTH);
        this.add(panelBotones,BorderLayout.SOUTH);
     //   this.setBorder(new TitledBorder(new TitledBorder(""), "Baja empleado", TitledBorder.CENTER, TitledBorder.TOP ));	
        //actionlistener
        boton_ok.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
              textID.getText();
            if(control.controlErroresID(textID.getText()))
            {
                Controlador.getInstance().accion(EventoNegocio.BAJA_EMPLEADO, textID.getText());
            }
            else
            {
                System.out.println("Formato erroneo o falta de datos");
                Controlador.getInstance().accion(EventoNegocio.MOSTRAR_INFORMACION_ERROR, null);
            }
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
      //  this.setSize(300, 200);
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
