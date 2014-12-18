/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Vista.cliente;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import negocio.cliente.TCliente;
import presentacion.Controlador.Controlador;
import presentacion.Controlador.Eventos.EventoNegocio;


/**
 *
 * @author Ruben
 */
public class GUIMostrarListaClientes extends JFrame{
        ArrayList<TCliente> temp;
        String[] NombreColumnas = {"ID","Nombre", "Apellido", "Fecha Nacimiento"};
        Object [][] datosEntrada;
        JPanel panelSuperior = new JPanel();
        JPanel panelTabla = new JPanel();

        JLabel labID = new JLabel("Lista de Clientes",JLabel.CENTER);
        
        JTable tabla;
    
    public GUIMostrarListaClientes(){
        this.setTitle("Listar Clientes");
	setBounds(100, 100, 450, 500);
        this.setLocationRelativeTo(null);
        Controlador.getInstance().accion(EventoNegocio.MOSTRAR_LISTA_CLIENTES,null);
        this.setLayout(new BorderLayout());
        //se crea la Tabla
        
        tabla = new JTable(datosEntrada, NombreColumnas);
        
        //cojo la primera columna de la tabla (el ID) y fijo el tamaño de esa columna
        tabla.getColumnModel().getColumn(0).setPreferredWidth(2);
        
        //dimensiones del Jtable
        tabla.setPreferredScrollableViewportSize(new Dimension(450, 500));
        //Creamos un JscrollPane y le agregamos el JTable
        JScrollPane scrollPane = new JScrollPane(tabla);
        panelTabla.add(scrollPane,BorderLayout.CENTER);
        panelSuperior.add(labID);

        this.add(panelSuperior,BorderLayout.NORTH);
   //     this.setBorder(new TitledBorder(new TitledBorder(""), "Listado de todos los Clientes", TitledBorder.CENTER, TitledBorder.TOP ));	

        this.add(panelTabla, BorderLayout.CENTER);

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
    