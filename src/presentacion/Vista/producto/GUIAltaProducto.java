/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.producto;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import negocio.cliente.TCliente;
import negocio.producto.TProducto;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Eventos.EventoNegocio;
import presentacion.Vista.cliente.GUIPrincipal_Cliente;


public class GUIAltaProducto extends JFrame{
    TProducto producto = new TProducto();
    
    JPanel panelSuperior = new JPanel();     
    JPanel panelBotones = new JPanel(new GridLayout(1,2,5,5));

    JTextField text_nombre = new JTextField("");
    JTextField text_precio = new JTextField("");
    JTextField text_descripcion = new JTextField("");
    JTextField text_codigo_barras = new JTextField("");
    JTextField text_stock = new JTextField("");

    JLabel label_nombre = new JLabel("Nombre",JLabel.CENTER);
    JLabel label_precio = new JLabel("Precio",JLabel.CENTER);
    JLabel label_descripcion = new JLabel("Descripción",JLabel.CENTER);
    JLabel label_codigo_barras = new JLabel("Cod Barras",JLabel.CENTER);
    JLabel label_strock = new JLabel("Stock",JLabel.CENTER);

    JButton boton_ok = new JButton("Aceptar");
    JButton boton_cancelar = new JButton("Cancelar");
    
    public GUIAltaProducto(){
        this.setTitle("Alta Producto");
	setBounds(100, 100, 400, 300);
        this.setLocationRelativeTo(null);
        
        this.setLayout(new BorderLayout());

        panelSuperior.setLayout(new GridLayout(5,2));

        //añadimos el Jlabel y el Jtextfield para el Nombre
        panelSuperior.add(label_nombre);
        panelSuperior.add(text_nombre);
        //añadimos el Jlabel y el Jtextfield para el Precio
        panelSuperior.add(label_precio);
        panelSuperior.add(text_precio);
        text_precio.setText("0.00");
        //añadimos el Jlabel y el Jtextfield para la descripción
        panelSuperior.add(label_descripcion);
        panelSuperior.add(text_descripcion);
        //añadimos el Jlabel y el Jtextfield para el Codigo de Barras
        panelSuperior.add(label_codigo_barras);
        panelSuperior.add(text_codigo_barras);
        //añadimos el Jlabel y el Jtextfield para el stock
        panelSuperior.add(label_strock);
        panelSuperior.add(text_stock);
        
        //añadimos el boton Aceptar y Cancelar al panelBotones
        panelBotones.add(boton_ok);
        panelBotones.add(boton_cancelar);

        //añadimos a este panel AltaProducto cada panel independiente
        this.add(panelSuperior,BorderLayout.NORTH);	
        this.add(panelBotones,BorderLayout.SOUTH);

        boton_ok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                producto.setNombre(text_nombre.getText());
                producto.setDescripcion(text_descripcion.getText());
                producto.setPrecio(Double.parseDouble(text_precio.getText()));
                producto.setCodigoDeBarras(text_codigo_barras.getText());
                producto.setStock(Integer.parseInt(text_stock.getText()));
               
                
                Controlador.getInstance().accion(EventoNegocio.ALTA_PRODUCTO, producto);
            }
        });
        
        
        boton_cancelar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        this.setVisible(true);

    }
    
    
    //getters y setters

    public JPanel getPanelSuperior() {
        return panelSuperior;
    }

    public void setPanelSuperior(JPanel panelSuperior) {
        this.panelSuperior = panelSuperior;
    }

    public JPanel getPanelBotones() {
        return panelBotones;
    }

    public void setPanelBotones(JPanel panelBotones) {
        this.panelBotones = panelBotones;
    }

    public JTextField getText_nombre() {
        return text_nombre;
    }

    public void setText_nombre(JTextField text_nombre) {
        this.text_nombre = text_nombre;
    }

    public JTextField getText_precio() {
        return text_precio;
    }

    public void setText_precio(JTextField text_precio) {
        this.text_precio = text_precio;
    }

    public JTextField getText_descripcion() {
        return text_descripcion;
    }

    public void setText_descripcion(JTextField text_descripcion) {
        this.text_descripcion = text_descripcion;
    }

    public JTextField getText_codigo_barras() {
        return text_codigo_barras;
    }

    public void setText_codigo_barras(JTextField text_codigo_barras) {
        this.text_codigo_barras = text_codigo_barras;
    }

    public JTextField getText_stock() {
        return text_stock;
    }

    public void setText_stock(JTextField text_stock) {
        this.text_stock = text_stock;
    }

    public JLabel getLabel_nombre() {
        return label_nombre;
    }

    public void setLabel_nombre(JLabel label_nombre) {
        this.label_nombre = label_nombre;
    }

    public JLabel getLabel_precio() {
        return label_precio;
    }

    public void setLabel_precio(JLabel label_precio) {
        this.label_precio = label_precio;
    }

    public JLabel getLabel_descripcion() {
        return label_descripcion;
    }

    public void setLabel_descripcion(JLabel label_descripcion) {
        this.label_descripcion = label_descripcion;
    }

    public JLabel getLabel_codigo_barras() {
        return label_codigo_barras;
    }

    public void setLabel_codigo_barras(JLabel label_codigo_barras) {
        this.label_codigo_barras = label_codigo_barras;
    }

    public JLabel getLabel_strock() {
        return label_strock;
    }

    public void setLabel_strock(JLabel label_strock) {
        this.label_strock = label_strock;
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
    
    
}
