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
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import negocio.FactoriaSA.FactoriaSA;
import negocio.departamentos.Departamento;
import negocio.empleados.Empleado;
import negocio.empleados.Supervisor;
import negocio.empleados.Trabajador;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Eventos.EventoNegocio;
import presentacion.Vista.ControlErrores;


public class GUIAltaEmpleado extends JFrame{
    
    Empleado empleado = new Empleado();
    Trabajador t = new Trabajador();
    Supervisor s = new Supervisor();
    
    JPanel panelSuperior = new JPanel();
    JPanel panelRadios = new JPanel(new GridLayout(4,2,5,5));
    JPanel panelBotones = new JPanel(new GridLayout(1,2,5,5));
    
    JTextField textNombre = new JTextField("");
    JTextField textApellidos = new JTextField("");
    JTextField textDNI = new JTextField("");
    JTextField textDireccion = new JTextField("");
    JTextField textDepartamento = new JTextField("");
    JTextField textSueldo = new JTextField("");
    JTextField textHoras = new JTextField("");
    JTextField textProductividad = new JTextField("");
    JTextField textOculto1 = new JTextField("");
    JTextField textOculto2 = new JTextField("");
                
    JLabel labApellidos = new JLabel("Apellidos",JLabel.CENTER);
    JLabel labNombre = new JLabel("Nombre",JLabel.CENTER);
    JLabel labDNI = new JLabel("DNI",JLabel.CENTER);
    JLabel labDireccion = new JLabel("Direccion",JLabel.CENTER);
    JLabel labDepartamento = new JLabel("Departamento",JLabel.CENTER);
    JLabel labSueldo = new JLabel("Sueldo / horas",JLabel.CENTER);
    JLabel labHoras = new JLabel("Horas trabajadas", JLabel.LEFT);
    JLabel labProductividad = new JLabel("Factor de productividad", JLabel.LEFT);
    
    
    
    
    JRadioButton radioSupervisor = new JRadioButton("Supervisor",true);
    JRadioButton radioTrabajador = new JRadioButton("Trabajador");
    ButtonGroup grupoRadios = new ButtonGroup();
    
    JButton boton_ok = new JButton("Aceptar");
    JButton boton_cancelar = new JButton("Cancelar");
    
    JComboBox combos;
		
    
    public GUIAltaEmpleado(){
        final ControlErrores control=new ControlErrores();
        this.setTitle("Alta Empleado");
	setBounds(100, 100, 500, 400);
        this.setLocationRelativeTo(null);
        
            this.setLayout(new BorderLayout());
            
            ArrayList<Departamento> depts = FactoriaSA.obtenerInstancia().generaSADepartamento().mostrarListaDepartamentos();
            ArrayList<String> departments = new ArrayList<>();
            for (int i = 0; i < depts.size(); i++)
            {
                if (depts.get(i).isDisponible())
                    departments.add(depts.get(i).getNombre());
            }
            combos = new JComboBox(departments.toArray());
            
            panelSuperior.setLayout(new GridLayout(8,2));



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
            //panelSuperior.add(textDepartamento);
            //para lineas futuras, se puede poner el comboBox
            panelSuperior.add(combos);
            

            
             //añadimos el Jlabel y el Jtextfield para el sueldo
            panelSuperior.add(labSueldo);
            panelSuperior.add(textSueldo);
            textSueldo.setText("1000");
  
            //añadimos los radiobuttons al panelRadios para indicar si es empleado es Supervisor o Trabajador
            panelRadios.add(radioTrabajador);
            panelRadios.add(radioSupervisor);

            //los radiobuttons se encuentran dentro de un ButtonGroup
            grupoRadios.add(radioTrabajador);
            grupoRadios.add(radioSupervisor);
            
            //Añadimos el campo de especialidad
            panelRadios.add(labProductividad);
            panelRadios.add(textProductividad);
            panelRadios.add(labHoras);
            panelRadios.add(textHoras);
            labHoras.setVisible(false);
            textHoras.setVisible(false);
            // Añadimos cajas de texto ocultas para cuadrar mejor el espacio
            panelRadios.add(textOculto1);
            panelRadios.add(textOculto2);
            textOculto1.setVisible(false);
            textOculto2.setVisible(false);
            



            //añadimos los botones aceptar y cancelar al panelBotones
            panelBotones.add(boton_ok);
            panelBotones.add(boton_cancelar);
            
            //Añadimos actionlintener de los botones
            radioTrabajador.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                labProductividad.setVisible(false);
                textProductividad.setVisible(false);
                labHoras.setVisible(true);
                textHoras.setVisible(true);                
            }
        });
            
            radioSupervisor.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                labHoras.setVisible(false);
                textHoras.setVisible(false); 
                labProductividad.setVisible(true);
                textProductividad.setVisible(true);
            }
        });
            
            
            
            //Añadimos el actionlistener
            boton_ok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                
                
                if (radioTrabajador.isSelected())
                {
                    
                    ArrayList<Departamento> depts2 = FactoriaSA.obtenerInstancia().generaSADepartamento().mostrarListaDepartamentos();
                    t.setDni(textDNI.getText());
                    t.setNombre(textNombre.getText());
                    t.setApellidos(textApellidos.getText());
                    t.setDireccion(textDireccion.getText());
                    Departamento dummy = depts2.get(combos.getSelectedIndex());
                    t.setDepartamento(dummy);
                    t.setSueldo(((double)(Double.parseDouble(textSueldo.getText()))));
                    t.setTipo(radioTrabajador.getText());                    
                    t.setDisponible(true);
                    t.setHoras_trabajadas((double) Double.parseDouble(textHoras.getText()));
                    if(control.controlErroresEmpleado(t))
                    {
                        Controlador.getInstance().accion(EventoNegocio.ALTA_EMPLEADO, t);
                    }
                    else
                    {
                        System.out.println("Formato erroneo o falta de datos");
                         Controlador.getInstance().accion(EventoNegocio.MOSTRAR_INFORMACION_ERROR, null);
                    }
                }
                else
                {
                    ArrayList<Departamento> depts2 = FactoriaSA.obtenerInstancia().generaSADepartamento().mostrarListaDepartamentos();
                    s.setDni(textDNI.getText());
                    s.setNombre(textNombre.getText());
                    s.setApellidos(textApellidos.getText());
                    s.setDireccion(textDireccion.getText());
                    Departamento dummy = depts2.get(combos.getSelectedIndex());
                    s.setDepartamento(dummy);
                    s.setSueldo(((double)(Double.parseDouble(textSueldo.getText()))));
                    s.setTipo(radioSupervisor.getText());                    
                    s.setDisponible(true);
                    s.setFactor_productividad((double) Double.parseDouble(textProductividad.getText()));
                    if(control.controlErroresEmpleado(s))
                    {
                        Controlador.getInstance().accion(EventoNegocio.ALTA_EMPLEADO, s);
                    }
                    else
                    {
                        System.out.println("Formato erroneo o falta de datos");
                        Controlador.getInstance().accion(EventoNegocio.MOSTRAR_INFORMACION_ERROR, null);
                    }
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

    public ButtonGroup getGrupoRadios() {
        return grupoRadios;
    }

    public void setGrupoRadios(ButtonGroup grupoRadios) {
        this.grupoRadios = grupoRadios;
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
