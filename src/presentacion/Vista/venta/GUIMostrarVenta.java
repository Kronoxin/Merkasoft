/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.venta;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Ruben
 */
public class GUIMostrarVenta extends JFrame{
        Object[][] datos_entrada = {
        {new Integer(1),"Paco", new Integer(1), "item1", new Integer(10)},
        {new Integer(3), "Array",new Integer(2), "item2",new Integer(9)},
        {new Integer(2),"fdi",new Integer(3), "item55",new Integer(10)},
        {new Integer(7), "Marcus",new Integer(1), "ooh",new Integer(7)},
        {new Integer(4), "Angela",new Integer(13), "shit",new Integer(4)}
        };
        
        String[] NombreColumnas = {"ID Cliente","Nombre Cliente", "ID Producto", "Nombre Producto", "Cantidad"};
        
        
        JTextField textID = new JTextField("");

        JPanel panelSuperior = new JPanel(new GridLayout(2,2,5,5));
        JPanel panelTabla = new JPanel();
        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT,15,15));

        JLabel labID = new JLabel("ID de Veta",JLabel.CENTER);

        JButton butID = new JButton("Buscar por ID");
        JButton boton_salir = new JButton("Salir");

        JTable tabla;

    public GUIMostrarVenta(){
        this.setTitle("Mostrar Venta");
	setBounds(100, 100, 400, 300);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
    	
        panelSuperior.add(labID);
        panelSuperior.add(textID);
        panelSuperior.add(butID);

        //se crea la Tabla
        tabla = new JTable(datos_entrada, NombreColumnas);
        //cojo la primera columna de la tabla (el ID cliente) y fijo el tamaño de esa columna
        tabla.getColumnModel().getColumn(0).setPreferredWidth(3);
        //y el campo ID producto
        tabla.getColumnModel().getColumn(2).setPreferredWidth(3);
        //y el campo cantidad
        tabla.getColumnModel().getColumn(4).setPreferredWidth(5);


        //dimensiones del Jtable
        tabla.setPreferredScrollableViewportSize(new Dimension(450, 70));
        //Creamos un JscrollPane y le agregamos la JTable
        JScrollPane scrollPane = new JScrollPane(tabla);
        panelTabla.add(scrollPane,BorderLayout.CENTER);


        boton_salir.setPreferredSize(new Dimension(90,40));
       
        panelBoton.add(boton_salir);

        this.add(panelSuperior,BorderLayout.NORTH);
 //       this.setBorder(new TitledBorder(new TitledBorder(""), "Mostrar Venta por ID", TitledBorder.CENTER, TitledBorder.TOP ));	

        this.add(panelTabla, BorderLayout.CENTER);
        this.add(panelBoton,BorderLayout.SOUTH);
        
        this.setVisible(true);
        
    }
    
    //getters y setters
    public Object[][] getDatos_entrada() {
        return datos_entrada;
    }

    public void setDatos_entrada(Object[][] datos_entrada) {
        this.datos_entrada = datos_entrada;
    }

    public String[] getNombreColumnas() {
        return NombreColumnas;
    }

    public void setNombreColumnas(String[] NombreColumnas) {
        this.NombreColumnas = NombreColumnas;
    }

    public JPanel getPanelSuperior() {
        return panelSuperior;
    }

    public void setPanelSuperior(JPanel panelSuperior) {
        this.panelSuperior = panelSuperior;
    }

    public JPanel getPanelTabla() {
        return panelTabla;
    }

    public void setPanelTabla(JPanel panelTabla) {
        this.panelTabla = panelTabla;
    }

    public JPanel getPanelBoton() {
        return panelBoton;
    }

    public void setPanelBoton(JPanel panelBoton) {
        this.panelBoton = panelBoton;
    }

    public JLabel getLabID() {
        return labID;
    }

    public void setLabID(JLabel labID) {
        this.labID = labID;
    }

    public JButton getButID() {
        return butID;
    }

    public void setButID(JButton butID) {
        this.butID = butID;
    }

    public JButton getBoton_salir() {
        return boton_salir;
    }

    public void setBoton_salir(JButton boton_salir) {
        this.boton_salir = boton_salir;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public JTextField getTextID() {
        return textID;
    }

    public void setTextID(JTextField textID) {
        this.textID = textID;
    }
    
    
    
    
    
}
