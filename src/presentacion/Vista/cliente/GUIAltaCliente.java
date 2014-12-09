/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.cliente;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import presentacion.VentanaPrincipal;

/**
 *
 * @author Ruben
 */
public class GUIAltaCliente extends JPanel{
    
    public GUIAltaCliente(){
        
        
            this.setLayout(new BorderLayout());

		JPanel panelSuperior = new JPanel();
		panelSuperior.setLayout(new GridLayout(4,2));

		final JTextField textNombre = new JTextField("");
		final JTextField textApellidos = new JTextField("");
		final JTextField textDNI = new JTextField("");
                
             
               
                JPanel panel_Fecha = new JPanel();
                panel_Fecha.setLayout(new FlowLayout());
                panel_Fecha.add(new JTextField(2));
                panel_Fecha.add(new JLabel("/"));
                panel_Fecha.add(new JTextField(2));
                panel_Fecha.add(new JLabel("/"));
                panel_Fecha.add(new JTextField(4)); 

		JLabel labNombre = new JLabel("Nombre",JLabel.CENTER);
		panelSuperior.add(labNombre);
		panelSuperior.add(textNombre);

		JLabel labApellidos = new JLabel("Apellidos",JLabel.CENTER);
		panelSuperior.add(labApellidos);
		panelSuperior.add(textApellidos);
                
                JLabel labFechaNacimiento = new JLabel("Fecha Nacimiento",JLabel.CENTER);
                panelSuperior.add(labFechaNacimiento);
                panelSuperior.add(panel_Fecha);

		final JRadioButton radioNormal = new JRadioButton("Normal",true);
		final JRadioButton radioVIP = new JRadioButton("VIP");
		ButtonGroup radioDNI = new ButtonGroup();

		JPanel panelRadios = new JPanel(new FlowLayout());

		panelRadios.add(radioNormal);
		panelRadios.add(radioVIP);

		radioDNI.add(radioNormal);
		radioDNI.add(radioVIP);


		JLabel labDNI = new JLabel("DNI",JLabel.CENTER);
		panelSuperior.add(labDNI);
		panelSuperior.add(textDNI);
		this.add(panelRadios, BorderLayout.CENTER);

		this.add(panelSuperior,BorderLayout.NORTH);	



		JButton boton_ok = new JButton("Aceptar");

		JButton boton_cancelar = new JButton("Cancelar");


		JPanel panelBotones = new JPanel(new GridLayout(1,2,5,5));
		panelBotones.add(boton_ok);
		panelBotones.add(boton_cancelar);

		this.add(panelBotones,BorderLayout.SOUTH);

		this.setBorder(new TitledBorder(new TitledBorder(""), "Alta Cliente", 
				TitledBorder.CENTER, TitledBorder.TOP ));		

	
		this.setVisible(true);
	}
/*    public static void main(String[] args) {
		JFrame frame = new JFrame("GUIAltaCliente");
		frame.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.getContentPane().add(new GUIAltaCliente(),
				BorderLayout.CENTER);
		frame.setSize(400, 400);
		frame.setVisible(true);
	}*/


    
    }   
    

