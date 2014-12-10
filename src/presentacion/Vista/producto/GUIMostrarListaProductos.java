/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.producto;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Ruben
 */
public class GUIMostrarListaProductos extends JPanel{
    
    public GUIMostrarListaProductos(){
       
        Object[][] datos_entrada = {
        {new Integer(1),"Paco", new Double(20.0), "Pino", "codBarr", new Integer(10)},
        {new Integer(3), "Array",new Double(100.23), "List","codBarr",  new Integer(9)},
        {new Integer(2),"fdi",new Double(12.2), "ucm","codBarr", new Integer(10)},
        {new Integer(7), "Marcus",new Double(10.0), "Andrews","codBarr", new Integer(7)},
        {new Integer(4), "Angela",new Double(25.0), "Lalth","codBarr",  new Integer(4)}
        };
        
        String[] NombreColumnas = {"ID","Nombre", "Precio", "Descripción", "Cod.Barras", "Stock"};
        
        this.setLayout(new BorderLayout());

        JPanel panelSuperior = new JPanel();
        JPanel panelTabla = new JPanel();

        JLabel labID = new JLabel("Lista de Productos",JLabel.CENTER);


        //se crea la Tabla
        JTable tabla = new JTable(datos_entrada, NombreColumnas);
        
        //cojo la primera columna de la tabla (el ID) y fijo el tamaño de esa columna
        tabla.getColumnModel().getColumn(0).setPreferredWidth(3);
        //y el campo Stock tb
        tabla.getColumnModel().getColumn(5).setPreferredWidth(5);
        
        //dimensiones del Jtable
        tabla.setPreferredScrollableViewportSize(new Dimension(450, 500));
        //Creamos un JscrollPane y le agregamos el JTable
        JScrollPane scrollPane = new JScrollPane(tabla);
        panelTabla.add(scrollPane,BorderLayout.CENTER);
        panelSuperior.add(labID);

        this.add(panelSuperior,BorderLayout.NORTH);
        this.setBorder(new TitledBorder(new TitledBorder(""), "Listado de todos los Productos", TitledBorder.CENTER, TitledBorder.TOP ));	

        this.add(panelTabla, BorderLayout.CENTER);

        this.setVisible(true);
                
        
        
        
            
    }
    
}
