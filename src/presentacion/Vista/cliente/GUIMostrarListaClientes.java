/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.cliente;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.TitledBorder;


/**
 *
 * @author Ruben
 */
public class GUIMostrarListaClientes extends JPanel{
    
    public GUIMostrarListaClientes(){
        
        Object[][] datos_entrada = {
        {new Integer(1),"Paco", "Pino", new Date(1990, 12, 25)},
        {new Integer(3), "Array", "List",  new Date(1990, 12, 25)},
        { new Integer(2),"fdi", "ucm", new Date(1990, 12, 25)},
        { new Integer(7), "Marcus", "Andrews", new Date(1990, 2, 5)},
        {new Integer(4), "Angela", "Lalth",  new Date(1990, 2, 5)}
        };
        
        String[] NombreColumnas = {"ID","Nombre", "Apellido", "Fecha Nacimiento"};
        
        this.setLayout(new BorderLayout());

        JPanel panelSuperior = new JPanel();
        JPanel panelTabla = new JPanel();

        JLabel labID = new JLabel("Lista de Clientes",JLabel.CENTER);


        //se crea la Tabla
        JTable tabla = new JTable(datos_entrada, NombreColumnas);
        
        //cojo la primera columna de la tabla (el ID) y fijo el tamaño de esa columna
        tabla.getColumnModel().getColumn(0).setPreferredWidth(2);
        
        //dimensiones del Jtable
        tabla.setPreferredScrollableViewportSize(new Dimension(450, 500));
        //Creamos un JscrollPane y le agregamos el JTable
        JScrollPane scrollPane = new JScrollPane(tabla);
        panelTabla.add(scrollPane,BorderLayout.CENTER);
        panelSuperior.add(labID);

        this.add(panelSuperior,BorderLayout.NORTH);
        this.setBorder(new TitledBorder(new TitledBorder(""), "Listado de todos los Clientes", TitledBorder.CENTER, TitledBorder.TOP ));	

        this.add(panelTabla, BorderLayout.CENTER);

        this.setVisible(true);
    }

}
    