/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.venta;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Ruben
 */
public class GUIMostrarListaVentas extends JPanel{
    
    Object[][] datos_entrada = {
        {new Integer(1),"Paco", new Integer(1), "item1", new Integer(10)},
        {new Integer(3), "Array",new Integer(2), "item2",new Integer(9)},
        {new Integer(2),"fdi",new Integer(3), "item55",new Integer(10)},
        {new Integer(7), "Marcus",new Integer(1), "ooh",new Integer(7)},
        {new Integer(4), "Angela",new Integer(13), "shit",new Integer(4)}
        };
        
        String[] NombreColumnas = {"ID Cliente","Nombre Cliente", "ID Producto", "Nombre Producto", "Cantidad"};
        
        JPanel panelSuperior = new JPanel();
        JPanel panelTabla = new JPanel();

        JLabel labID = new JLabel("Lista de Ventas",JLabel.CENTER);
        JTable tabla;
    
    public GUIMostrarListaVentas(){
        this.setLayout(new BorderLayout());
        

         //se crea la Tabla
        tabla = new JTable(datos_entrada, NombreColumnas);
        //cojo la primera columna de la tabla (el ID cliente) y fijo el tamaño de esa columna
        tabla.getColumnModel().getColumn(0).setPreferredWidth(3);
        //y el campo ID producto
        tabla.getColumnModel().getColumn(2).setPreferredWidth(3);
        //y el campo cantidad
        tabla.getColumnModel().getColumn(4).setPreferredWidth(5);
        
        //dimensiones del Jtable
        tabla.setPreferredScrollableViewportSize(new Dimension(450, 500));
        //Creamos un JscrollPane y le agregamos el JTable
        JScrollPane scrollPane = new JScrollPane(tabla);
        panelTabla.add(scrollPane,BorderLayout.CENTER);
        panelSuperior.add(labID);

        this.add(panelSuperior,BorderLayout.NORTH);
        this.setBorder(new TitledBorder(new TitledBorder(""), "Listado de todas las Ventas", TitledBorder.CENTER, TitledBorder.TOP ));	
        this.add(panelTabla, BorderLayout.CENTER);

        this.setVisible(true);
        
        
    }

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

    public JLabel getLabID() {
        return labID;
    }

    public void setLabID(JLabel labID) {
        this.labID = labID;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }
    
    
    
}
