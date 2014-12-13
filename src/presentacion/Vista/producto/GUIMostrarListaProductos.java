/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.producto;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import negocio.producto.TProducto;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Eventos.EventoNegocio;

/**
 *
 * @author Ruben
 */
public class GUIMostrarListaProductos extends JFrame{
        
        Object[][] datos_entrada = {
        {"","", "", "", "", ""}
        };
        
        String[] NombreColumnas = {"ID","Nombre", "Precio", "Descripción", "Cod.Barras", "Stock"};

        JTextField textID = new JTextField("");

        JPanel panelSuperior = new JPanel(new GridLayout(2,2,5,5));
        JPanel panelTabla = new JPanel();

        JButton butID = new JButton("Buscar");
        JButton boton_salir = new JButton("Salir");
        
        JTable tabla;
    
    public GUIMostrarListaProductos(){
        this.setTitle("Mostrar Producto");
	setBounds(100, 100, 500, 300);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
                
		
            panelSuperior.add(textID);
            panelSuperior.add(butID);

            //se crea la Tabla
            tabla = new JTable(datos_entrada, NombreColumnas);
            //cojo la primera columna de la tabla (el ID) y fijo el tamaño de esa columna
            tabla.getColumnModel().getColumn(0).setPreferredWidth(3);
            //y el campo Stock tb
            tabla.getColumnModel().getColumn(5).setPreferredWidth(5);

            //dimensiones del Jtable
            tabla.setPreferredScrollableViewportSize(new Dimension(450, 70));
            //Creamos un JscrollPane y le agregamos la JTable
            JScrollPane scrollPane = new JScrollPane(tabla);
            panelTabla.add(scrollPane,BorderLayout.CENTER);

            boton_salir.setPreferredSize(new Dimension(90,40));
            JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT,15,15));
            panelBoton.add(boton_salir);

            this.add(panelSuperior,BorderLayout.NORTH);
   //         this.setBorder(new TitledBorder(new TitledBorder(""), "Mostrar Producto por ID", TitledBorder.CENTER, TitledBorder.TOP ));	

            this.add(panelTabla, BorderLayout.CENTER);
            this.add(panelBoton,BorderLayout.SOUTH);
            this.setVisible(true);
            
             butID.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    ArrayList<Object> datos = new ArrayList<>();
                    
                    
                    datos.add(new GUIMostrarListaProductos());
                    
                    Controlador.getInstance().accion(EventoNegocio.MOSTRAR_LISTA_PRODUCTOS, datos);
                    dispose();
                }
            });
        
        
        boton_salir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
               
            }
        });
        
 
    }
    //{"ID","Nombre", "Precio", "Descripción", "Cod.Barras", "Stock"};
    public void cargarProductoEnLista(ArrayList<TProducto> listaProducto)
    {
        DefaultTableModel dtm = new DefaultTableModel(0, 0);
        dtm.setColumnIdentifiers(NombreColumnas);
        
        tabla.setModel(dtm);
        for (TProducto producto : listaProducto)
            dtm.addRow(new Object[] {producto.getId(),producto.getNombre(), producto.getPrecio(), producto.getDescripcion(), producto.getCodigoDeBarras(), producto.getStock()});
        
        dtm.fireTableDataChanged();
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

    public JTextField getTextID() {
        return textID;
    }

    public void setTextID(JTextField textID) {
        this.textID = textID;
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
    
    
    
}
