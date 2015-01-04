/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.cliente;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import negocio.cliente.TCliente;
import negocio.cliente.TClienteNormal;
import negocio.cliente.TClienteVip;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Eventos.EventoNegocio;


/**
 *
 * @author Ruben
 */
public class GUIAltaCliente extends JFrame{
    TCliente cliente = new TCliente();
    
    JPanel panelSuperior = new JPanel();
    JPanel panel_Fecha = new JPanel();
    JPanel panelRadios = new JPanel(new FlowLayout());
    JPanel panelBotones = new JPanel(new GridLayout(1,2,5,5));
    
    JTextField textNombre = new JTextField("");
    JTextField textApellidos = new JTextField("");
    JTextField textDNI = new JTextField("");
                
    JLabel labApellidos = new JLabel("Apellidos",JLabel.CENTER);
    JLabel labNombre = new JLabel("Nombre",JLabel.CENTER);
    JLabel labFechaNacimiento = new JLabel("Fecha Nacimiento",JLabel.CENTER);
    JLabel labDNI = new JLabel("DNI",JLabel.CENTER);
    
    JTextField fecha_dia = new JTextField(2);
    JTextField fecha_mes = new JTextField(2);
    JTextField fecha_anio = new JTextField(4);
    
    JRadioButton radioNormal = new JRadioButton("Normal",true);
    JRadioButton radioVIP = new JRadioButton("VIP");
    ButtonGroup radioDNI = new ButtonGroup();
    
    JButton boton_ok = new JButton("Aceptar");
    JButton boton_cancelar = new JButton("Cancelar");
    
