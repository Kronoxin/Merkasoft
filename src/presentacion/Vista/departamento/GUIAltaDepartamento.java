/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.departamento;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import negocio.departamentos.Departamento;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Eventos.EventoNegocio;

/**
 *
 * @author Ruben
 */
public class GUIAltaDepartamento extends JFrame{
    Departamento departamento = new Departamento();
    
    JPanel panelSuperior = new JPanel();     
    JPanel panelBotones = new JPanel(new GridLayout(1,2,5,5));

    JTextField text_nombre = new JTextField("");
    JTextField text_descripcion = new JTextField("");

    JLabel label_nombre = new JLabel("Nombre",JLabel.CENTER);
    JLabel label_descripcion = new JLabel("Descripción",JLabel.CENTER);


    JButton boton_ok = new JButton("Aceptar");
    JButton boton_cancelar = new JButton("Cancelar");
    
    public GUIAltaDepartamento(){
        this.setTitle("Alta Departamento");
	setBounds(100, 100, 400, 300);
        this.setLocationRelativeTo(null);
        
        this.setLayout(new BorderLayout());

        panelSuperior.setLayout(new GridLayout(2,2));

        //añadimos el Jlabel y el Jtextfield para el Nombre
        panelSuperior.add(label_nombre);
        panelSuperior.add(text_nombre);
        
        //añadimos el Jlabel y el Jtextfield para la descripción
        panelSuperior.add(label_descripcion);
        panelSuperior.add(text_descripcion);
       
        
        //añadimos el boton Aceptar y Cancelar al panelBotones
        panelBotones.add(boton_ok);
        panelBotones.add(boton_cancelar);

        //añadimos a este panel AltaDepartamento cada panel independiente
        this.add(panelSuperior,BorderLayout.NORTH);	
        this.add(panelBotones,BorderLayout.SOUTH);

        boton_ok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                departamento.setNombre(text_nombre.getText());
                departamento.setDescripcion(text_descripcion.getText());
                departamento.setDisponible(true);

               Controlador.getInstance().accion(EventoNegocio.ALTA_DEPARTAMENTO, departamento);
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

    public JTextField getText_nombre() {
        return text_nombre;
    }

    public void setText_nombre(JTextField text_nombre) {
        this.text_nombre = text_nombre;
    }

    public JTextField getText_descripcion() {
        return text_descripcion;
    }

    public void setText_descripcion(JTextField text_descripcion) {
        this.text_descripcion = text_descripcion;
    }

    public JLabel getLabel_nombre() {
        return label_nombre;
    }

    public void setLabel_nombre(JLabel label_nombre) {
        this.label_nombre = label_nombre;
    }

    public JLabel getLabel_descripcion() {
        return label_descripcion;
    }

    public void setLabel_descripcion(JLabel label_descripcion) {
        this.label_descripcion = label_descripcion;
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
