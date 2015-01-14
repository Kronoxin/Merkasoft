/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.turno;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Ruben
 */
public class GUIAltaTurno extends JFrame{
    
     
    JPanel panelSuperior = new JPanel();     
    JPanel panelBotones = new JPanel(new GridLayout(1,2,5,5));

    JTextField text_nombre = new JTextField("");
    JTextField text_tipo = new JTextField("");
    JTextField text_horaEntrada = new JTextField("");
    JTextField text_horaSalida = new JTextField("");

    JLabel label_nombre = new JLabel("Nombre",JLabel.CENTER);
    JLabel label_tipo = new JLabel("Tipo",JLabel.CENTER);
    JLabel label_horaEntrada = new JLabel("Hora de Entrada",JLabel.CENTER);
    JLabel label_horaSalida = new JLabel("Hora de Salida",JLabel.CENTER);


    JButton boton_ok = new JButton("Aceptar");
    JButton boton_cancelar = new JButton("Cancelar");
    
    public GUIAltaTurno(){
        this.setTitle("Alta Turno");
	setBounds(100, 100, 400, 300);
        this.setLocationRelativeTo(null);
        
        this.setLayout(new BorderLayout());

        panelSuperior.setLayout(new GridLayout(4,2));

        //añadimos el Jlabel y el Jtextfield para el Nombre
        panelSuperior.add(label_nombre);
        panelSuperior.add(text_nombre);
        
        //añadimos el Jlabel y el Jtextfield para la descripción
        panelSuperior.add(label_tipo);
        panelSuperior.add(text_tipo);
        
        //añadimos el Jlabel y el Jtextfield para la hora de entrada
        panelSuperior.add(label_horaEntrada);
        panelSuperior.add(text_horaEntrada);
        
        //añadimos el Jlabel y el Jtextfield para la hora de salida
        panelSuperior.add(label_horaSalida);
        panelSuperior.add(text_horaSalida);
       
        
        //añadimos el boton Aceptar y Cancelar al panelBotones
        panelBotones.add(boton_ok);
        panelBotones.add(boton_cancelar);

        //añadimos a este panel AltaTurno cada panel independiente
        this.add(panelSuperior,BorderLayout.NORTH);	
        this.add(panelBotones,BorderLayout.SOUTH);

        boton_ok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
           //     turno.setNombre(text_nombre.getText());
           //     turno.setTipo(text_tipo.getText());
         

               
                
            //    Controlador.getInstance().accion(EventoNegocio.ALTA_DEPARTAMENTO, turno);
            }
        });
        
        
        boton_cancelar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        this.setVisible(true);

    }
    
    //setters y getters

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

    public JTextField getText_nombre() {
        return text_nombre;
    }

    public void setText_nombre(JTextField text_nombre) {
        this.text_nombre = text_nombre;
    }

    public JTextField getText_tipo() {
        return text_tipo;
    }

    public void setText_tipo(JTextField text_tipo) {
        this.text_tipo = text_tipo;
    }

    public JTextField getText_horaEntrada() {
        return text_horaEntrada;
    }

    public void setText_horaEntrada(JTextField text_horaEntrada) {
        this.text_horaEntrada = text_horaEntrada;
    }

    public JTextField getText_horaSalida() {
        return text_horaSalida;
    }

    public void setText_horaSalida(JTextField text_horaSalida) {
        this.text_horaSalida = text_horaSalida;
    }

    public JLabel getLabel_nombre() {
        return label_nombre;
    }

    public void setLabel_nombre(JLabel label_nombre) {
        this.label_nombre = label_nombre;
    }

    public JLabel getLabel_tipo() {
        return label_tipo;
    }

    public void setLabel_tipo(JLabel label_tipo) {
        this.label_tipo = label_tipo;
    }

    public JLabel getLabel_horaEntrada() {
        return label_horaEntrada;
    }

    public void setLabel_horaEntrada(JLabel label_horaEntrada) {
        this.label_horaEntrada = label_horaEntrada;
    }

    public JLabel getLabel_horaSalida() {
        return label_horaSalida;
    }

    public void setLabel_horaSalida(JLabel label_horaSalida) {
        this.label_horaSalida = label_horaSalida;
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
