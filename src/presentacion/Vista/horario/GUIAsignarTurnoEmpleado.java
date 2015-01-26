/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.horario;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import negocio.turnos.Turno;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Eventos.EventoNegocio;


public class GUIAsignarTurnoEmpleado extends JFrame{
    
    JPanel panelSuperior = new JPanel();     
    JPanel panelBotones = new JPanel(new GridLayout(1,2,5,5));

    JTextField text_turno = new JTextField("");
    JTextField text_empleado = new JTextField("");

    JLabel label_turno = new JLabel("ID del Turno",JLabel.CENTER);
    JLabel label_empleado = new JLabel("ID del Empleado",JLabel.CENTER);


    JButton boton_ok = new JButton("Aceptar");
    JButton boton_cancelar = new JButton("Cancelar");
    
    
    
    public GUIAsignarTurnoEmpleado(){
        
        this.setTitle("Asignar Turno a un Empleado");
	setBounds(100, 100, 400, 300);
        this.setLocationRelativeTo(null);
        
        this.setLayout(new BorderLayout());

        panelSuperior.setLayout(new GridLayout(2,2));

        //añadimos el Jlabel y el Jtextfield para el Nombre
        panelSuperior.add(label_turno);
        panelSuperior.add(text_turno);
        
        //añadimos el Jlabel y el Jtextfield para la descripción
        panelSuperior.add(label_empleado);
        panelSuperior.add(text_empleado);
       
        
        //añadimos el boton Aceptar y Cancelar al panelBotones
        panelBotones.add(boton_ok);
        panelBotones.add(boton_cancelar);

        //añadimos a este panel AltaDepartamento cada panel independiente
        this.add(panelSuperior,BorderLayout.NORTH);	
        this.add(panelBotones,BorderLayout.SOUTH);
        
         boton_ok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               
                ArrayList<Object> datos = new ArrayList<Object>();
                datos.add(text_empleado.getText());
                datos.add(text_turno.getText());
               Controlador.getInstance().accion(EventoNegocio.ASIGNAR_TURNO_EMPLEADO, datos);
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
    
    //getters y setters
    
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

    public JTextField getText_turno() {
        return text_turno;
    }

    public void setText_turno(JTextField text_turno) {
        this.text_turno = text_turno;
    }

    public JTextField getText_empleado() {
        return text_empleado;
    }

    public void setText_empleado(JTextField text_empleado) {
        this.text_empleado = text_empleado;
    }

    public JLabel getLabel_turno() {
        return label_turno;
    }

    public void setLabel_turno(JLabel label_turno) {
        this.label_turno = label_turno;
    }

    public JLabel getLabel_empleado() {
        return label_empleado;
    }

    public void setLabel_empleado(JLabel label_empleado) {
        this.label_empleado = label_empleado;
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
