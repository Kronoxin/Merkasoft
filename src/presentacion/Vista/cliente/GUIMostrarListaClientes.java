/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.cliente;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import negocio.cliente.TCliente;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Eventos.EventoNegocio;


/**
 *
 * @author Ruben
 */
public class GUIMostrarListaClientes extends JFrame{
    Object[][] datos_entrada = {
        {"","", "", ""}
        };
        ArrayList<TCliente> temp;
        String[] NombreColumnas = {"ID","Nombre", "Apellido", "Fecha Nacimiento"};
        JPanel panelSuperior = new JPanel();
        JPanel panelTabla = new JPanel();

        JLabel labID = new JLabel("Lista de Clientes",JLabel.CENTER);
        
        JButton boton_buscar = new JButton("Buscar");
        JButton boton_salir = new JButton("Salir");
        
        JTable tabla;
    
    public GUIMostrarListaClientes(){
        this.setTitle("Listar Clientes");
	setBounds(100, 100, 500, 300);
        this.setLocationRelativeTo(null);
        Controlador.getInstance().accion(EventoNegocio.MOSTRAR_LISTA_CLIENTES,null);
        this.setLayout(new BorderLayout());
        
        panelSuperior.add(boton_buscar);
        
        //se crea la Tabla
        
        tabla = new JTable(datos_entrada, NombreColumnas);
        
        //cojo la primera columna de la tabla (el ID) y fijo el tamaño de esa columna
        tabla.getColumnModel().getColumn(0).setPreferredWidth(2);
        
        //dimensiones del Jtable
        tabla.setPreferredScrollableViewportSize(new Dimension(450, 500));
        //Creamos un JscrollPane y le agregamos el JTable
        JScrollPane scrollPane = new JScrollPane(tabla);
        panelTabla.add(scrollPane,BorderLayout.CENTER);
        
            boton_salir.setPreferredSize(new Dimension(90,40));
            JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT,15,15));
            panelBoton.add(boton_salir);
        
      

        this.add(panelSuperior,BorderLayout.NORTH);
   //     this.setBorder(new TitledBorder(new TitledBorder(""), "Listado de todos los Clientes", TitledBorder.CENTER, TitledBorder.TOP ));	

        this.add(panelTabla, BorderLayout.CENTER);
        this.add(panelBoton,BorderLayout.SOUTH);
        this.setVisible(true);
        
        boton_buscar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                 ArrayList<Object> datos = new ArrayList<>();
                    
                    
                    datos.add(new GUIMostrarListaClientes());
                    
                    Controlador.getInstance().accion(EventoNegocio.MOSTRAR_LISTA_CLIENTES, datos);
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
    
     //{"ID","Nombre", "Apellidos", "DNI", "fecha_nacimiento", "ventas"};
    public void cargarClienteEnLista(ArrayList<TCliente> listaClientes)
    {
        DefaultTableModel dtm = new DefaultTableModel(0, 0);
        dtm.setColumnIdentifiers(NombreColumnas);
        
        tabla.setModel(dtm);
        for (TCliente cliente : listaClientes)
            dtm.addRow(new Object[] {cliente.getId(),cliente.getNombre(), cliente.getApellidos(), cliente.getDNI(), cliente.getFechaNacimiento(), cliente.getVenta()});
        
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
    