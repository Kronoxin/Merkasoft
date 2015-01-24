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
import negocio.producto.TProducto;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Eventos.EventoNegocio;


public class GUIModificarProducto extends JFrame{
        Object[][] datos_entrada = {
        {"","", "", "", "", ""}
       };
        
        String[] NombreColumnas = {"ID","Nombre", "Precio", "Descripción", "Cod.Barras", "Stock"};

        JTextField textID = new JTextField("");
        JTextField text_idProd = new JTextField("");
        
        JPanel panelSuperior = new JPanel(new GridLayout(2,2,5,5));
        JPanel panelTabla = new JPanel();

        JLabel lab_idProd = new JLabel("ID del Producto",JLabel.CENTER);
        JLabel labID = new JLabel("ID del Producto",JLabel.CENTER);
        JButton butID = new JButton("Buscar por ID");
        JButton boton_salir = new JButton("Salir");
        
        JTable tabla;
        
        //Panel editar   
        JPanel panelEditar = new JPanel(new GridLayout(7,7,2,2));
        
        JButton boton_editar = new JButton("Editar");
        
        JTextField text_nombre = new JTextField("");
        JTextField text_precio = new JTextField("");
        JTextField text_descripcion = new JTextField("");
        JTextField text_codigo_barras = new JTextField("");
        JTextField text_stock = new JTextField("");

        JLabel label_nombre = new JLabel("Nombre",JLabel.CENTER);
        JLabel label_precio = new JLabel("Precio",JLabel.CENTER);
        JLabel label_descripcion = new JLabel("Descripción",JLabel.CENTER);
        JLabel label_codigo_barras = new JLabel("Cod Barras",JLabel.CENTER);
        JLabel label_stock = new JLabel("Stock",JLabel.CENTER);
    
    public GUIModificarProducto(){
        this.setTitle("Modificar Producto");
	setBounds(100, 100, 500, 300);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
       
            
            panelSuperior.add(labID);
            panelSuperior.add(textID);
            panelSuperior.add(butID);

            //se crea la Tabla
            tabla = new JTable(datos_entrada, NombreColumnas);
            //cojo la primera columna de la tabla (el ID) y fijo el tamaño de esa columna
            tabla.getColumnModel().getColumn(0).setPreferredWidth(3);
            //y el campo Stock tb
            tabla.getColumnModel().getColumn(5).setPreferredWidth(5);

            //dimensiones del Jtable
            tabla.setPreferredScrollableViewportSize(new Dimension(450, 15));
            //Creamos un JscrollPane y le agregamos la JTable
            JScrollPane scrollPane = new JScrollPane(tabla);
            panelTabla.add(scrollPane,BorderLayout.CENTER);

            boton_salir.setPreferredSize(new Dimension(90,40));
            JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT,15,15));
            panelBoton.add(boton_salir);

            //Panel edicion
            //añadimos el Jlabel y el Jtextfield para el Nombre
            panelEditar.add(label_nombre);
            panelEditar.add(text_nombre);
            //añadimos el Jlabel y el Jtextfield para el Precio
            panelEditar.add(label_precio);
            panelEditar.add(text_precio);
            text_precio.setText("0.00");
            //añadimos el Jlabel y el Jtextfield para la descripción
            panelEditar.add(label_descripcion);
            panelEditar.add(text_descripcion);
            //añadimos el Jlabel y el Jtextfield para el Codigo de Barras
            panelEditar.add(label_codigo_barras);
            panelEditar.add(text_codigo_barras);
            //añadimos el Jlabel y el Jtextfield para el stock
            panelEditar.add(label_stock);
            panelEditar.add(text_stock);
            //Añado el boton de edicion
            panelEditar.add(boton_editar);
            
            this.add(panelEditar,BorderLayout.AFTER_LINE_ENDS);
            
            this.add(panelSuperior,BorderLayout.NORTH);
   //         this.setBorder(new TitledBorder(new TitledBorder(""), "Mostrar Producto por ID", TitledBorder.CENTER, TitledBorder.TOP ));	

            this.add(panelTabla, BorderLayout.CENTER);
            //this.add(panelBoton,BorderLayout.SOUTH);
            
            this.setVisible(true);
            
             butID.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    ArrayList<Object> datos = new ArrayList<>();
                    
                    
                    datos.add(Integer.parseInt(textID.getText()));
                    datos.add(new GUIModificarProducto());
                    datos.add("MOD");
                    Controlador.getInstance().accion(EventoNegocio.MOSTRAR_PRODUCTO, datos);
                    dispose();
                }
            });
        
        boton_editar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                TProducto prod = new TProducto();
                prod.setActivo(true);
                prod.setId(Integer.parseInt(textID.getText()));
                prod.setNombre(text_nombre.getText());
                prod.setDescripcion(text_descripcion.getText());
                prod.setCodigoDeBarras(text_codigo_barras.getText());
                prod.setStock(Integer.parseInt(text_stock.getText()));
                prod.setPrecio(Double.valueOf(text_precio.getText()));
                Controlador.getInstance().accion(EventoNegocio.MODIFICAR_PRODUCTO, prod);
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
    public void cargarProductoEnLista(TProducto producto)
    {
        DefaultTableModel dtm = new DefaultTableModel(0, 0);
        dtm.setColumnIdentifiers(NombreColumnas);
        
        tabla.setModel(dtm);
        dtm.addRow(new Object[]
        {producto.getId(),producto.getNombre(), producto.getPrecio(), producto.getDescripcion(), producto.getCodigoDeBarras(), producto.getStock()});
        textID.setText(String.valueOf(producto.getId()));
        text_nombre.setText(producto.getNombre());
        text_descripcion.setText(producto.getDescripcion());
        text_codigo_barras.setText(producto.getCodigoDeBarras());
        text_stock.setText(String.valueOf(producto.getStock()));
        dtm.fireTableDataChanged();
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
}

