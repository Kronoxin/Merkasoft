/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.cliente;

import Negocio.cliente.TCliente;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.DateFormatter;
import sun.util.calendar.BaseCalendar;

/**
 *
 * @author Ruben
 */
public class GUIMostrarCliente extends JPanel{
    
    public GUIMostrarCliente(){
        Object[][] data = {
        {new Integer(1),"Paco", "Pino", new Date(1990, 12, 25)},
        {new Integer(3), "Array", "List",  new Date(1990, 12, 25)},
        { new Integer(2),"fdi", "ucm", new Date(1990, 12, 25)},
        { new Integer(7), "Marcus", "Andrews", new Date(1990, 2, 5)},
        {new Integer(4), "Angela", "Lalth",  new Date(1990, 2, 5)}
        };
        
        String[] NombreColumnas = {"ID","Nombre", "Apellido", "Fecha Nacimiento"};
        
        this.setLayout(new BorderLayout());

		final JTextField textID = new JTextField("");

		JPanel panelArriba = new JPanel(new GridLayout(2,2,5,5));
                JPanel panelTabla = new JPanel();

                JLabel labID = new JLabel("ID del Cliente",JLabel.CENTER);
                
		JButton butID = new JButton("Buscar por ID");
		panelArriba.add(labID);
		panelArriba.add(textID);
                panelArriba.add(butID);
                
                //se crea la Tabla
                JTable tabla = new JTable(data, NombreColumnas);
                //cojo la primera columna de la tabla (el ID) y fijo el tamaño de esa columna
                tabla.getColumnModel().getColumn(0).setPreferredWidth(2);
                
                //dimensiones del Jtable
                tabla.setPreferredScrollableViewportSize(new Dimension(400, 70));
                //Creamos un JscrollPane y le agregamos la JTable
                JScrollPane scrollPane = new JScrollPane(tabla);
                panelTabla.add(scrollPane,BorderLayout.CENTER);


		JButton butSalir = new JButton("Salir");

		butSalir.setPreferredSize(new Dimension(90,40));
		JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT,15,15));
		panelBoton.add(butSalir);
                
                this.add(panelArriba,BorderLayout.NORTH);
		this.setBorder(new TitledBorder(new TitledBorder(""), "Mostrar Cliente por ID", TitledBorder.CENTER, TitledBorder.TOP ));	
               
                this.add(panelTabla, BorderLayout.CENTER);
		this.add(panelBoton,BorderLayout.SOUTH);
                this.setVisible(true);


		
	}

}