    Date fecha = new Date(1,1,1);
    public GUIAltaCliente(){
        this.setTitle("Alta Cliente");
	setBounds(100, 100, 400, 300);
        this.setLocationRelativeTo(null);
        
            this.setLayout(new BorderLayout());
            
            panelSuperior.setLayout(new GridLayout(4,2));

            //añadimos los componentes del panel Fecha de nacimiento
            panel_Fecha.setLayout(new FlowLayout());
            panel_Fecha.add(fecha_dia);
            panel_Fecha.add(new JLabel("/"));
            panel_Fecha.add(fecha_mes);
            panel_Fecha.add(new JLabel("/"));
            panel_Fecha.add(fecha_anio); 

            //añadimos el Jlabel y el Jtextfield para el Nombre
            panelSuperior.add(labNombre);
            panelSuperior.add(textNombre);

            //añadimos el Jlabel y el Jtextfield para los Apellidos
            panelSuperior.add(labApellidos);
            panelSuperior.add(textApellidos);

            //añadimos el Jlabel y el Jtextfield para la Fecha de Nacimiento
            panelSuperior.add(labFechaNacimiento);
            panelSuperior.add(panel_Fecha);

            //añadimos los radiobuttons al panelRadios para indicar si es cliente es Normal o VIP
            panelRadios.add(radioNormal);
            panelRadios.add(radioVIP);

            //los radiobuttons se encuentran dentro de un ButtonGroup
            radioDNI.add(radioNormal);
            radioDNI.add(radioVIP);

            //añadimos el Jlabel y el Jtextfield para el DNI del cliente
            panelSuperior.add(labDNI);
            panelSuperior.add(textDNI);

            //añadimos los botones aceptar y cancelar al panelBotones
            panelBotones.add(boton_ok);
            panelBotones.add(boton_cancelar);
            
            //Añadimos el actionlistener
            boton_ok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cliente = null;
                if (radioNormal.isSelected())
                {
                    TClienteNormal temp = new TClienteNormal();
                    temp.setQuierevip(false);
                    cliente = temp;
                }
                else
                {
                    TClienteVip temp = new TClienteVip();
                    temp.setFinanciacion((float) 0.0);
                    cliente = temp;
                }
                    cliente.setDNI(textDNI.getText());
                    cliente.setNombre(textNombre.getText());
                    cliente.setApellidos(textApellidos.getText());
                    cliente.setFechaNacimiento(fecha_dia.getText()+"/"+fecha_mes.getText()+"/"+fecha_anio.getText());
                    
                    Controlador.getInstance().accion(EventoNegocio.ALTA_CLIENTE, cliente);
            }
        });
            boton_cancelar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                dispose();
                }
            });
            //añadimos a este panel AltaCliente cada panel independiente
            this.add(panelRadios, BorderLayout.CENTER);
            this.add(panelSuperior,BorderLayout.NORTH);	
            this.add(panelBotones,BorderLayout.SOUTH);

         //   this.setBorder(new TitledBorder(new TitledBorder(""), "Alta Cliente", 
          //                  TitledBorder.CENTER, TitledBorder.TOP ));		


            this.setVisible(true);
            
            
	}
    
    

    //Getters y setters
    public void setRadioVIP(JRadioButton radioVIP) {    
        this.radioVIP = radioVIP;
    }

    public JPanel getPanelSuperior() {
        return panelSuperior;
    }

    public void setPanelSuperior(JPanel panelSuperior) {
        this.panelSuperior = panelSuperior;
    }

    public JPanel getPanel_Fecha() {
        return panel_Fecha;
    }

    public void setPanel_Fecha(JPanel panel_Fecha) {
        this.panel_Fecha = panel_Fecha;
    }

    public JPanel getPanelRadios() {
        return panelRadios;
    }

    public void setPanelRadios(JPanel panelRadios) {
        this.panelRadios = panelRadios;
    }

    public JPanel getPanelBotones() {
        return panelBotones;
    }

    public void setPanelBotones(JPanel panelBotones) {
        this.panelBotones = panelBotones;
    }

    public JLabel getLabApellidos() {
        return labApellidos;
    }

    public void setLabApellidos(JLabel labApellidos) {
        this.labApellidos = labApellidos;
    }

    public JLabel getLabNombre() {
        return labNombre;
    }

    public void setLabNombre(JLabel labNombre) {
        this.labNombre = labNombre;
    }

    public JLabel getLabFechaNacimiento() {
        return labFechaNacimiento;
    }

    public void setLabFechaNacimiento(JLabel labFechaNacimiento) {
        this.labFechaNacimiento = labFechaNacimiento;
    }

    public JLabel getLabDNI() {
        return labDNI;
    }

    public void setLabDNI(JLabel labDNI) {
        this.labDNI = labDNI;
    }

    public JTextField getFecha_dia() {
        return fecha_dia;
    }

    public void setFecha_dia(JTextField fecha_dia) {
        this.fecha_dia = fecha_dia;
    }

    public JTextField getFecha_mes() {
        return fecha_mes;
    }

    public void setFecha_mes(JTextField fecha_mes) {
        this.fecha_mes = fecha_mes;
    }

    public JTextField getFecha_anio() {
        return fecha_anio;
    }

    public void setFecha_anio(JTextField fecha_anio) {
        this.fecha_anio = fecha_anio;
    }

    public ButtonGroup getRadioDNI() {
        return radioDNI;
    }

    public void setRadioDNI(ButtonGroup radioDNI) {
        this.radioDNI = radioDNI;
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
    public JTextField getTextNombre() {
        return textNombre;
    }

    public void setTextNombre(JTextField textNombre) {
        this.textNombre = textNombre;
    }

    public JTextField getTextApellidos() {
        return textApellidos;
    }

    public void setTextApellidos(JTextField textApellidos) {
        this.textApellidos = textApellidos;
    }

    public JTextField getTextDNI() {
        return textDNI;
    }

    public void setTextDNI(JTextField textDNI) {
        this.textDNI = textDNI;
    }

    public JRadioButton getRadioNormal() {
        return radioNormal;
    }

    public void setRadioNormal(JRadioButton radioNormal) {
        this.radioNormal = radioNormal;
    }

    public JRadioButton getRadioVIP() {
        return radioVIP;
    }

    
    }   
    

