/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.cliente;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Ruben
 */
public class GUIBajaCliente extends JPanel{
    
    public GUIBajaCliente(){
        
        
        this.setLayout(new BorderLayout());

		final JTextField textID = new JTextField("");

		JPanel panelArriba = new JPanel(new GridLayout(1,2));

		JLabel labID = new JLabel("ID del Cliente",JLabel.CENTER);
		
		panelArriba.add(labID);
		panelArriba.add(textID);
		
		JButton butOK = new JButton("Aceptar");
		JButton butCancelar = new JButton("Cancelar");

		JPanel panelBotones = new JPanel(new GridLayout(1,2,10,10));
		panelBotones.add(butOK);
		panelBotones.add(butCancelar);

		this.add(panelArriba,BorderLayout.NORTH);
		this.add(panelBotones,BorderLayout.SOUTH);
		this.setBorder(new TitledBorder(new TitledBorder(""), "Baja Cliente", TitledBorder.CENTER, TitledBorder.TOP ));	
	

		
		

		this.setVisible(true);
	}
    
    
 /*       public static void main(String[] args) {
		JFrame frame = new JFrame("GUIAltaCliente");
		frame.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.getContentPane().add(new GUIBajaCliente(),
				BorderLayout.CENTER);
		frame.setSize(400, 400);
		frame.setVisible(true);
        }
        */
        
        
}
            
    
