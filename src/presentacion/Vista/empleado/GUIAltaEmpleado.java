/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.empleado;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import negocio.empleados.Empleado;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Eventos.EventoNegocio;


/**
 *
 * @author Ruben
 */
public class GUIAltaEmpleado extends JFrame{
    
    Empleado empleado = new Empleado();
    
    JPanel panelSuperior = new JPanel();
    JPanel panelRadios = new JPanel(new FlowLayout());
    JPanel panelBotones = new JPanel(new GridLayout(1,2,5,5));
    
    JTextField textNombre = new JTextField("");
    JTextField textApellidos = new JTextField("");
    JTextField textDNI = new JTextField("");
    JTextField textDireccion = new JTextField("");
    JTextField textDepartamento = new JTextField("");
    JTextField textSueldo = new JTextField("");
                
    JLabel labApellidos = new JLabel("Apellidos",JLabel.CENTER);
    JLabel labNombre = new JLabel("Nombre",JLabel.CENTER);
    JLabel labDNI = new JLabel("DNI",JLabel.CENTER);
    JLabel labDireccion = new JLabel("Direccion",JLabel.CENTER);
    JLabel labDepartamento = new JLabel("Departamento",JLabel.CENTER);
    JLabel labSueldo = new JLabel("Sueldo",JLabel.CENTER);
    
    
    
    JRadioButton radioSupervisor = new JRadioButton("Supervisor",true);
    JRadioButton radioTrabajador = new JRadioButton("Trabajador");
    ButtonGroup radioDNI = new ButtonGroup();
    
    JButton boton_ok = new JButton("Aceptar");
    JButton boton_cancelar = new JButton("Cancelar");
    
    JComboBox combos;
		
		
    
    public GUIAltaEmpleado(){
        this.setTitle("Alta Empleado");
	setBounds(100, 100, 400, 300);
        this.setLocationRelativeTo(null);
        
            this.setLayout(new BorderLayout());
            
            String[] departments = { "Departamento1", "Departamento2", "Departamento3",};
            combos = new JComboBox(departments);
            
            panelSuperior.setLayout(new GridLayout(6,2));



            //añadimos el Jlabel y el Jtextfield para el DNI del empleado
            panelSuperior.add(labDNI);
            panelSuperior.add(textDNI);
            
            //añadimos el Jlabel y el Jtextfield para el Nombre
            panelSuperior.add(labNombre);
            panelSuperior.add(textNombre);

            //añadimos el Jlabel y el Jtextfield para los Apellidos
            panelSuperior.add(labApellidos);
            panelSuperior.add(textApellidos);

            //añadimos el Jlabel y el Jtextfield para la Direccion
            panelSuperior.add(labDireccion);
            panelSuperior.add(textDireccion);
            
            panelSuperior.add(labDepartamento);
            panelSuperior.add(combos);
            

            
             //añadimos el Jlabel y el Jtextfield para el sueldo
            panelSuperior.add(labSueldo);
            panelSuperior.add(textSueldo);
            textSueldo.setText("1000");
                    

            //añadimos los radiobuttons al panelRadios para indicar si es empleado es Supervisor o Trabajador
            panelRadios.add(radioTrabajador);
            panelRadios.add(radioSupervisor);

            //los radiobuttons se encuentran dentro de un ButtonGroup
            radioDNI.add(radioTrabajador);
            radioDNI.add(radioSupervisor);
            



            //añadimos los botones aceptar y cancelar al panelBotones
            panelBotones.add(boton_ok);
            panelBotones.add(boton_cancelar);
            
            //Añadimos el actionlistener
            boton_ok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                empleado.setDni(textDNI.getText());
                empleado.setNombre(textNombre.getText());
                empleado.setApellidos(textApellidos.getText());
             //   empleado.setDepartamento(textDepartamento.getText());
              //  empleado.setSueldo(BigDecimal)textSueldo.getText());
                empleado.setDisponible(true);
                
                Controlador.getInstance().accion(EventoNegocio.ALTA_EMPLEADO, empleado);
            }
        });
            boton_cancelar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                dispose();
                }
            });
            //añadimos a este panel Altaempleado cada panel independiente
            
            this.add(panelRadios, BorderLayout.CENTER);
            this.add(panelSuperior,BorderLayout.NORTH);	
            this.add(panelBotones,BorderLayout.SOUTH);

         //   this.setBorder(new TitledBorder(new TitledBorder(""), "Alta empleado", 
          //                  TitledBorder.CENTER, TitledBorder.TOP ));		


            this.setVisible(true);
            
            
	}
    
 

    public JPanel getPanelSuperior() {
        return panelSuperior;
    }

    public void setPanelSuperior(JPanel panelSuperior) {
        this.panelSuperior = panelSuperior;
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

    public JTextField getTextDireccion() {
        return textDireccion;
    }

    public void setTextDireccion(JTextField textDireccion) {
        this.textDireccion = textDireccion;
    }

    public JTextField getTextDepartamento() {
        return textDepartamento;
    }

    public void setTextDepartamento(JTextField textDepartamento) {
        this.textDepartamento = textDepartamento;
    }

    public JTextField getTextSueldo() {
        return textSueldo;
    }

    public void setTextSueldo(JTextField textSueldo) {
        this.textSueldo = textSueldo;
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

    public JLabel getLabDNI() {
        return labDNI;
    }

    public void setLabDNI(JLabel labDNI) {
        this.labDNI = labDNI;
    }

    public JLabel getLabDireccion() {
        return labDireccion;
    }

    public void setLabDireccion(JLabel labDireccion) {
        this.labDireccion = labDireccion;
    }

    public JLabel getLabDepartamento() {
        return labDepartamento;
    }

    public void setLabDepartamento(JLabel labDepartamento) {
        this.labDepartamento = labDepartamento;
    }

    public JLabel getLabSueldo() {
        return labSueldo;
    }

    public void setLabSueldo(JLabel labSueldo) {
        this.labSueldo = labSueldo;
    }

    public JRadioButton getRadioSupervisor() {
        return radioSupervisor;
    }

    public void setRadioSupervisor(JRadioButton radioSupervisor) {
        this.radioSupervisor = radioSupervisor;
    }

    public JRadioButton getRadioTrabajador() {
        return radioTrabajador;
    }

    public void setRadioTrabajador(JRadioButton radioTrabajador) {
        this.radioTrabajador = radioTrabajador;
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

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public JComboBox getCombos() {
        return combos;
    }

    public void setCombos(JComboBox combos) {
        this.combos = combos;
    }


    
    
    
}
