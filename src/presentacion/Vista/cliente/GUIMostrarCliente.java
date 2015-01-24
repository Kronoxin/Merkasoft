/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.cliente;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Eventos.EventoNegocio;
import presentacion.Vista.producto.GUIMostrarProducto;



public class GUIMostrarCliente extends JFrame{
    Object[][] datos_entrada;
        String[] NombreColumnas = {"ID","Nombre", "Apellido", "Fecha Nacimiento"};

        JTextField textID = new JTextField("");

        JPanel panelSuperior = new JPanel(new GridLayout(2,2,5,5));
        JPanel panelTabla = new JPanel();
        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT,15,15));

        JLabel labID = new JLabel("ID del Cliente",JLabel.CENTER);

        JButton butID = new JButton("Buscar por ID");
        JButton boton_salir = new JButton("Salir");

        JTable tabla;
                
    
    public GUIMostrarCliente(){
        this.setTitle("Mostrar Cliente");
	setBounds(100, 100, 400, 300);
        this.setLocationRelativeTo(null);

        this.setLayout(new BorderLayout());
	
        panelSuperior.add(labID);
        panelSuperior.add(textID);
        panelSuperior.add(butID);

        //se crea la Tabla
        tabla = new JTable(datos_entrada, NombreColumnas);
        //cojo la primera columna de la tabla (el ID) y fijo el tamaño de esa columna
        tabla.getColumnModel().getColumn(0).setPreferredWidth(3);
        //dimensiones del Jtable
        tabla.setPreferredScrollableViewportSize(new Dimension(450, 70));
        //Creamos un JscrollPane y le agregamos la JTable
        JScrollPane scrollPane = new JScrollPane(tabla);
        panelTabla.add(scrollPane,BorderLayout.CENTER);


        boton_salir.setPreferredSize(new Dimension(90,40));
   
        panelBoton.add(boton_salir);

        //añadimos al panel de esta clase (MostrarCliente) cada panel individual
        this.add(panelSuperior,BorderLayout.NORTH);
    //    this.setBorder(new TitledBorder(new TitledBorder(""), "Mostrar Cliente por ID", TitledBorder.CENTER, TitledBorder.TOP ));	
        this.add(panelTabla, BorderLayout.CENTER);
        this.add(panelBoton,BorderLayout.SOUTH);
        
        this.setVisible(true);	
                
        //action listener
        butID.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    ArrayList<Object> datos = new ArrayList<>();
                    
                    datos.add(Integer.parseInt(textID.getText()));
                    datos.add(new GUIMostrarCliente());
                    
                    Controlador.getInstance().accion(EventoNegocio.MOSTRAR_CLIENTE, datos);
                    dispose();
                }
            });
        boton_salir.addActionListener(new ActionListener() 
        {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                dispose();
                }
        });
	}

    //getters y setter

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
    
    
}
