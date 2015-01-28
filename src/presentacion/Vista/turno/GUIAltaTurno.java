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
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import negocio.turnos.Turno;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Eventos.EventoNegocio;
import presentacion.Vista.ControlErrores;


public class GUIAltaTurno extends JFrame{
    
    final ControlErrores control=new ControlErrores();
    JPanel panelSuperior = new JPanel();     
    JPanel panelBotones = new JPanel(new GridLayout(1,2,5,5));

    JTextField text_nombre = new JTextField("");
    JTextField text_horaEntrada = new JTextField("");
    JTextField text_horaSalida = new JTextField("");

    JLabel label_nombre = new JLabel("Nombre",JLabel.CENTER);
    JLabel label_horaEntrada = new JLabel("Hora de Entrada",JLabel.CENTER);
    JLabel label_horaSalida = new JLabel("Hora de Salida",JLabel.CENTER);


    JButton boton_ok = new JButton("Aceptar");
    JButton boton_cancelar = new JButton("Cancelar");
    
    public GUIAltaTurno(){
        this.setTitle("Alta Turno");
	setBounds(100, 100, 400, 300);
        this.setLocationRelativeTo(null);
        
        this.setLayout(new BorderLayout());

        panelSuperior.setLayout(new GridLayout(3,2));

        //añadimos el Jlabel y el Jtextfield para el Nombre
        panelSuperior.add(label_nombre);
        panelSuperior.add(text_nombre);
        
        
        //añadimos el Jlabel y el Jtextfield para la hora de entrada
        panelSuperior.add(label_horaEntrada);
        panelSuperior.add(text_horaEntrada);
        text_horaEntrada.setText("00:00");
        text_horaEntrada.setToolTipText("hh:mm");
        label_horaEntrada.setToolTipText("hh:mm");
        
        //añadimos el Jlabel y el Jtextfield para la hora de salida
        panelSuperior.add(label_horaSalida);
        panelSuperior.add(text_horaSalida);
        text_horaSalida.setText("00:00");
        text_horaSalida.setToolTipText("hh:mm");
        label_horaSalida.setToolTipText("hh:mm");
       
        
        //añadimos el boton Aceptar y Cancelar al panelBotones
        panelBotones.add(boton_ok);
        panelBotones.add(boton_cancelar);

        //añadimos a este panel AltaTurno cada panel independiente
        this.add(panelSuperior,BorderLayout.NORTH);	
        this.add(panelBotones,BorderLayout.SOUTH);

        boton_ok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               Turno turno = new Turno(); 
               turno.setNombre(text_nombre.getText());
               turno.setDisponible(true);
               String[] tiempos = text_horaEntrada.getText().split(":");
               int hora_entrada = Integer.parseInt(tiempos[0]);
               int minuto_entrada = Integer.parseInt(tiempos[1]);               
               turno.setHoraEntrada(hora_entrada);
               turno.setMinutoEntrada(minuto_entrada);
               tiempos = text_horaSalida.getText().split(":");
               int hora_salida = Integer.parseInt(tiempos[0]);
               int minuto_salida = Integer.parseInt(tiempos[1]);
               turno.setHoraSalida(hora_salida);
               turno.setMinutoSalida(minuto_salida);
               if(control.controlErorresTurno(turno))
               {
                    Controlador.getInstance().accion(EventoNegocio.ALTA_TURNO, turno);
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
